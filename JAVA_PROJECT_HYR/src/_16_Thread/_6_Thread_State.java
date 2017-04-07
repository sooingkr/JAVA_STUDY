/**
 * 		[	Thread의 상태	 ]
 * 	1. NEW : 쓰레드 객체 생성된 상태
 * 2. RUNNABLE : 실행대기 상태로 start(실행) 가능 상태 : 스케줄링 대상이 될 수 있는 상태
 * 3. BLOCKED : synchronized된 임계영역에 의해 접근하지 못하고 있어 대기하고 있을 때(임계가 풀릴 때까지 대기하는 상태)
 * 		TimeWaited : sleep 등에 의함
 * 		Waiting : 깨워주기 전까지(notify() : 대기상태 중인 쓰레드를 꺠움-Object 클래스 메서드, wait()-Object의 메서드) 대기 상태
 */
package _16_Thread;

public class _6_Thread_State {

	public static void main(String[] args) throws InterruptedException {
		Bank b = new Bank();
		MyTT1 t1 = new MyTT1(b);
		MyTT2 t2 = new MyTT2(b);
		b.setThread(t1, t2);
		b.printState();
		
		t1.start();
		t2.start();
//		t1.stop();
//		t2.stop();
//		Thread.sleep(1000);
//		b.printState();
	}

}
