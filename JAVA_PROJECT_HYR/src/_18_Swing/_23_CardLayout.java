/**
 * 		[	CardLayout  ] : 포토샵의 레이어처럼 겹쳐서 표현
 * 
 */
package _18_Swing;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class _23_CardLayout {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(1000,100,400,400);
		CardLayout cl = new CardLayout();
		f.setLayout(cl);
		
		JButton[] j = new JButton[4];
		for (int i = 0; i < j.length; i++) {
			j[i] = new JButton("버튼" + (i+1) );
		}	
		f.add(j[0],"호랑이");
		f.add(j[1],"사자");
		f.add(j[2],"토끼");
		f.add(j[3],"다람쥐");
		
		class Event implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.next(f);
			}
			
		}
		Event m = new Event();
		
		for (int i = 0; i < j.length; i++) {
			j[i].addActionListener(m);
			
		}
		
		cl.show(f, "사자");
		cl.first(f);
		cl.last(f);
		cl.next(f);
		cl.previous(f);
		f.setVisible(true);
		
	}

}
