/**
 * 		[	Thread	]
 * 		- 프로세스 : 실행중인 프로그램, 자원과 쓰레드로 구성(프로세스와 프로세스는 독립적! 쓰레드와 쓰레드는 독립적이지 않음)
 * 		- 쓰레드 : 프로세스 내에서 실재 작업을 수행
 * 					  모든 프로세스는 하나 이상의 쓰레드를 가지고 있다.
 * 		ex) 프로세스 : 쓰레드 = 공장 : 일꾼
 * 
 * 		==> 쓰레드는 독자적인 스택을 가지고 나머지 영역은 하나의 프로세스 내에서 공유한다.
 * 
 * 		장점)
 * 			- 자원을 보다 효율적으로 사용할 수 있다.
 * 			- 응답성이 향상된다.
 * 		단점)
 * 			- 동기화에 주의해야 한다.
 * 			- 교착상태에 주의해야한다.
 * 
 * 		[생성방법]
 * 		1. Runnable 인터페이스 구현해 Thread 객체에 던져주기.(권장)
 * 		2. Thread 클래스를 상속받아서 run()메서드 오버라이딩하기
 * 			// 자바는 단일 상속만 허용해서 Thread를 상속시 다른 클래스 상속이 불가해 첫번째 방법이 더 선호된다.
 */
package _16_Thread;

public class _1_Thread {

	public static void main(String[] args) {
		Thread t1 = new MyThread();
		t1.start(); // run() vs start() => run은 현재 쓰레드에서 run메서드를 수행하는 것이고
		for (int i = 0; i < 1000; i++) {
			System.out.println("|");
		}
		// start()는 새로운 쓰레드를 생성해서 거기서 동작하도록 함 그니까 run()해보리면 메인쓰레드의 스택에서 동작하게 됨.
		// start()시 자신의 쓰레드 스택에서 동작하도록 되는 것
		Thread t2 = new Thread(){ // 쓰레드 클래스를 상속받는 익명클래스 이용한 방법
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("익명클래스 이용");;
			}
		};
		
		t2.start();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {}
		
		// runnable 인터페이스 구현해서 Thread 객체에 던져주는 방법
		Thread t3 = new Thread(new MyThread2());
		t3.start();
		
		Runnable r = new Runnable(){
			@Override
			public void run() {
				System.out.println("익명클래스 이용2");
			}
		};
		Thread t4 = new Thread(r);
		t4.start();
	}

}

class MyThread2 implements Runnable{
	@Override
	public void run() {
		System.out.println("runnable 구현하는 방법");
	}
}
class MyThread extends Thread{ // Thread를 상속받아 작성한다.
	@Override
	public void run() { // 동작메서드(run() 오버라이딩)
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			System.out.println("-");
		}
	}
}

