/**
 * 		[	FlowLayout	] : 공책에 작성하듯 좌->우 끝까지 치면 아래줄로 배치
 * 
 * 		Container 중 Panel만 default가 FlowLayout
 * 
 */
package _18_Swing;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;

public class _21_FlowLayout {

	public static void main(String[] args) {
		Frame f = new Frame("FlowLayout");
		f.setBounds(1000,100,300,400);
		f.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 50)); // 왼쪽 정렬
		
		f.add(new JButton("버튼1"));
		f.add(new JButton("버튼2"));
		f.add(new JButton("버튼3"));
		f.add(new JButton("버튼4"));
		f.add(new JButton("버튼5"));
		f.add(new JButton("버튼6"));
		f.add(new JButton("버튼7"));
		
		f.setVisible(true);
	}

}
