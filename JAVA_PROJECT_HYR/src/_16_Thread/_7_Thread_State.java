/**
 * 		[	 Thread 상태	]
 */
package _16_Thread;

public class _7_Thread_State {

	public static void main(String[] args) {
		MyT3 m3 = new MyT3();
		StatePrintT st = new StatePrintT(m3);
		st.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {}
		m3.start();
	} // end of main

}// end of class

class StatePrintT extends Thread{ // 쓰레드의 상태를 출력
	Thread t; // 상태를 관찰할 쓰레드
	public StatePrintT(Thread t) {
		this.t = t;
	}
	@Override
	public void run() {
		while(true) {
			// 받아온 쓰레드의 상태를 계속 출력하기...
			System.out.println(t.getState());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}
class MyT3 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10000000; i++) {
			System.out.print("");
		}
		// 일시정지
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		for (int i = 0; i < 10000000; i++) {
			System.out.print("");
		}
	}
}
// 쓰레드의 상태를 출력