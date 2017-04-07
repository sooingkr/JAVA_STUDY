/**
 * 		[	TextArea	] : 여러줄 문자열 
 * 
 */
package _18_Swing;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class _14_TextArea {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setBounds(1000,100,300,600);
		f.setLayout(null);
		
		//TextArea ta = new TextArea();
		TextArea ta2 = new TextArea("대화내용입력",10,30,TextArea.SCROLLBARS_BOTH);
		ta2.setBounds(50,50,150,300);
		f.add(ta2);
		
		TextField tf = new TextField(20); // 20글자
		tf.setBounds(50,400,150,30);
		f.add(tf);
		
		JButton b = new JButton("전송");
		b.setBounds(200,400,70,30);
		f.add(b);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*String txt = ta2.getText() + tf.getText() + "\n";
				
				ta2.setText(txt);
				tf.setText("");*/
				ta2.append(tf.getText() + "\n");
				tf.setText("");
			}
		});
		/////////////////////////
		ta2.setEnabled(false); // 비활성화
		ta2.setEnabled(true); // 활성화
		ta2.setEditable(false); // 직접 입력하지 못하도록 막는 기능!
		////////////////////////
		ta2.requestFocus(); // 포커스 얻어오기
		ta2.selectAll(); // 전체 문자열 블럭지정
		ta2.select(2, 5); // index 2 ~ 5 까지 선택
		
		// TextField에 문자열 치고 엔터쳐도 전송될 수 있도록...

		
		tf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				tf.requestFocus();
				tf.setText("");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				tf.requestFocus();
				tf.setText("");
			}
		});
		tf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.getKeyCode() == KeyEvent.VK_ENTER ){
					ta2.append("\n" + tf.getText());
					tf.setText("");
				}
			}
		});
		
		f.setVisible(true);
		
	} // end of main

} // end of class
