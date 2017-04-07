/**
 * 		[	File I/O	 ]
 * 
 * 		: Stream은 1B단위로 주고 받음 but ~~Reader/~~Writer 계열은 2B 단위로 주고 받음
 * 		InputStream - (Object) - OutputStream
 * 		BufferedReader - InputStream - (Object) - OutputStream - BufferedWriter
 * 
 * 
 * 		- InputStream, OutputStream : 바이트 기반 스트림, 그림, 멀티미디어, 문자 등 모든 종류 가능
 * 		- Reader, Writer : 문자 기반 스트림  : Only 문자만 입출력 가능
 * 		- I/O 클래스 명명법
 * 					InputStream, OutputStream 의 추상클래스를 구현한 자식 객체는 
 * 					()()InputStream, ()()OutputStream
 * 					
 * 					Reader, Writer 의 추상클래스를 구현한 자식 클래스는
 * 					()()Reader, ()()Writer
 * 
 */
package _19_FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class _1_FileIO {

	public static void main(String[] args) throws IOException {
		int readByte = 0;
		byte[] content = new byte[100];
		InputStream in=null;
		try {
			in = new FileInputStream("C:\\DEV\\kosta\\test.txt"); // InputStream 추상클래스를 구현한 자식 FileInputStream
			while(true){
				readByte = in.read(); // 한 byte를 읽어오고 읽어온 개수를 반환함
				
				if (readByte == -1 ){
					// read 메서드는 읽어온게 더이상 없을 때 -1을 리턴
					// 더이상 읽을게 없음으로 break
					break; 
				}
				System.out.println((char)readByte);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
			return;
		} finally {
			try {
				in.close(); // 자원해제 finally에서..
			} catch (IOException e) {}
		}
		
		
	} // end of main

} // end of class
