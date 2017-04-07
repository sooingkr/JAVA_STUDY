/**
 * 		[	Thread	]
 * 	
 * 		wait() : 내가 잠자기
 * 		wait(long ms) : 내가 잠자기 시간후 깨어남
 * 		notify() : 자고 있는 애 깨우기
 * 		notifyAll() : 자고있는 얘 다 깨우기
 * 		=> 두개는 synchronized 내에서만 사용할 수 있다.
 * 
 */
package _16_Thread;

public class _11_Thread_notify {

	public static void main(String[] args) {
		DB db = new DB();
		T1 tt1 = new T1(db);
		T2 tt2 = new T2(db);
	}	// end of main

} // end of class

class DB { // 데이터 관리
	
	synchronized void input() {
		System.out.println("입력했습니다.");
		notify(); // 나 실행했으니 너 실행해(일어나!) 난 잘꺼야
		try {
			wait();
		} catch (InterruptedException e) {}
	}
	synchronized void output() {
		System.out.println("출력했습니다.");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {}
	}
}

class T1 extends Thread {
	DB db;
	public T1(DB db) {
		this.db = db;
		// TODO Auto-generated constructor stub
	}
	public T1() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		while(true) {
			db.input();
		}
	}
}

class T2 extends Thread {
	DB db;
	public T2(DB db) {
		this.db = db;
		// TODO Auto-generated constructor stub
	}
	public T2() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		while(true) {
			db.output();
		}
	}
}