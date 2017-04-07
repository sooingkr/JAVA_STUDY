package _18_Swing;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
 * 		[	화면 그리기 호출관계	]
 * 		repaint() -> update(Graphics g) -> paint(Graphics g)
 * 				repaint() : 계속 요청시 0.1초마다 update를 호출해줌
 * 				update(Graphics g) : 화면을 지우고, 다시 그림(paint를 호출해줌)
 * 				paint(Graphics g) : 화면을 그려줌
 * 
 */
public class _28_MouseEvent {

	public static void main(String[] args) {
		myFrame f = new myFrame("h");
	}// main
}

class myFrame extends Frame {
	int x, y;

	public myFrame(String title) {

		setBounds(1000, 100, 500, 400);

		// 이벤트
		// 창닫기
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		// 마우스 무브
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				// 화면 출력
				repaint();

			}
		});

		setLayout(null);
		Button b = new Button("지우기");
		b.setBounds(50, 350, 100, 30);
		add(b);

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g = getGraphics(); // 프레임에서 사용하는 그래픽 객체를 얻어옴
				g.clearRect(0, 0, getWidth(), getHeight());
			}
		});

		setVisible(true);

		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("C:\\DEV\\Workspace_HYR\\JAVA_PROJECT_HYR\\src\\_18_Swing\\img.jpg");

	}// myframe 생성자

	Image img; // 화면에 그려줄 이미지객체
	int h;
	int w;

	public void paint(Graphics g) {
		// g.drawString("@", x, y);
		// 이미지를 원하는 위치에 보여주기
		h = img.getHeight(this) / 2;

		w = img.getWidth(this) / 2;
		g.drawImage(img, x - w, y - h, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

}