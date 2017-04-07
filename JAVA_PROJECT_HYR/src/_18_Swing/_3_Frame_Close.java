/**
 * 		[		창 닫기	 ]
 * 
 */

package _18_Swing;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class _3_Frame_Close {

	public static void main(String[] args) {
		Frame f = new Frame("창 이벤트 처리");
		f.setBounds(500, 100, 200, 300);
		f.setVisible(true);
		
		// Framd 의 이벤트 처리...
		
		f.addWindowListener(new WindowListener() { // Frame에 윈도우 이벤트 적용...
			
			// [ 콜백 메서드들... ]
			// Frame 창이 열렸을 때 호출되는 콜백 메서드
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("windowOpened");
			}
			// 창이 최소화 되었을 때
			@Override
			public void windowIconified(WindowEvent e) {
				System.out.println("windowIconified");
			}
			// 창이 다시 활성화 되었을 때
			@Override
			public void windowDeiconified(WindowEvent e) {
				System.out.println("windowDeiconified");
			}
			// 비활성화 되었을 때
			@Override
			public void windowDeactivated(WindowEvent e) {
				System.out.println("windowDeactivated");
			}
			
			// 창 닫기 버튼 눌렀을 때 동작할 일을 지정
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.out.println("창닫기 버튼 눌렀어요 종료합니다.");
				//f.setVisible(false); 실제 종료 X 화면에서만 안보이게 되는 것(실제 이 객체는 여전히 존재)
				//f.dispose(); // 자원 반납(종료)
				System.exit(0); // 모든 프로그램 종료(모든 창 종료)
			}
			// 창을 닫을 때(실제 종료될 때 할 일을 지정)
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("windowClosed");
				
			}
			// 활성화 되었을 때
			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("windowActivated");
			}
		});
	}

}
