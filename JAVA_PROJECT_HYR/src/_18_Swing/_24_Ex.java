package _18_Swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;

public class _24_Ex {

	public static void main(String[] args) {
		JFrame f = new JFrame("EX");
		f.setBounds(1000, 100, 400, 400);

		f.setLayout(new BorderLayout());

		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 4));
		JButton j1 = new JButton("<<");
		JButton j2 = new JButton("<");
		JButton j3 = new JButton(">");
		JButton j4 = new JButton(">>");
		p.add(j1);
		p.add(j2);
		p.add(j3);
		p.add(j4);

		f.add(p, BorderLayout.SOUTH);
		
		Panel p2 = new Panel();
		CardLayout cardlayout  = new CardLayout();
		p2.setLayout(cardlayout);
		p2.setBackground(Color.yellow);
		f.add(p2,BorderLayout.CENTER);
		p2.setVisible(true);
		
		
		Panel pp1 = new Panel(); pp1.setBackground(Color.red);
		Panel pp2 = new Panel(); pp2.setBackground(Color.green);
		Panel pp3 = new Panel(); pp3.setBackground(Color.blue);
		Panel pp4 = new Panel(); pp4.setBackground(Color.YELLOW);
		p2.add(pp1,"red");
		p2.add(pp2,"green");
		p2.add(pp3,"blue");
		p2.add(pp4,"yellow");

		
		/////////////////////////////////////////////
		class Event implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( (JButton)e.getSource() == j1 ){
					cardlayout.first(p2);
				}
				if ((JButton)e.getSource() == j2){
					cardlayout.previous(p2);
				}
				if((JButton)e.getSource() == j3){
					cardlayout.next(p2);
				}
				if((JButton)e.getSource() == j4){
					cardlayout.last(p2);
				}
			}
			
		}
		Event e = new Event();
		j1.addActionListener(e);
		j2.addActionListener(e);
		j3.addActionListener(e);
		j4.addActionListener(e);
		
		
		
		f.setVisible(true);
	}

}
