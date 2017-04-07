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
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;

/**
 * main - 채팅방에 접속하는 Client 에 접속 대기
 * Client 접속시 Client한명을 담당할 쓰레드 생성
 * 
 * Client 에서 받은 메세지 => 모든 Client에 송신
 */
public class TestServer extends Frame {
	HashSet<Client> clientSocket=new HashSet<Client>();
	Frame f = new Frame("Server");
	TextArea ta = new TextArea("Server 모니터");
	
	public TestServer(String title) {
		super(title);
		setBounds(1000, 100, 300, 500);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
				System.exit(0);
			}
		});
		
		ta.setEditable(false);
		add(ta);
		
		setFont(new Font("",0,20));
		setVisible(true);
		
		ServerSocket ss = null;
		try {
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress
				("192.168.0.108", 5001)); //ip주소, port 설정
			while(true) {
				System.out.println("Client 대기중");
				Socket s = ss.accept(); // 쓰레드가 블럭됨
				
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String name = "";
				while (true) { // 대화명 입력
					name = dis.readUTF();
					if (uniqueName(name)) break;
					dos.writeBoolean(false);
				}
				dos.writeBoolean(true);
				
				Client c = new Client(s, name);
				clientSocket.add(c);
				// 각 Client 와 통신할 쓰레드 객체 생성
				new ServerRecever(s, clientSocket, c).start();
			}
		} catch (IOException e) {
			System.out.println("소켓열기 에러");
		}
	}
	public static void main(String[] args) {
		new TestServer("Server");
	} // end of main
	boolean uniqueName(String name) {
		Iterator<Client> iter = clientSocket.iterator();
		while(iter.hasNext()) {
			if (iter.next().name.equals(name)) return false;
		}
		return true;
	}
	/** 각 Client와 통신할 Thread
	 * 	Client 가 보내온 메시지를 수신대기하고,
	 * 	받은 메시지를 모든 Client에게 방송하기
	 *  */
	class ServerRecever extends Thread {
		Socket s;
		HashSet <Client> clientSocket;
		DataInputStream dis;
		Client c;
		ServerRecever(Socket s, HashSet<Client> clientSocket, Client c) {
			this.s = s;
			this.clientSocket = clientSocket;
			this.c = c;
			try {
				dis = new DataInputStream(s.getInputStream());
			} catch (IOException e) {
				System.out.println("ServerRecever 생성자-IOException");
			}
			broadcast(c.name+"님 입장함");
		} // end of 생성자
		public void run() {
			try {
				while(true) {
					System.out.println("[서버]:"+c.name+" 메시지 기다림");
					String str = dis.readUTF();
					ta.append("\n"+c.name+"> "+str);
					System.out.println("[서버]:"+c.name+" 메시지 수신완료:"+str);
					broadcast(c.name+"> "+str);// 전체 연결된 Client 에게 모두 방송
				}
			} catch(IOException e) {
				System.out.println("ServerRecever run IOException");
				try {
					if (s!=null)s.close();
				} catch (IOException e1) {
					System.out.println("소켓 닫기 에러");
				}
				System.out.println("끊어진 Client 제거 : "+clientSocket.remove(c));
			}
		} // end of run()
		/** 모든 Client 에게 받은 메시지를 전송하기 */
		void broadcast(String str) {
			System.out.println("방송시작");
			Iterator<Client> iter = clientSocket.iterator();
			
			try {
				while (iter.hasNext()) {
					Client c = iter.next();
					c.dos.writeUTF(str);
				}
			} catch (IOException e) {
				System.out.println("ServerRecever broadcast IOException");
			}
			System.out.println("방송완료");
		}
	} // end of class class ServerRecever
} // end of class TestServer

/** 연결 맺어진 Client 객체의 정보 */
class Client {
	Socket s;
	DataOutputStream dos;
	String name = ""; // 대화명
	Client(Socket s, String name) { // 생성자
		this.s = s;
		this.name = name;
		try {
			dos = new DataOutputStream(s.getOutputStream());
		} catch (IOException e) {
			System.out.println("서버, Client 생성자 IOException");
		}
	}
} // end of class Client















