package _18_Swing;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

/**
 * Font 글자체, 스타일, 크기
 */
public class _19_Font {
	public static void main(String[] args) {
		Frame f = new Frame("글자체");
		f.setBounds(1000, 100, 300, 600);
		f.setLayout(new FlowLayout());
		
		f.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20)); 
		// Container 에 Font 를 설정하면 자식 객체에 모두 적용됨
		// 글자체 : Serif, SansSerif, Dialog, DialogInput, Monospaced
		// 스타일 : Font.PLAIN, Font.BOLD, Font.ITALIC, Font.BOLD | Font.ITALIC
		
		Label l1 = new Label("abcdefg1234안녕"); l1.setBackground(new Color(255,255,0));
		f.add(l1); l1.setFont(new Font("Serif", Font.BOLD, 20));
		
		Label l2 = new Label("abcdefg1234안녕"); l2.setBackground(new Color(255,0,0,255));
		f.add(l2); l2.setFont(new Font("SansSerif", Font.ITALIC, 20));
		
		Label l3 = new Label("abcdefg1234안녕"); l3.setBackground(Color.green);
		f.add(l3); l3.setFont(new Font("DialogInput", Font.PLAIN, 20));
		
		Label l4 = new Label("abcdefg1234안녕"); l4.setBackground(Color.CYAN);
		f.add(l4); l4.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 20));
		

		f.setVisible(true);
	} // end of main
} // end of class












