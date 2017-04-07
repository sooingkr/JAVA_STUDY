/**
 * 		[	CanVas	] : 도화지 => 그림이나 이미지, 글자를 올리는 객체
 * 
 */
package _18_Swing;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;

public class _16_Canvas {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("CanVas");
		f.setBounds(1000,100,300,400);
		
		Canvas c = new Canvas();
		c.setBounds(30,10,250,100);
		c.setBackground(Color.blue);
		f.add(c);
		
		
		
		f.setVisible(true);
	}

}
