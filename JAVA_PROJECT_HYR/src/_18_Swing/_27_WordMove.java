/**
 * 		[	글자 이동  ]
 */
package _18_Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class _27_WordMove {
	static int Speed = 1;
	static int X,Y = 0;
	public static void main(String[] args) {
		
		final Frame f = new Frame("글자 이동");
		f.setBounds(1000,100,500,500);
		f.setLayout(null);
		f.setFont(new Font("Serif",Font.BOLD, 15));
		
		Label la = new Label("Speed : 1"); // 현재 스피드를 표시
		f.add(la);
		la.setBounds(50, 50, 100, 50);
		
		Label laMouse = new Label("x: 0, y:0"); // 현재 마우스 위치 출력
		laMouse.setBounds(50, 120, 200, 50);
		f.add(laMouse);
		
		Scrollbar sb = new Scrollbar(Scrollbar.HORIZONTAL, 1, 5, 1, 40);
		sb.setBounds(50,350,450,40);
		f.add(sb);
		
		// 이벤트 처리
		
		// 창닫기
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		// 스크롤바 변경시 : speed 값 변경 and 변경된 값을 Label에 표시
		sb.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int speed = ((Scrollbar)e.getSource()).getValue();
				la.setText("Speed : " + speed);
				Speed = speed;
			}
		});
		f.setVisible(true);
		
		
		Graphics g = f.getGraphics(); // 화면에 Frame을 띄운 뒤에 선언해야지 Frame이 visible되지 않은 상태에서는 읽어올 수 없다.
		
		// 프레임에서 마우스 이동시...
		f.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				X = e.getX();
				Y = e.getY();
				laMouse.setText("x: " + X + ", y: " + Y);
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				
			}
		});
		
		
		// 글자 이동(while문으로 반복하면서)
		
		int x = 50;
		while(true){
			g.drawString("황영롱", x, 300); // 글자를 그리기(50,300 위치에 황영롱 글씨를 그려라)
			g.drawString("*", X, Y);
			
			x += Speed;
			if ( x > 400 ) x = 50;
			g.drawLine(x, 10, x+500, 500);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e1) {}
			g.clearRect(50, 150, 500, 200); // 지움(자취를 지움)
		}
		
		
	}

}
