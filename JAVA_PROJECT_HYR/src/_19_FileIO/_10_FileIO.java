/**
 * 		System.in : inputStream(키보드로부터 받아오는 스트림)
 * 		System.out : PrintStream(OutputStream 을 상속받은 자식 클래스)로 모니터에 연결된 스트림
 *		System.err : same(모니터에 에러를 출력하기 위한 스트림) 
 * 
 */
package _19_FileIO;

import java.io.PrintWriter;

public class _10_FileIO {

	public static void main(String[] args) {

		PrintWriter out = new PrintWriter(System.out);
		out.println("안녕하세요.");
		out.close();
	}

}
