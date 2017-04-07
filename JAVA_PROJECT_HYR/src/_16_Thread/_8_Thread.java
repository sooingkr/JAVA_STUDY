package _16_Thread;

import java.awt.Toolkit;
import java.util.Scanner;

public class _8_Thread {

	public static void main(String[] args) {
		Sign s = new Sign();
		s.start();

		// x 입력시 종료
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if ("x".equalsIgnoreCase(input)) {
				// Thread의 플래그로 Thread 정지시키기
				s.stop = true;
				System.out.println("신호등이 켜졌어요-건너세요.");
				// 남은 게이지만큼 출력
				for (int i = s.index; i < 10; i++) {
					System.out.println("ㅁ");
				}
				break;
			}
		}
		sc.close();
	}

}

class Sign extends Thread {
	boolean stop = false;
	int index = 0;

	@Override
	public void run() {
		Toolkit tk = Toolkit.getDefaultToolkit();

		while (!stop) {
			if (index == 10) {
				index = 0;
				System.out.println("\n신호등이켜졌어요-건너세요.");
			} else {
				System.out.println("ㅁ");
				index++;
				tk.beep(); // 소리 발생
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		
	}
}
