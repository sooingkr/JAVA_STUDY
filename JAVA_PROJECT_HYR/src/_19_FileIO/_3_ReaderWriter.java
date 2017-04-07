/**
 * 		문자 처리시 2B가 쓰임으로 바이트기반으로 처리는 특정 문자들은 표현하기 어려울 수 있기 때문에
 * 		문자처리시 Reader/Writer를 이용해서 처리하는 것이 용의하다.
 * 
 */
package _19_FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3_ReaderWriter {

	public static void main(String[] args) throws IOException {
		FileInputStream f = new FileInputStream("C:\\DEV\\kosta\\test.txt");
		InputStreamReader ir = new InputStreamReader(f);
		// Reader 임으로 2Byte 단위로 읽어옴
		int readNum = 0;
		char[] cbuf = new char[5];
		readNum = ir.read(cbuf, 0, cbuf.length);
		
		for (int i = 0; i < readNum; i++) {
			System.out.print(cbuf[i] + " ");
		}
	}

}
