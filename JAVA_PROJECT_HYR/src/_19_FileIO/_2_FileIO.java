
package _19_FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class _2_FileIO {

	public static void main(String[] args) throws IOException {
		
		System.out.println("윈도우의 기본 디렉토리 구분자 : " + File.separator);
		InputStream in = new FileInputStream("C:\\DEV\\kosta\\test.txt");
		byte[] co = new byte[10];
	
		int Num = in.read(co, 0, co.length); // 읽어온 개수가 Num에 저장됨.
		if ( in != null ) in.close(); // 자원 해제
		for(int i=0; i<Num; i++){
				System.out.print((char)co[i] + " ");
		}
	}

}
