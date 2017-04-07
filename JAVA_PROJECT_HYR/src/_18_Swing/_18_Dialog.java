/**
 * 		[	Dialog	] : BorderLayout을 사용하고 있다.(layoutManager) : 동,서,남,북
 * 
 * 
 */
package _18_Swing;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class _18_Dialog {

	public static void main(String[] args) {
		JFrame f = new JFrame("Dialog");
		f.setBounds(1000, 100, 300, 400);

		Dialog d = new Dialog(f, "다이얼로그 title", true); // 모달 : 선택을 해야 다음으로 넘어갈 수
														// 있을 경우 지정
		d.setBounds(100, 100, 250, 400);

		d.setLayout(new FlowLayout()); // 기본 borderlayout을 flowlayout으로 변경

		JLabel l = new JLabel("정말 삭제합니까?");
		d.add(l);
		JButton b = new JButton("버튼");

		d.add(b); // BorderLayout 기준으로 배치됨

		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.dispose();
			}
		});
		
		d.setVisible(true);
		f.setVisible(true);
	}

}
