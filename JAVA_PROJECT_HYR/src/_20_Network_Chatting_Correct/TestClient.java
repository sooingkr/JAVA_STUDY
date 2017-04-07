package _20_Network_Chatting_Correct;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashSet;

import javax.swing.JOptionPane;

/**
 * 서버와 통신하는 client
 * main 메서드에서는 사용자가 콘솔창에 작성한 내용을 전송
 * ClientRecever 객체 - 서버에서 보내오는 메시지를 받기위한 쓰레드
 */
public class TestClient extends Frame {
	HashSet<Client> clientSocket=new HashSet<Client>();
	TextArea ta = new TextArea();
	TextField tf = new TextField();
	DataOutputStream dos;
	String name = "";
	public TestClient(String title) {
		super(title);
		setBounds(650, 100, 300, 500);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		
		ta.setEditable(false);
		add(ta);
		
		add(tf, BorderLayout.SOUTH);
		
		setFont(new Font("",0,20));
		setVisible(true);
///////////////////////////////////////////////		
		Socket s = null;
		try {
			s = new Socket();
			System.out.println("서버에 접속중");
			s.connect(new InetSocketAddress
							("192.168.0.108", 5001));
			System.out.println("접속 성공");
			
			DataOutputStream dos2 = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String duplicate = "";
			while(true) {
				name = JOptionPane.showInputDialog(duplicate+"대화명을 입력하세요");
				dos2.writeUTF(name);
				if (dis.readBoolean()) break;
				duplicate = " 다른";
			}
			
			ta.setText(name +"님 (나) 입장함");
			// 서버의 데이터를 수신할 쓰레드 객체
			new ClientRecever(s).start();
			
			// 데이터를 서버로 송신하는 코드 
			OutputStream os = s.getOutputStream();
			dos = new DataOutputStream(os);
			tf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = tf.getText();
					tf.setText("");
					try {
						dos.writeUTF(str);
					} catch (IOException e1) {
						System.out.println("tf.addActionListener IOException");
					}
				}
			});
		} catch (IOException e1) {
			System.out.println("연결오류");
		}
	}
	public static void main(String[] args) {
		new TestClient("Client");
	} // end of main
	
	/** 서버의 데이터를 수신할 쓰레드 객체 */
	class ClientRecever extends Thread {
		Socket s;
		DataInputStream dis;
		ClientRecever(Socket s) {
			this.s = s;
			try {
				InputStream is = s.getInputStream();
				dis = new DataInputStream(is);
			} catch (IOException e) {
				System.out.println("ClientRecever - IOException");
			}
		}
		public void run() {
			try {
				while(true) {
					System.out.println(name+" Client : 서버데이터 수신대기");
					String str = dis.readUTF();
					if (str.split(">")[0].equals(name)){ // 나면
						ta.append("\n(나)"+str);
					} else {
						ta.append("\n"+str);
					}
					
					System.out.println(name+" Client : 서버데이터 수신완료");
					System.out.println(str);
				}
			} catch (IOException e) {
				System.out.println("Client run() - 읽기오류 프로그램 종료");
				System.exit(0);
//				e.printStackTrace();
			}
		} // end of run()
	} // end of class ClientRecever
} // end of class













