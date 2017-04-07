/**
 * 		[	사용자 입력칸 : TextField	]
 * 
 */
package _18_Swing;

import java.awt.Frame;
import java.awt.TextField;

public class _11_TextField {

	public static void main(String[] args) {
		Frame f = new Frame("textField");
		f.setBounds(600,100,300,300);
		f.setLayout(null);
		
		TextField tf = new TextField(10); // default글씨, cols
		tf.setBounds(100,100,200,100);
		
		tf.setText("Default Value Setting");
		tf.setEchoChar('*'); // 비밀번호 입력할 때... 별로 표시되도록...(글자 대신 표현할 문자 지정)
		
		f.add(tf);
		
		
		
		f.setVisible(true);
	}

}
