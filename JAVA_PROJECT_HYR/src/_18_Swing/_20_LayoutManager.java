/**
 * 		[	LayoutManager	] : 프레임크기를 줄이거나 늘려도 동적으로 배치를 바꿔주도록 할 수 있기 때문에 사용됨
 * 
 * 		: 컨테이너에 포함된 컴포넌트의 배치를 자동관리한다.
 * 	
 * 		-	BorderLayout : 상, 하, 좌, 우, 가운데로 배치
 * 		-	FlowLayout : Panel
 * 		-	GridLayout
 * 		-	CardLayout
 * 
 * 		-> Panel만 FlowLayout이고 그 외는 전부 BorderLayout으로 되어 있음
 * 			
 * 		Container : Panel, Window, Dialog, Frame
 * 				기본 레이아웃 매니저
 * 				: Panel : FlowLayout
 * 				  Window, Dialog, Frame : BorderLayout
 */
package _18_Swing;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

import javax.swing.JButton;

public class _20_LayoutManager {

	public static void main(String[] args) {
		Frame f = new Frame("BorderLayout");
		f.setBounds(1000,100,300,400);
		f.setLayout(new BorderLayout(10,50));
		
		// add 시에 레이아웃 배치 지정
		f.add(new JButton("East버튼3"), "East");
		f.add(new JButton("West버튼4"), "West");
		
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		p.add(new JButton("패널 북"), BorderLayout.NORTH);
		p.add(new JButton("패널 남"), BorderLayout.SOUTH);
		p.add(new JButton("패널 센터"), BorderLayout.CENTER);
		
		f.add(p,BorderLayout.CENTER);
		
		f.setVisible(true);
		
	}

}
