/**
 * 		[	서버와 통신하는 Client   ]
 * 		
 * 		main 메서드에서는  : 사용자가 콘솔창에 작성한 내용을 전송
 * 		ClientReceiver 객체 : 서버에서 보내오는 메시지를 받기위한 쓰레드( read는 상대가 보낼 때까지 block상태임으로 별도의 쓰레드로 돌려주고 있어야 함)
 * 		-> 둘 다 while을 돌면서 처리
 */
package _20_Network.Chatting;

import java.awt.BorderLayout;
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
import java.util.Scanner;

/**
 * 
 * 서버와 통신하는 client
 * 
 * clinetRecever 객체 - 서버에서 보내오는 메세지를 받기위한 쓰레드
 * 
 * main 메서드에서는 사용자가 콘솔창에 작성한 내용을 전송
 * 
 */
public class TestClient {
	static String str;
	static DataOutputStream dos;
	
   public static void main(String[] args) {
	   TestClient t = new TestClient();
	  showFrame f = new showFrame(t);
	   
      Socket s = null;

      try {
         s = new Socket();
         System.out.println("[서버 접속중]");
         s.connect(new InetSocketAddress("192.168.0.114", 5001));
         System.out.println("[연결 성공]");

         // 서버의 데이터를 수신할 쓰레드 객체
         new ClientRecever(s).start();
         OutputStream os = s.getOutputStream();
         dos = new DataOutputStream(os);
         Scanner sc = new Scanner(System.in);

         // 데이터를 서버로 송신하는 코드
         while (true) {

            str = sc.nextLine(); 
            System.out.println("Client : 서버로 송신시작");
            dos.writeUTF(str);
            System.out.println("client : 서버로 송신완료");

         }
      } catch (IOException e1) {
         System.out.println("연결오류");
      }

      try {
         if (s != null)
            s.close();
      } catch (IOException e) {
      }
   }// end of main
}// end of class

class ClientRecever extends Thread {

   static Socket s;
   DataInputStream dis;
   static String str="";
   ClientRecever(Socket s) {
      this.s = s;
      try {

         InputStream is = s.getInputStream();
         dis = new DataInputStream(is);
         
      } catch (IOException e) {
         System.out.println("ClientRecever - IOException");
      }
   }

   @Override
   public void run() {
      try {

         while (true) {
            System.out.println("[Client : 서버 데이터 수신대기]");
            
            str = dis.readUTF();
            System.out.println("[clinet : 수신완료]");
            System.out.println(str);
            //System.out.println("테스트");
            showFrame.tf.append("\n" + str);
            
         }
      } catch (IOException e) {
         System.out.println("client : 읽기 오류");
      }
   }
}// end of class clientRecever

////////////////////////////////////////////////////////////////////////////////////
// [출력]
class showFrame extends Frame {
	TestClient t;
	static String content="";
	static TextArea tf;
	static TextField tf2;
	

	public showFrame(TestClient t) {
		this.t = t;
		setBounds(1000,100,600,600);
		setTitle("채팅방");
		setLayout(new BorderLayout());
		
		// 대화 출력 창
		tf = new TextArea();
		add(tf,BorderLayout.CENTER);
		tf.setEditable(false);
		tf.setText("");
		
		// 대화 입력 창
		tf2 = new TextField(100);
		add(tf2,BorderLayout.SOUTH);
		tf2.requestFocus();
		
		// 대화 입력하고 엔터치면 대화 출력 창에 띄우기
		tf2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String hostName = ClientRecever.s.getInetAddress().getHostName();
					String txt = tf2.getText();
					t.dos.writeUTF(hostName + " (님) : " + txt);
					
					//tf.append("\n" + ClientRecever.str);
					tf2.setText(""); // 입력창 빈문자열로
				} catch (IOException e1) {}
				
				
			}
		});
		
		// Frame 닫기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		setVisible(true);
	}
}