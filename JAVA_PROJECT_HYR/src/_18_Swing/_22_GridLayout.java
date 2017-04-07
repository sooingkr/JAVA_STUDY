/**
 * 		[	GridLayout	 ] : 바둑판 처럼 배치
 * 
 */
package _18_Swing;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;

public class _22_GridLayout {

	public static void main(String[] args) {
		Frame f = new Frame("GridLayout");
		f.setBounds(1000,100,400,400);
		
		f.setLayout(new GridLayout(2,3,10,50)); // 행, 열 값을 생성자에 넣어주어야 함
		f.setBackground(Color.yellow);
		f.add(new JButton("버튼1"));
		f.add(new JButton("버튼2"));
		f.add(new JButton("버튼3"));
		f.add(new JButton("버튼4"));
		f.add(new JButton("버튼5"));
		f.add(new JButton("버튼6"));

		f.setVisible(true);
		
	}

}
