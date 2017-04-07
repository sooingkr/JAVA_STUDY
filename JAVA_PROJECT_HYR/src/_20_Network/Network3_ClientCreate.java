/**
 * 			[	Client	] * 
 */
package _20_Network;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Network3_ClientCreate {

	public static void main(String[] args) throws IOException {

		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			// 1. 첫번째 방법
			// System.out.println("[서버 접속 중...]");
			/*
			 * s = new Socket(); s.connect(new
			 * InetSocketAddress("192.168.0.123", 5001)); // 서버에 접속해라 // 현재 쓰레드가
			 * 서버에서 접속을 수락해줄때까지 블럭 됨.
			 */
			// 2. 두번째 방법
			System.out.println("[서버 접속 중...]");
			s = new Socket("192.168.0.114", 5001);
			// 현재 쓰레드가 서버에서 접속을 수락해줄때까지 블럭 됨.
			System.out.println("[서버 접속 성공]");

			Scanner scan = new Scanner(System.in);

			// [ 서버에서 보내준 데이터를 받는 작업 ]
			is = s.getInputStream(); // 서버에서 데이터를 받을 용도
			os = s.getOutputStream(); // 서버에 데이터를 보낼 용도
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);

			while (true) {
				String result = "";
				result = dis.readUTF();

				System.out.println("서버에서 받은 문자열 : " + result);

				System.out.print("보낼 메시지 : ");
				String str = scan.nextLine();
				dos.writeUTF(str); // 서버에 데이터 전송
				dos.flush();

				System.out.println("[ Client 종료 ]");
			}

		} catch (IOException e) {

		} finally {
			if (dis != null)
				dis.close(); // 자원 해제
			if (dos != null)
				dos.close();

		}

	} // end of main

} // end of class
