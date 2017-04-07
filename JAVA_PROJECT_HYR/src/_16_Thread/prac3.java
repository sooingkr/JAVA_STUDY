package _16_Thread;

public class prac3 {
	public static void main(String[] args) {
		DB2 d = new DB2();
		Th t1 = new Th(d);
		Th2 t2 = new Th2(d);
		
		t1.start();
		t2.start();
		
		t2.setDaemon(true);
	}
}

class DB2 { // 공통으로 접근하는 데이터
	
	synchronized void input() {
		System.out.println("입력");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized void output() throws InterruptedException {
		System.out.println("출력");
		notify();
		wait();
	}
	
}

class Th extends Thread {
	DB2 d;
	public Th() {
		// TODO Auto-generated constructor stub
	}
	public Th(DB2 d){
		this.d = d;
	}
	@Override
	public void run() {
		while(true){
			d.input();			
		}
	}
}

class Th2 extends Thread {
	DB2 d;
	public Th2() {
		// TODO Auto-generated constructor stub
	}
	public Th2(DB2 d){
		this.d = d;
	}
	@Override
	public void run() {
		while(true){
			try {
				d.output();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}