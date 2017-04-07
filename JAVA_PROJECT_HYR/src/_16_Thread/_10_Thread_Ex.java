// 지렁이 게임...
package _16_Thread;

import java.util.ArrayList;
import java.util.Scanner;

import _16_Thread.Game.Direct;

public class _10_Thread_Ex {

	public static void main(String[] args) {

		Game g = new Game();
		g.start(); // 게임 시작...

		Scanner scan = new Scanner(System.in);
		while (g.onGame) {
			// w a s d 로 상하좌우 처리...
			switch (scan.nextLine()) {
			case "w":
				g.dir = Game.Direct.UP;
				break;
			case "a":
				g.dir = Game.Direct.LEFT;
				break;
			case "s":
				g.dir = Game.Direct.DOWN;
				break;
			case "d":
				g.dir = Game.Direct.RIGHT;
				break;
			}
		}
	} // end of main

} // end of class

class Point {
	/** 2차원 좌표 x, y를 저장할 클래스 */
	int x, y;

	public Point() {
		this(0, 0);
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Point ){
			Point temp = (Point)obj;
			if ( this.x == temp.x && this.y == temp.y ){
				return true;
			}
		}
		return false;
	}
}

class Game extends Thread {

	boolean onGame = true; // 쓰레드 실행, 종료용 플래그 변수
	final int SIZE = 10; // map으로 쓸 배열의 크기(지렁이 지도 크기)
	boolean map[][] = new boolean[SIZE][SIZE]; // 행, 열
	ArrayList<Point> al = new ArrayList<Point>(); // 지렁이 몸통 좌표를 저장할 ArrayList :
													// 0: 머리, al.size() : 꼬리

	enum Direct { // 방향키 상수...
		UP, DOWN, LEFT, RIGHT
	}

	int dx[] = { 0, 0, -1, 1 }; // 열, 상하좌우
	int dy[] = { -1, 1, 0, 0 }; // 행, 상하좌우

	Direct dir; // 현재 방향

	public Game() { // 초기화작업...
		for (int i = 3; i >= 0; i--) {
			al.add(new Point(i, 0)); // 열, 행
			map[0][i] = true; // 행, 열
		}
		dir = Direct.RIGHT; // 최초 오른쪽 방향...

	}

	public void printMap() { // 맵 배열을 출력하는 메서드...
		for (int i = 0; i < SIZE; i++) { // i : 행, j : 열
			for (int j = 0; j < SIZE; j++) {
				System.out.print(map[i][j] ? "■" : "□");
			}
			System.out.println();
		}
	}

	/** 지렁이 한 칸 전진시키는 메서드... */
	public void move() {
		// 꼬리부분을 머리 앞으로 이동시키면 전진하는 것처럼 보임...
		// 오른쪽 방향으로 한 칸 전진
		// 꼬리 한 칸 제거, 머리 한칸 추가(진행방향 : 오른쪽...)
		Point LastP = al.get(al.size() - 1); // 마지막 칸 가지고 옴
		
		Point headP = al.get(0); // (현재)머리 가지고 오기

		int dirIndex = dir.ordinal(); // 현재 방향의 index
		int nextX = headP.x + dx[dirIndex]; // 오른쪽일 때 다음 이동할 머리좌표
		int nextY = headP.y + dy[dirIndex];

		Point nextP = new Point(nextX, nextY);
				
		// 이동시 배열 범위 밖으로 나가지 않도록 체크...
		// 뱀 몸통을 관통하지 않도록 체크...
		if ( 0 <= nextX && nextX < SIZE && 0 <= nextY && nextY < SIZE && // 배열 밖 안넘게...
				(!al.contains(nextP) || al.get(al.size()-1).equals(nextP) )// ArrayList(몸통 좌표)에 다음 이동할좌표가 포함되면 몸통관통! 조건 확인
				)
		{
			al.add(0, nextP); // 0번 인덱스에(앞쪽에) 머리 좌표를 추가
			al.remove(al.size() - 1);
			map[LastP.y][LastP.x] = false; // 꼬리칸 제거 열, 행
			map[nextP.y][nextP.x] = true; // 행, 열
		}else {
			System.out.println("Game Over!!");
			this.onGame = false;
		}

	}

	@Override
	public void run() {

		while (onGame) {
			// 지도 출력...
			printMap();
			try { // 1초마다 지도나올 수 있도록...
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			move(); // 한 칸 이동...
		}

	} // end of run

}