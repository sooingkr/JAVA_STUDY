// join yeild
package _16_Thread;

public class prac2 {

	public static void main(String[] args) throws InterruptedException {
		
		test2 t2 = new test2();
		t2.start();
		t2.join();
		//t1.start();
		
		
		System.out.println(t2.a);
		
		
	}

}

class test extends Thread {
	int a;
	@Override
	public void run() {
		while(true){
			System.out.println(a++);
		}
	}
}


class test2 extends Thread {
	int a;
	@Override
	public void run() {
		for(int i=0; i<100000000; i++){
			a += i;
		}
		System.out.println("저장중");
	}
}