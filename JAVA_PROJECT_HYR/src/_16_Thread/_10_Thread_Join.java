/**
 * 		[	join 메서드	]
 * 
 */
package _16_Thread;

import java.math.BigDecimal;

public class _10_Thread_Join {

	static Thread mainT;

	public static void main(String[] args) throws InterruptedException {
		mainT = Thread.currentThread();
		
		// Sum s = new Sum( Thread.currentThread() );
		Sum s = new Sum();
		s.start();

		s.join(); // s의 작업이 끝날 때까지 main은 기다리게 됨.
		// s 쓰레드가 run 메서드 끝내고 돌아올 때까지 내가 기다림..
		// main 쓰레드는 일시정지 상태(Waiting 상태)
		
		System.out.println(s.sum);
	}

}

class Sum extends Thread {
	int sum = 0;
	Thread maint; // 메인쓰레드 저장할 변수 선언
	// public Sum(Thread t) {
	// maint = t;
	// }

	public Sum() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() { // 1~10000
		for (int i = 0; i < 10000; i++) {
			sum += (i + 1);
			// // main 쓰레드의 상태를 출력
			// System.err.println( maint.getState() );
			// }
			System.out.println(_10_Thread_Join.mainT.getState());
		}
	}
}
