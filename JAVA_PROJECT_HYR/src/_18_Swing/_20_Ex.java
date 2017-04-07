package _18_Swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;

public class _20_Ex {

	public static void main(String[] args) {
		JFrame f = new JFrame("title");
		f.setBounds(1000,100,300,800);
		f.setLayout(new FlowLayout());
		
		Label l1 = new Label("B");
		f.add(l1);
		l1.setBackground(Color.red);
		
		
		Font f1 = new Font("Serif",Font.BOLD,15);
		f.setFont(f1);
		f.setVisible(true);
	}

}
