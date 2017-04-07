/**
 * 		[	interrupt	]
 * 		쓰레드 중지
 * 		1. 플래그 사용
 * 		2. interrupt()
 * 			or interrupted() : (interrupt가 일시정지 상태를 만들어야만 종료가된다면 interrupted는 일시정지 상태가 아니어도 Exception을 바로 발생시킴)
 * 		3. stop() : 사용 금지... 바로 즉시 종료해서 자원정리할 시간이 없음...
 */
package _16_Thread;

public class _11_Thread {

	public static void main(String[] args) throws InterruptedException {
		MyThread1 m1 = new MyThread1();
		m1.start();
		
		Thread.sleep(1000);
		// 쓰레드 종료시키는 첫번째 방법...
		m1.stop = true;
	
		
		// interrupt 잘 안씀.... 플래그 변수로 while문에 조건으로 주는걸 더 많이씀...
		MyThread3 m2 = new MyThread3();
		m2.start();
		m2.sleep(100); // 잠깐 일시정지를 줌
		m2.interrupt(); // 쓰레드가 일시정지(Waiting/Blocked) 상태일 경우 Exception을 만들어줌... 따라서 계속 실행중이면 멈추지 않음.
	
		MyThread4 m3 = new MyThread4();
		m3.start();
		Thread.sleep(1000);
		m3.interrupted(); // 쓰레드 종료(interrupt가 일시정지 상태를 만들어야만 종료가된다면 interrupted는 일시정지 상태가 아니어도 Exception을 바로 발생시킴)
	} // end of main

	
} // end of class

class MyThread1 extends Thread {
	boolean stop = false;
	// 쓰레드 종료 제어 방법 1
	@Override
	public void run() {
		while(!stop){
			System.out.println("쓰레드 반복중...");
		}
		System.out.println("자원정리...");
		System.out.println("쓰레드 종료...");
	}
}

class MyThread3 extends Thread {
	
	@Override
	public void run() {
		while(true){
			System.out.println("쓰레드 반복중...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { // interrupt 발생시...
				// TODO Auto-generated catch block
				System.out.println("일시정지로 인터럽트 동작하도록함...");
				break;
			}
		}
		System.out.println("자원정리...");
		//System.out.println("쓰레드 종료...");
	}
}

class MyThread4 extends Thread {
	// 쓰레드 종료 3번째 방법...
	@Override
	public void run() {
		while(true) {
			System.out.println("쓰레드4 반복중...");
			if (Thread.interrupted()){
				// interrupted가 발생한다면...
				break;
			}
		}
		System.out.println("자원정리...");
		System.out.println("쓰레드 종료...");
	}
}