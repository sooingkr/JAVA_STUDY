package _18_Swing;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class _12_Login {
	static String id = "sooingkr";
	static String pwd = "dudfhd13";

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(100, 100, 500, 500);
		f.setLayout(null);
		Label l = new Label("id", Label.LEFT);
		l.setBounds(30, 50, 50, 20);
		f.add(l);

		TextField tf = new TextField();
		tf.setBounds(90, 50, 80, 20);
		f.add(tf);
		Label l2 = new Label("pw", Label.LEFT);
		l2.setBounds(30, 80, 50, 20);
		f.add(l2);

		TextField tf2 = new TextField();
		tf2.setBounds(90, 80, 80, 20);
		tf2.setEchoChar('*');
		f.add(tf2);

		JButton jb = new JButton("로그인");
		jb.setBounds(90, 100, 80, 50);
		f.add(jb);

		Label result = new Label();
		result.setBounds(50, 150, 100, 100);
		f.add(result);

		Font ff = new Font("Verdana",Font.BOLD,10);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tf.getText().equals("")) {
					result.setFont(ff);
					result.setText("빈칸입력 안됩니다.");
					return;
				}

				if (tf.getText().equals(id) && tf2.getText().equals(pwd)) {
					System.out.println("로그인 성공");
					result.setText("Login Success");
				} else {
					result.setText("Login Fail");
				}
			}

		});

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		f.setVisible(true);

	}

}
