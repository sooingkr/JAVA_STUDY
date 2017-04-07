/**
 * 		[	Network	  ]
 * 
 * 		Server - Client
 * 		-	TCP : 연결지향적(한번 맺어논 소켓을 이용해 통신) : 연결 통로를 이용해 순차적으로 도착함 -> 데이터 누수없이 정확히 보내야 할 때 이용됨.
 * 
 * 		-	UDP : 패킷을 묶어 보냄 : 데이터의 순차적 도착을 보장할 수 없고 데이터 누수가 발생할 수 있음. -> 간단간단한 것 주고받을 때 이용됨.
 * 
 */
package _20_Network;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetWork1 {

	public static void main(String[] args) {
		try {
		
			InetAddress ia = InetAddress.getLocalHost(); // 내 컴퓨터 ip 주소 얻어오기
			System.out.println( ia.getHostName() ); // 내컴퓨터 이름을 반환
			System.out.println( "내 컴 IP 주소 : " + ia.getHostAddress() ); // ip 주소 반환
			
			InetAddress iagoogle = InetAddress.getByName("www.google.com");
			System.out.println(  "구글 ip 주소 : " + iagoogle.getHostAddress() );
			
			System.out.println("네이버");
			InetAddress[] iaNaver = InetAddress.getAllByName("www.naver.com");
			// 여러개 목록을 가지고 옴 getAllByName은
			for (int i = 0; i < iaNaver.length; i++) {
				System.out.println( iaNaver[i].getHostAddress() );
			}
			
			System.out.println("다음");
			InetAddress[] isDaum = InetAddress.getAllByName("www.daum.net");
			for (int i = 0; i < isDaum.length; i++) {
				System.out.println( isDaum[i].getHostAddress() );
			}
		} catch (UnknownHostException e) {
			
		} 
	}

}
