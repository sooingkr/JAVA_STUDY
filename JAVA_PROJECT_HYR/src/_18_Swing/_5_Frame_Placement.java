package _18_Swing;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class _5_Frame_Placement {

	public static void main(String[] args) {
		final Frame f = new Frame("화면 배치"); // 종료 눌른 후에도 지역변수 사용할 수 있도록... final
		f.setBounds(1000,100,400,400);
		
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 창이 여러개일 때는 어떤 창이 눌렸는지 알 수 있어야 함!!! 
				// e라는 객체가 그 정보를 담고 있음.
				// e에 이벤트가 발생한 창의 정보가 들어 있음
				Frame ff = (Frame)e.getWindow();
				ff.dispose();
				// e.getWindow().dispose();
			}
		});
		
		// 화면 배치 담당 : '레이아웃 매니저'가 존재함
		
		f.setLayout(null); // 레이아웃 매니저 사용 안함
		// 레이아웃 매니저를 사용안하면 창의 크기 변화에 따라 내부에 배치된 녀석들에 변화가 없음(창의 크기에 맞게 동적으로 대응하지 않음)
		
		JButton b1 = new JButton("버튼1");
		b1.setBounds(0,100,100,100);
		f.add(b1);
		
		JButton b2 = new JButton("버튼2");
		b2.setBounds(100,100,100,100);
		f.add(b2);
		
		f.setVisible(true);
		final Frame f2 = new Frame("화면 배치2");
		f2.setBounds(300,300,400,400);
		f2.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		JButton b3 = new JButton("버튼3");
		b3.setBounds(0,100,100,100);
		f2.add(b3);
		f2.setVisible(true);
		
		
		
	}

}
