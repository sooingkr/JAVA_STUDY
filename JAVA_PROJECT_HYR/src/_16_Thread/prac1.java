package _16_Thread;

import java.util.Scanner;

public class prac1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HanGul te = new HanGul();
		HanGul t1 = new HanGul(te);
		Store t2 = new Store();
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		
		
		while(true){
			String exit = sc.next();
			if ( exit.equals("x") ){
				HanGul.go = false;
				Store.go = false;
				break;
			}
		}
		
	}

}

class HanGul extends Thread {
	static boolean go = true;
	int a;
	HanGul temp;
	HanGul(){}
	HanGul(HanGul t){
		temp = t;
	}
	@Override
	public void run() {
		temp.yield();
		while(go){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println(a++);
		}
	}
}

class Store extends Thread {
	static boolean go = true;
	@Override
	public void run() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {}
		
		System.out.println("4초마다 저장");
	}
}