/**
 * 		[	try~with~resources 자동 리소스 닫기	]
 */
package _14_exception;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5_Try_With_Resources {

	public static void main(String[] args) {

		FileInputStream fis = null; // 파일 입력스트림
		try {
			fis = new FileInputStream("mfile.txt");

		} catch (Exception e) {
			// Exception 발생시 처리

		} finally {
			// 파일은 꼭 닫아줘야하니까 마지막엔 반드시 실                        행하기 위해서...
			// 반드시해야하는 것은 finally를 이용하자.
			if (fis != null) { // 파일이 열렸을 때만 파일을 닫기 수행
				try {
					fis.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}


		// 	[	try with resources	]
		// 위는 예전 방법이고, jdk 1.7버전 이후에는 아래처럼 작성
		try (FileInputStream fis2 = new FileInputStream("myfile.txt");
				FileOutputStream fos2 = new FileOutputStream("myFile.txt");
				InputStreamReader ir = new InputStreamReader(fis2,"UTF-8");
				) {
			// ...
		} catch (Exception e) {
			
		}
		// 끝나면 알아서 파일을 닫아준다.(finally작업할 필요없음) 하지만... 별로 많이 안씀...
		// 닫아야할 파일을 try의 괄호안에 넣어준다.
	}

}
