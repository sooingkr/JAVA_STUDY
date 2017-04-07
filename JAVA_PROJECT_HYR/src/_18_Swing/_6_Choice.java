/**
 * 		[	목록 상자 - Choice	]
 * 
 */
package _18_Swing;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class _6_Choice {

	public static void main(String[] args) {
		
		final Frame f = new Frame("Choice");
		f.setBounds(1000,100,400,400);
		///////////////////////////////////
		f.setLayout(null);
		Choice c = new Choice();
		c.setBounds(50,100,200,100);
		c.add("sun");
		c.add("mon");
		c.add("tue");
		c.add("wen");
		c.add("thu");
		c.add("fri");
		c.add("sat");
		c.add("지울 것");
		c.remove(7);
	//	c.remove("지울 것");
		c.insert("holi", 3); // 3번째 인덱스에 holi 추가
		System.out.println(c.getItemCount()); // 목록상자 항목의 수
		
		f.add(c);
		
		//////////////////////////////////
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
	} // end of main

} // end of class
