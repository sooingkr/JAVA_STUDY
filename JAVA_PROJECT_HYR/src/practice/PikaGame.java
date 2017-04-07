package practice;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class PikaGame extends JFrame implements Runnable, KeyListener {
	Image img = null;
	Image img2 = null;
	Image img3 = null;
	static long startTime; // 게임 속도 제어를 위해 시작시간을 기록
	static long endTime; // same
	static long endTime2; // same
	private BufferedImage bi = null;
	private ArrayList msList = null;
	private ArrayList enList = null;
	private boolean left = false, right = false, up = false, down = false, fire = false;
	private boolean start = false, end = false;
	private int w = 400, h = 500, x = 130, y = 450, xw = 20, xh = 20;

	public PikaGame() {

		Toolkit tk = Toolkit.getDefaultToolkit();

		img = tk.getImage("C:\\DEV\\Workspace_HYR\\JAVA_PROJECT_HYR\\src\\practice\\pika.png"); // 피카츄
		img2 = tk.getImage("C:\\DEV\\Workspace_HYR\\JAVA_PROJECT_HYR\\src\\practice\\poketball.png"); // 떨어지는
																										// 포켓볼
																										// 이미지
		img3 = tk.getImage("C:\\DEV\\Workspace_HYR\\JAVA_PROJECT_HYR\\src\\practice\\item.jpg");
		bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

		msList = new ArrayList();
		enList = new ArrayList();
		this.addKeyListener(this);
		this.setSize(w, h);
		this.setTitle("돌아와! 피카츄~!!!");
		this.setResizable(false); // 크기조정 못하도록함
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void run() { // 포켓볼 생성 쓰레드
		try {
			int msCnt = 0;
			int enCnt = 0;
			while (true) {
				Thread.sleep(10);

				if (start) {
					if (enCnt > 2000) { // 포켓볼 생성 주기를 제어함
						enCreate();
						enCnt = 0;
					}
					if (msCnt >= 100) {
						fireMs();
						msCnt = 0;
					}
					msCnt += 10;
					enCnt += 17;
					keyControl();
					crashChk();
				}
				draw();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fireMs() {
		if (fire) {
			if (msList.size() < 100) {
				Ms m = new Ms(this.x, this.y);
				msList.add(m);
			}
		}
	}

	public void enCreate() {
		PikaGame.endTime2 = System.currentTimeMillis() / 1000;
		long diff = PikaGame.endTime2 - PikaGame.startTime;
		int n = 0; // 시간에 따라 포켓볼 생성 개수 제어 변수
		int r = (int) (Math.random() * 60);

		if (diff < 10) {
			n = 9;
		} else if (diff < 20) {
			n = 11;
		} else if (diff < 30) {
			n = 13;
		} else if (diff < 40) {
			n = 15;
		} else if (diff < 50) {
			n = 17;
		} else {
			n = 19;
		}
		for (int i = 0; i < n; i++) {
			if (r >= diff - 4 && r <= diff + 4) { // 아이템 랜덤 등장(itemFlag 를 true로)
				double rx = Math.random() * (w - xw);
				double ry = Math.random() * 50;
				Enemy en = new Enemy((int) rx, (int) ry);
				en.itemFlag = true;
				enList.add(en);
			} else { // 등장하지 않은 경우(일반 포켓몬볼)
				double rx = Math.random() * (w - xw);
				double ry = Math.random() * 50;
				Enemy en = new Enemy((int) rx, (int) ry);
				enList.add(en);
			}
		}
	}

	public void crashChk() {
		Graphics g = this.getGraphics();
		Polygon p = null;

		// 포켓볼 객체를 저장하고 있는 ArrayList 안의 포켓볼들의 좌표를 for문을 돌면서 현재 피카츄 객체와 좌표 영역이
		// 겹치는 부분이 있는지를 확인한다.
		for (int i = 0; i < enList.size(); i++) {
			Enemy e = (Enemy) enList.get(i);
			int[] xpoints = { x, (x + xw), (x + xw), x };
			int[] ypoints = { y, y, (y + xh), (y + xh) };
			p = new Polygon(xpoints, ypoints, 4);
			if (p.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h) && e.itemFlag) { // 아이템과 충돌한 경우
				long temp = PikaGame.startTime;
				
				PikaGame.startTime = System.currentTimeMillis() / 1000; // 시간에 따라 속도가 변하기 때문에 이렇게 세팅해줌.
				
				
			} else if (p.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) { // 충돌한 경우

				System.out.println("충돌했다! 게임 종료 처음부터!");
				PikaGame.startTime = System.currentTimeMillis() / 1000;
				enList.remove(i);
				start = false;
				end = true;
			}
		}
	}

	public void draw() {
		Graphics gs = bi.getGraphics();
		gs.fillRect(0, 0, w, h); // 화면 그리기(300,500)
		gs.setColor(Color.white); // 화면색
		gs.setColor(Color.blue); // 안내판 색

		//////////////////////////////
		gs.drawString("포켓볼의 수 : " + enList.size(), 300, 50); // 피할 똥 개수(180,50
																// 위치)에 표시

		gs.drawString("게임시작 : Enter", 300, 70);
		/////////////////////////////

		if (end) { // end 변수 : Game이 끝났음을 표시하는 boolean 변수(deafult : false)
			gs.drawString("G A M E     O V E R", 100, 250); // 게임이 끝나 end 변수값이
															// true가 되면 100,250
															// 위치에 Game Over를
															// 그려줌
		}
		/////////////////////////////

		gs.drawImage(img, x, y, this);
		// gs.fillRect(x, y, xw, xh); // 피카츄 그리기(130,450) 위치에 xw, xh 크기로 그림

		/*
		 * for (int i = 0; i < msList.size(); i++) { Ms m = (Ms) msList.get(i);
		 * gs.setColor(Color.red); gs.drawOval(m.x, m.y, m.w, m.h); if (m.y < 0)
		 * msList.remove(i); m.moveMs(); }
		 */

		for (int i = 0; i < enList.size(); i++) { // 저장되어 있는 포켓볼 개수만큼 돌면서 그려줌
			Enemy e = (Enemy) enList.get(i);

			if (e.itemFlag) { // itemFlag가 true인 경우는 조금 다르게 그림
				gs.drawImage(img3, e.x, e.y, this); // 아이템 이미지를 그려줄 것
				if (e.y > h) { // 화면 밖으로 넘어가면 제거
					enList.remove(i);
				}
			} else { // false인 경우는 일반 포켓몬 볼
				gs.drawImage(img2, e.x, e.y, this);
				// gs.fillRect(e.x, e.y, e.w, e.h);
				if (e.y > h) {
					enList.remove(i);
				}
				if (start != false) { // 게임 중지(포켓볼 떨어지기 멈추기)
					e.moveEn();
				}
			}

		}

		Graphics ge = this.getGraphics();
		// ge.drawImage(bi, 0, 0, w, h, this);
		ge.drawImage(bi, 0, 0, w, h, this);

	}

	public void keyControl() {
		if (0 < x) {
			if (left)
				x -= 3;
		}
		if (w > x + xw) {
			if (right)
				x += 3;
		}
		if (25 < y) {
			if (up)
				y -= 3;
		}
		if (h > y + xh) {
			if (down)
				y += 3;
		}
	}

	public void keyPressed(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_A:
			fire = true;
			break;
		case KeyEvent.VK_ENTER:
			start = true;
			end = false;
			break;
		}
	}

	public void keyReleased(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_A:
			fire = false;
			break;
		}
	}

	public void keyTyped(KeyEvent ke) {
	}

	public static void main(String[] args) {
		startTime = System.currentTimeMillis() / 1000; // 시간이 지남에 따라 속도를 제어하기 위해
														// 설정한 변수
		Thread t = new Thread(new PikaGame());
		t.start();
	}
}

class Ms {
	int x;
	int y;
	int w = 5;
	int h = 5;

	public Ms(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveMs() {
		y--;
	}
}

class Enemy {
	int x;
	int y;
	int w = 10;
	int h = 10;
	boolean itemFlag = false; // 아이템인지 아닌지를 판별

	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveEn() {

		Random r = new Random();
		int upDown = 0;
		int leftRight = 0;

		PikaGame.endTime = System.currentTimeMillis() / 1000; // 지난 시간을 계산하기
																// 위함(초단위로 속도
																// 제어할것임)
		long diffTime = PikaGame.endTime - PikaGame.startTime;

		// 떨어질 때 랜덤으로 나오는 값이 처음엔 크다가 점차 작아져야 많이 떨어지는 효과처럼 될듯
		if (diffTime < 10) {
			upDown = (r.nextInt(3)); // 0 ~ 2
			leftRight = (int) (Math.random() * 5) - 2; // -2 ~ 2
		} else if (diffTime < 20) {
			upDown = (r.nextInt(3)) + 1; // 1 ~ 3
			leftRight = (int) (Math.random() * 7) - 3; // -3 ~ 3
		} else if (diffTime < 30) {
			upDown = (r.nextInt(3)) + 2; // 2 ~ 4
			leftRight = (int) (Math.random() * 9) - 4; // -4 ~ 4
		} else if (diffTime < 40) {
			upDown = (r.nextInt(3) + 3); // 3 ~ 5
			leftRight = (int) (Math.random() * 11) - 5; // -5 ~ 5
		} else if (diffTime < 50) {
			upDown = (r.nextInt(3) + 4); // 4 ~ 6
			leftRight = (int) (Math.random() * 11) - 5; // -6 ~ 6
		} else if (diffTime < 60) {
			upDown = (r.nextInt(3) + 5); // 5 ~ 7
			leftRight = (int) (Math.random() * 15) - 7; // -7 ~ 7
		}
		y = y + upDown;
		x = x + leftRight;
	}
}

//////////////////////////////////////////////////////////////////
