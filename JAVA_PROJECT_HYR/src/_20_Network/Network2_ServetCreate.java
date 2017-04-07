/**
 * 		[	서버 만들기  ]
 * 		
 * 		Servet      -       Client
 * 		ServetSocket		Socket
 * 		bind                  connect
 */
package _20_Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Network2_ServetCreate {

	public static void main(String[] args) {

		ServerSocket ss = null;
		OutputStream os = null; // client에게 보내기 위한 OutputStream
		InputStream is = null; // client로부터 데이터를 받기 위한 스트림

		try {
			ss = new ServerSocket();
			// ss.bind(new InetSocketAddress("ip주소","port번호")); // 서버 ip주소,
			// port번호를 세팅
			ss.bind(new InetSocketAddress("192.168.0.114", 5001)); // 192.168.0.114
																	// 의 5001
																	// port로 들어온
																	// 연결을 이어
																	// 놓겠다.

			System.out.println("[Client의 접속을 기다리는 중......]");
			Socket s = ss.accept(); // client 와 연결 수락 : client가 연결할 때까지 블럭되어 있다.
									// client가 요청을하면 다음으로 진행됨.
			InetAddress ia = s.getInetAddress();
			System.out.println("몇번 ip주소에서 온 요청인지 : " + ia.getHostName() + " : " + ia.getHostAddress());
			/*
			 * while(true){ // 서버는 무한루프돌며 사용자의 요청을 기다림
			 * 
			 * }
			 */

			Scanner scan = new Scanner(System.in);
			String str;
			str = scan.nextLine();

			// [보내고 받는 순서를 맞춰서 통신하는 방법]
			os = s.getOutputStream(); // 소켓의 OutputStream 을 얻음
			is = s.getInputStream(); // client로부터 데이터를 받기 위한 스트림
			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);
			/////////////////////////////////////////////////////
			while (true) {
				dos.writeUTF(str);
				dos.flush(); // 버퍼에 남아있는 데이터 밀어내기(출력)

				String result = "";

				result = dis.readUTF();

				System.out.println("CLient로부터 받은 값 : " + result);

			}

			////////////////////////////////////////////////////

		} catch (IOException e) {
			System.out.println("소켓 열기 에러");
		} finally {
			// 자원 해제
			try {
				if (os != null)
					os.close();
			} catch (IOException e1) {
			}

			try {
				if (ss != null)
					ss.close();
			} catch (IOException e) {

			}
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
				}
		}

	}

}
