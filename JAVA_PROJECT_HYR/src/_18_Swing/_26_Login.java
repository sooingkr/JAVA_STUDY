package _18_Swing;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class _26_Login {

	static int r,g,b; // 0 ~ 255
	
	public static void main(String[] args) {
		Frame f = new Frame("LogIn");
		f.setBounds(1000, 100, 500, 500);
		Font fo = new Font("Serif", Font.BOLD, 20);
		f.setFont(fo);
		f.setLayout(new FlowLayout(Font.LAYOUT_LEFT_TO_RIGHT, 10, 5));
		
		
		Label l = new Label("id");
		f.add(l);
		TextField tfId = new TextField(10);
		f.add(tfId);
		Label l2 = new Label("pwd");
		f.add(l2);
		TextField tfPWD = new TextField(10);
		tfPWD.setEchoChar('*'); // 비밀번호 감추기
		f.add(tfPWD);
		Button ok = new Button("Login");
		f.add(ok);
		////////////////////////////
		Frame ff = new Frame("색상 변경");
		ff.setBounds(1000, 100, 400, 400);
		ff.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});

		ff.setBackground(new Color(r, g, b));
	

		ChangeR cr = new ChangeR();
		cr.start(); // 쓰레드 시작
		ChangeG cg = new ChangeG();
		cg.start(); // 쓰레드 시작
		ChangeB cb = new ChangeB();
		cb.start(); // 쓰레드 시작

		

		//////////////
		class MyEvent implements ActionListener { // Click 과 Enter 두개를 처리할 수 있는
													// 리스너
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼 클릭시 or TextField 의 엔터키 입력시 호출되는 콜백메서드

				// id, pwd 확인 후
				String id = tfId.getText();
				String pwd = tfPWD.getText();

				if (!("sooingkr".equals(id))) { // id 가 틀린 경우
					System.out.println("id 가 존재하지 않습니다.");
					tfId.requestFocus(); // 포커스 얻어오기
					tfId.selectAll(); // 틀린경우 쉽게 지울 수 있도록 블록 지정해 주기
				} else if (!"abcde".equals(pwd)) { // id 는 맞은 경우
					// id는 맞고, pw는 틀림
					System.out.println("pw가 다릅니다. 확인해 주세요.");
					tfPWD.requestFocus();
					tfPWD.selectAll();
				} else { // id와 pwd가 둘 다 맞는 경우
					System.out.println("Login Success");
					// 다음 화면 보여주기
					f.dispose(); // 내 프레임만 메모리에서 제거
					// 다음화면 보여주기
					// _27_ThreadShow show = new _27_ThreadShow();
					ff.setVisible(true);
				}

			}
		}

		MyEvent me = new MyEvent();
		ok.addActionListener(me);
		tfId.addActionListener(me);
		tfPWD.addActionListener(me);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		
		f.setVisible(true);
		while (true) {

			ff.setBackground(new Color(r, g, b));

		}
	}

}
