/**
 * 		[	 동기화	]
		같은 객체에 접근하는 여러 쓰레드가 있다면, 하나의 쓰레드가 수행 중 다 수행되기 전에 다른 쓰레드로 흐름이 넘어가면
		불안정한 처리가 이루어 질 수 있는데
		이러한 문제를 위해
		동기화를 한다.(메서드나 블럭에 선언해서 임계영역을 지정하는 방식)
		
		동기화는 : 여러개의 쓰레드에서 동시에 접근하는 것을 방지하도록 한다. 
			synchronized를 선언한 블럭을 수행중에는 다른 쓰레드로 흐름이 넘어가지 않고 다른 쓰레드는 대기하고 있는다.
			
			메서드에 선언된 synchronized는 add를 수행중이라고 add만 들어오는걸 막는게 아니라, 동시에 synchronized 선언되어 있는
			
			sub 메서드또한 잠가버리고 add 수행이 완료시 임계영역을 오픈한다.
			
			하지만, add 수행 중에도 synchronized가 없는 일반 메서드는 다른 쓰레드가 들어갈 수 있다.
 */
package _16_Thread;

public class _5_Thread_Sync {
	
	public static void main(String[] args) {
		Bank b = new Bank();
		MyTT1 t1 = new MyTT1(b);
		MyTT2 t2 = new MyTT2(b);
		
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}

}


class Bank {
	int money = 100;
	Thread t1;
	Thread t2;
	synchronized void add(int num) { // synchronized 임계 영역
		money += num;
		// 현재 실행중인 쓰레드 이름 출력
		Thread currentTh = Thread.currentThread();
		System.out.println( currentTh.getName() + " 입금 : " + money);
		printState();
	}
	
	// synchronized 임계 영역
	synchronized void sub(int num){ // 출금
		money -= num;
		System.out.println(Thread.currentThread().getName() + "출금 : " + money);
		printState();
	}
	void setThread(Thread t1, Thread t2) { // 쓰레드를 전달 받음
		this.t1 = t1;
		this.t2 = t2;
	}
	void printState() { // 쓰레드의 상태 출력
		System.out.println("호랑이 : " + t1.getState() + ", 코끼리 : " + t2.getState());
	}
}

class MyTT1 extends Thread {
	Bank b;
	
	public MyTT1() {
		// TODO Auto-generated constructor stub
	}
	public MyTT1(Bank b){
		this.b = b;
		setName("호랑이 쓰레드");
	}
	@Override
	public void run() { // 은행에 돈 입금
		while(true) {
			b.add(1);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {}
		}
	}
}


class MyTT2 extends Thread {
	Bank b;
	
	public MyTT2() {
		// TODO Auto-generated constructor stub
	}
	public MyTT2(Bank b){
		this.b = b;
		setName("코끼리 쓰레드");
	}
	@Override
	public void run() { // 은행에 돈 입금
		while(true) {
			b.sub(1);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {}
		}
	}
}