/**
 * 		[	yield()	] : 우선순위가 자신과 같거나 더 높은 쓰레드에게 실행을 양보함
 */
package _16_Thread;

public class _9_Thread_Yield {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("|");
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				while (true) {
					Thread.yield(); // 우선순위가 자신과 같거나 더 높은 쓰레드에게 양보함
					
					System.out.println("-");
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//					}
				}
			}
		});
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();

	}

}
