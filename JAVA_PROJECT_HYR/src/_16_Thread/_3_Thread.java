/**
 * 		[	Thread Name	 ]
 * 
 */
package _16_Thread;

public class _3_Thread {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				int a = 1;
				while (true) {
					setName("t1 Thread Name"); // 메서드호출해 이름지을수도 있고... 생성자에 넣어줄 수도 있음
					System.out.println(getName()); // Thread의 getName() 메서드
					try {
						Thread.sleep(1000); // 1초마다 a와 쓰레드 이름 출력
					} catch (InterruptedException e) {
					}
				}
			}
		};

		Thread t2 = new MyR("t2쓰레드");

		Thread t3 = new Thread(new MyR()); 
		
	
		t1.start();
		t2.start();
		t3.start();
	
		
		Thread currentThread = Thread.currentThread();
		// 현재 실행중인 쓰레드
		System.out.println("메인의 쓰레드 이름 : " + currentThread.getName());
	}

}

class MyR extends Thread {
	
	public MyR(String name) {
		// 쓰레드 이름 설정
		super(name);
	}
	public MyR() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		while (true) {
			
			System.out.println(getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
		}
	}
}
