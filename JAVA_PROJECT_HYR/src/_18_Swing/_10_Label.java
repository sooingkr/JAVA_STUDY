/**
 * 		[	화면에 글자를 표시하는 컴포넌트 : Label	]
 * 
 */
package _18_Swing;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;

public class _10_Label {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(600,100,300,200);
		
		Label l = new Label("hello", Label.CENTER); 
		
		f.setLayout(null);
		l.setBounds(100,100,100,50);
		// (글씨, 정렬방식) 
		l.setBackground(Color.ORANGE);
		l.setAlignment(Label.RIGHT);
		l.setText("modify Text");
		l.getText(); // 문자열 가지고 오기
		
		f.add(l);
		
		f.setVisible(true);
	}

}
