/**
 * 		[	Scrollbar	]
 * 
 */
package _18_Swing;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class _15_Scrollbar {

	public static void main(String[] args) {
		
		Frame f = new Frame("색상 변경");
		f.setBounds(1000,100,300,400);
		f.setLayout(null);
		
		Scrollbar sb = new Scrollbar(Scrollbar.HORIZONTAL,0,15,0,255);
		sb.setBounds(20,50,200,30);
		f.add(sb);
		
		sb.getValue(); // 현재 값(= 현재 위치) 0 ~ 255 사이(위에서 지정한)
		
		sb.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				System.out.println("현재위치 : " + sb.getValue());
				
				// 프레임의 배경색을 바꿔보기
				f.setBackground(new Color(sb.getValue(),0,0));
			}
		});
		
		Scrollbar sb2 = new Scrollbar(Scrollbar.HORIZONTAL,0,15,0,255+10);
		sb2.setBounds(20,80,200,30);
		f.add(sb2);
		
		
		Scrollbar sb3 = new Scrollbar(Scrollbar.HORIZONTAL,0,15,0,255+10);
		sb3.setBounds(20,110,200,30);
		f.add(sb3);
		
		
		class MyEvent implements AdjustmentListener{
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int r = sb.getValue();
				int g = sb2.getValue();
				int b = sb3.getValue();
				f.setBackground(new Color(r,g,b));
				
			}
		}
		MyEvent me = new MyEvent();
		sb.addAdjustmentListener(me);
		sb2.addAdjustmentListener(me);
		sb3.addAdjustmentListener(me);
		f.setBackground(new Color(0,0,0));
		f.setVisible(true);
		
	} // end of main

} // end of class
