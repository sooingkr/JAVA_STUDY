package _16_Thread;

import java.util.Scanner;

import javax.print.StreamPrintService;

public class _2_Thread {

	public static void main(String[] args) {
		MyT1 mt1 = new MyT1();
		Thread t = new Thread(mt1);
		//MyT1 m1 = new MyT1();
		MyT2 m2 = new MyT2();
		t.start();
		m2.start();

		Scanner sc = new Scanner(System.in); // 사용자가 x를 입력하면 프로그램 전체 종료
		while (true) {
			String input = sc.nextLine();
			if ("x".equalsIgnoreCase(input)) {
				// 다른 쓰레드 종료
				/*
				 * m1.stop(); // Thread가 즉시 종료됨 문제점: 자원의 처리(반환,닫기) 등의 처리가 불완전해짐
				 * : 하던일 내팽겨쳐버리고 중지해버림 // 따라서 deprecated 됨. m2.stop();
				 */
				mt1.go = false; // 즉시 종료되지 않고 while문 빠져나가 자원정리 부분까지 실행하고 리턴될 수 있게 됨.
				m2.go = false;
				break;
			}
		}
		System.out.println("메인 종료됨");
	}

}

class MyT1 implements Runnable {
	boolean go = true; // 쓰레드 실행중인지 체크

	@Override
	public void run() {
		int a = 1;
		while (go) {
			try {
				Thread.sleep(1000);
				System.out.println(a++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 자원 정리
		System.out.println("MyT1 종료");

	}
}

class MyT2 extends Thread {
	boolean go = true;

	@Override
	public void run() {
		while (go) {
			try {
				Thread.sleep(4000);
				System.out.println("저장");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("MyT2 종료");
	}
}
