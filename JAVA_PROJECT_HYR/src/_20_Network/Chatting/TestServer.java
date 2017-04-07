/**
 * 		main - 채팅방에 접속하는 Client 에 접속 대기
 * 		Client 접속시 Client 한명을 담당할 쓰레드 생성(요청하는 Client 마다 새로운 쓰레드 수행)
 * 
 * 		Client 에서 받은 메세지 -> 모든 Client에 송신
 */
package _20_Network.Chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class TestServer {

	static HashSet<Client> clientSocket = new HashSet<Client>(); // 클라이언트와 연결될 때마다 생성되는 소켓들을 저장한다.
	
	public static void main(String[] args) {
		ServerSocket s = null;
		
		try {
			s = new ServerSocket(); // 서버 소켓 생성
			s.bind(new InetSocketAddress("192.168.0.114", 5001)); // ip주소와 포트 번호가 소켓과 연결됨

			while(true){ // main 쓰레드에서 반복문 돌면서 사용자로부터의 요청을 대기하고 있는다. 요청 연결시 Client 마다 쓰레드 생성
							
			System.out.println("[서버 접속 대기 중....]");
			Socket socket = s.accept(); // 사용자의 접속(연결)을 대기함( = 사용자 연결 요청을 승낙하는 메서드)
			// 사용자 접속이 연결이 성공시 사용자와 연결된 소켓 객체를 반환함.
			System.out.println("[서버 접속 완료...");
			Client c = new Client(socket); // 해당 CLient와 연결된 소켓 객체를 가진 Client 객체를 생성
			clientSocket.add(c); // 접속된 CLient 객체를 저장하는 HashMap 객체에 저장 // 나중에 대화명도 지정시 대화명이 같으면 못들어가는 코드 등도 작성하면 good.
			
			// 각 Client 와 통신할 쓰레드 객체 생성해 start 하기
			new ServerReceiver(socket, clientSocket).start();
			System.out.println("Client 입장함");
			
			} // end of while
		} catch (IOException e) {
			System.out.println("소켓 열기 에러");
		} finally {
			if ( s != null )
				try {
					s.close();
				} catch (IOException e) {}
		}
		
	} // end of main

} // end of class

/** 연결이 맺어진 Client 객체의 정보 */
class Client { // 접속된 클라이언트 객체를 나타내는 클래스
	String name;
	Socket s;
	DataOutputStream dos;
	
	public Client(Socket s) {
		this.name = s.getInetAddress().getHostAddress();
		this.s = s;
		try {
			
			dos = new DataOutputStream(s.getOutputStream());
			
		} catch (IOException e) {
			System.out.println("서버, Client 생성자 IOException");
		}
	}
} // end of Client


// 계속 돌면서 Client와 통신할 쓰레드
// 각 Client와 통신할 Thread
// --> Client 가 보내온 메시지를 수신대기하고 메시지를 받은 경우
//		 받아온 메시지를 대화방의 모든 Client들에게 broadCast 해주기
class ServerReceiver extends Thread{
	HashSet<Client> clientSocket;
	Socket s;
	DataInputStream dis;
	public ServerReceiver(Socket s, HashSet clientSocket) { // 현재 나와 대화하고 있는 소켓, 전체 소켓 목록
		this.clientSocket = clientSocket;
		this.s = s;
		try {
			dis = new DataInputStream(this.s.getInputStream());
		} catch (IOException e) {
			System.out.println("SocketReceiver 생성자 : Socket IO Error");
		}
	}
	@Override
	public void run() {
		try {
			while(true) {
				//System.out.println("[서버] : Client 메시지를 기다리는 중...");
				String str = dis.readUTF(); // CLient가 메시지를 입력하기를 대기중...
				//System.out.println("[서버] : Client 메시지 수신 완료");
				// 받은 메시지를 전체 연결된 Client에게 BroadCast 해주기
				broadCast(str);
			}
		} catch (IOException e) {
			System.out.println("ServerRun IOException");
		}
	}
	private void broadCast(String str) { // 전체 CLient에 방송할 메서드
		// 방송 시작
	//	System.out.println("방송 시작");
		for( Client c : clientSocket ) {
			try {
				c.dos.writeUTF(str);
				
			} catch (IOException e) {}	
		}
	//	System.out.println("방송 완료");
	}
}
