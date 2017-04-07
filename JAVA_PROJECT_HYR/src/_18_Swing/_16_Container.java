/**
 * 		[	Container	]
 * 		-	FlowLayout : 일반적으로 순차적으로 배치하는 형태 -> ex)Panel
 * 					[	panel		] : 타이틀바 영역이 없고, 독립적으로는 사용이 불가하다.
 * 				
 * 		-	BorderLayout : 
 * 
 */
package _18_Swing;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;

public class _16_Container {

	public static void main(String[] args) {
		JFrame f = new JFrame("컨테이너");
		f.setBounds(1000,100,800,800);
		f.setLayout(null);
		
		Panel p = new Panel();
		p.setBounds(50,50,300,250);
		p.setBackground(Color.YELLOW);
		// Panel은 Flowlayout Manager가 적용되어 있음
		
		JButton b1 = new JButton("버튼1");
		JButton b2 = new JButton("버튼2");
		p.add(b1);
		p.add(b2);
		JButton b3 = new JButton("버튼3");
		JButton b4 = new JButton("버튼4");
		p.add(b3);
		p.add(b4);
		
		f.add(p);
		
		f.setVisible(true);
	}

}
