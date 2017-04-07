// 효율을 위해 사용되는 Buffer
/*
 * 		OutputStream : 추상 클래스
 * 		FileOutputStream - OutputStream 을 구현한 자식 클래스
 * 		버퍼에 잔류하는 데이터에 관한 처리 : flush() : 버퍼에 남은 데이터를 보내라
 */
package _19_FileIO;

import java.io.*;
public class _4_BufferedIO {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fo = new FileOutputStream("C:\\DEV\\kosta\\test.txt",true);
		// append 가능하게 하려면 두번째 속성값으로 true를 줘야함
		// 이거 true 안주면 쓸때마다 기존 내용 다 지워지고 새로 써짐
		OutputStreamWriter o = new OutputStreamWriter(fo);
		BufferedWriter br = new BufferedWriter(o);
		
		br.append("이어 붙입니다.");
		
		br.write("새로 다 지우고 넣습니다.");
		br.newLine(); // 한줄 삽입
		br.write("hello");
		System.out.println("붙임");
		br.flush(); // 버퍼에 남은 데이터 다 보내라
		
		br.close();
		
	}//end of main

}// end of class
