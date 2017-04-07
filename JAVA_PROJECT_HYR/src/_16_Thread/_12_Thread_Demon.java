/**
 * 		[	데몬 쓰레드	 ]
 *		: 종속 쓰레드로... 주로 저장기능 등을 담당함..
 *		독립쓰레드일 때 A프로그램이 끝났는데도 저장 기능이 계속 돌고있으면 말도안됨...따라서 종속쓰레드로 구현되야함... 	
 *
 *		=> 주 쓰레드가 죽으면 같이 종료되게 됨... 즉 주 쓰레드의 종속 쓰레드!
 *
 *		방법) setDaemon(true)	
 */
package _16_Thread;

public class _12_Thread_Demon {

	public static void main(String[] args) {
		
		AutoSave as = new AutoSave();
		as.setDaemon(true); // 데몬 쓰레드 지정...(반드시...start 전에 설정되어야 한다...)
		// 주 쓰레드가 종료되면 데몬 쓰레드도 종료됨...
		// 작성중인 곳이 주 쓰레드가 됨
		
		as.start();
		for (int i = 0; i < 7; i++) {
			System.out.println("문서작업...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}			
		}
		System.out.println("main 쓰레드 종료... : 문서 작업 끝!!"); 
	} // end of main

} // end of class

/** 문서 자동 저장 */
class AutoSave extends Thread {
	@Override
	public void run() {
		while(true){ // 2초마다 문서를 자동으로 저장하기...
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			System.out.println("문서 변경내용 저장" + isDaemon()); // Daemon 쓰레드인지 확인하는 메서드...
		}
	}
}