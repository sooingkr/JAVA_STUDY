/**
 * 		[	_3_Frame_Close에서 한 방법은 WindowListener 인터페이스를 구현해서 내부적으로 쓰지 않을 모든 메서드까지 오버라이딩해야
 * 			
 * 			사용할 수 있었다. 내가 사용하고 싶은 메서드만 사용할 수 있도록 "어뎁터를 지원한다"	]
 * 
 */
package _18_Swing;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class _4_Frame_Close2 {

	public static void main(String[] args) {
		final Frame f = new Frame("title"); // ??
		// final 붙이는 이유 :
			// Frame을 실행하는 awt는 별도의 쓰레드에서 수행이 되는데
			// 메인 쓰레드가 종료된 다음에 사용자가 창을 클릭할 수도 있음
			// 따라서, 메인메서드가 먼저 종료된 이후에는 해당 지역변수는 존재하지 않게됨으로
			// final 선언해주거나 클래스의 전역변수로 등록해 주어야 한다.
		
		f.setBounds(100,100,300,400);
		f.setVisible(true);
		
		// 어댑터 클래스를 구현하면 원하는 것만 구현가능
		// 클래스기 때문에 다 오버라이딩할 필요 없음
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 닫기 x 버튼을 눌렀을 때 호출되는 콜백 메서드
				f.dispose();
			}
		});
		
	}

}
