package _18_Swing;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class _29_GUI {

	public static void main(String[] args) {
		MyFrame2 f = new MyFrame2();
	
	}

	
}


class MyFrame2 extends Frame{
	public MyFrame2() {
		setBounds(1000,100,400,500);
		
		setVisible(true);
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString("안녕하세요", 50, 50);
		g.drawLine(0, 0, 100, 100);
		g.setColor(Color.red);
		g.drawLine(100, 100, 200, 100);
		g.drawOval(100, 100, 100, 50); // 타원
		
		g.setColor(Color.blue); // 색 변경
		g.drawRect(200, 100, 100, 50); // 사각형 껍데기
		
		g.fillRect(310, 100, 80, 50); // 사각형 채우기
		g.setColor(Color.yellow);
		
		g.drawRoundRect(50, 200, 100, 200, 30, 30);
		g.fillRoundRect(200, 200, 100, 200, 30, 30);
		
		g.fillArc(50, 400, 100, 100, 0, 120);
	}
}
