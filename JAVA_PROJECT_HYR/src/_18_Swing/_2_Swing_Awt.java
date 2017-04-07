/** 
 * 		[	Frame 만들기	 ] : 왼쪽 맨 위가 좌표 기준
 * */
package _18_Swing;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;

import javax.script.ScriptException;

public class _2_Swing_Awt {

	public static void main(String[] args) {
		// 모니터 한가운데에 Frame을 띄우기 : 사이즈(200,200), 화면의 중간선에 오게
		final Frame f = new Frame("나의 프레임 이름");
		f.setSize(200,200);
	    //f.setSize(new Dimension(200, 200));
		//f.setBounds(700, 300, 200, 200);  size와 location을 둘 다 지정하는 방법
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize(); // 스크린 사이즈 가지고 오기
		System.out.println(dimension.getWidth());
		System.out.println(dimension.getHeight());
		double h = dimension.getHeight();
		double w = dimension.getWidth();
		int fh = f.getSize().height; // dimension 객체로부터 int형 높이를 가지고 옴
		int fw = f.getSize().width;
		
		f.setLocation((int)w/2 - (fw/2), (int)h/2 - (fh/2) ); 
		//f.setLocation((w-fw)/2, (h-fh)/2 ); same 
		
		f.setTitle("프레임 타이틀 이름 설정2");
		System.out.println(f.getTitle());
		f.setVisible(true);
	}

}
