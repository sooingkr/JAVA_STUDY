package _18_Swing;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * AWT
 * Swing
 * FX
 */
public class TestGUI {
	public static void main(String[] args) {
		Frame f = new Frame("프레임"); // 윈도우 창
		f.setSize(300, 400); // 크기 지정
		f.setLocation(100, 200); // 모니터 기준의 위치 설정
//		f.setBounds(100, 200, 300, 400); // 위치와 크기 지정
		
		final JButton b = new JButton("난 버튼");
		b.setSize(100, 100); // 크기지정
		b.setLocation(100, 50); // 창 기준의 위치 지정
		b.setText("넌 버튼이다"); // 버튼의 글자 변경
		System.out.println("버튼문구 : "+b.getText());
		f.add(b);
		
		
		// 버튼 클릭시 이벤트 처리하기
		b.addActionListener(new ActionListener() {
			int num = 0;
			public void actionPerformed(ActionEvent e) {
				// 버튼 클릭시 호출되는 콜백 메서드
//				System.out.println("버튼 클릭함" + ++num);
				// 버튼에 글자를 변경
				b.setText(num++ +"");
	// 내 클래스에서 사용하는 변수가 다른 클래스의 지역변수일경우
//				1. 전역변수로 선언하기
//				2. final 로 선언하기
			}
		});
		f.setVisible(true); // 화면에 보이기 (마지막에 보여주기)
		
		
	} // end of main
} // end of class












