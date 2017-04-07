/**
 * 		[	Thread	용어	]
 * 		- 동시성(Concurrency) : 1코어에서 다수의 '쓰레드'를 번갈아가면서 실행하는 성질(동시처럼 느껴지도록...)
 * 		- 병렬성(Parallelism) : 다수의 코어에서 개별 '쓰레드' 하나씩 실행하는 성질
 * 		- 스케줄링 : 여러개의 쓰레드를 어떤 순서에 의해 동시성으로 실행할 것인지 
 * 		- 우선순위 : 1~10 : 1이 최소값 5기본값 10이 최대값
 */
package _16_Thread;

public class _4_Thread {

	public static void main(String[] args) {

		Thread t1 = new Thread() {
			@Override
			public void run() {
				int a = 1;
				setName("t1쓰레드");
				while (true) {
					System.out.println(getName() + " : " + (a++) );
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//					}
				}
			}
		}; // end of Thread t1

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Thread myThread = Thread.currentThread();
				myThread.setName("t2쓰레드");
				int a = 1;
				while(true) {
					System.out.println( myThread.getName() + " : " + (a++) );
//					try {
//						//Thread.sleep(100);
//					} catch (InterruptedException e) {}
				}
				
			}
		}); // end of Thread t2
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(1);
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(Thread.currentThread().getPriority());
		t1.start();
		t2.start();

	} // end of main

} // end of class
