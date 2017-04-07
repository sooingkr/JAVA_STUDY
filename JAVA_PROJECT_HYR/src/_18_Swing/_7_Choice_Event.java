package _18_Swing;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class _7_Choice_Event {

	public static void main(String[] args) {
		final Frame f = new Frame("title");
		f.setBounds(100,100,800,800);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		
		f.setLayout(null);
		
		
		final Choice c = new Choice();
		c.setBounds(200,40,200,200);
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		c.add("five");
		c.add("six");
		f.add(c);
		
		c.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		final JButton button = new JButton("버튼");
		button.setBounds(100,40,100,100);
		/*button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼 클릭시 호출되는 콜백 메서드
				System.out.println(c.getSelectedItem());;
			}
		});*/
		button.addMouseListener(new MouseAdapter() { // 버튼에 이벤트 처리 달기
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("선택된 값 : " + c.getSelectedItem());
			}
		});
		
		f.add(button);
		
		
		// choice에 이벤트 적용하기
		c.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println( "선택된 아이템 " + e.getItem() );
			//	System.out.println("선택하는 방법 : " + c.getSelectedItem());
				System.out.println( ((Choice)e.getSource()).getSelectedItem() );
			}
		});
		
		f.setVisible(true);
	}

}
