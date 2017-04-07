package _19_FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class _5_FileIO {

	public static void main(String[] args) throws IOException {
		FileOutputStream f = new FileOutputStream("C:\\DEV\\kosta\\test.txt");
		String str = "abcdefg1234";
		byte[] temp = str.getBytes();
		
		f.write(temp,3,4); // defg 3번 인덱스부터 4개 쓰겠다.
		f.flush(); // 버퍼에 잔류하는 데이터를 전송하기(일정량이 채워지지 않아도 현재까지 내용을 보내도록)
		
		
		// Reader : 문자 기반 입력 스트림, only 문자만 읽을 수 있다.
		FileReader fr = new FileReader("C:\\DEV\\kosta\\test.txt");
		BufferedReader br = new BufferedReader(fr);
		/*char[] temp2 = new char[10];
		br.read(temp2);*/
		while(true) {
			String str2 = br.readLine();
			if ( str2 == null ){
				break;
			}
			System.out.println(str2);
		}		
		// flush는 읽을 땐 없음 바로 바로 읽어오니까 but 쓸 때는 느린 하드디스크에 쓰니까
		// cpu의 효율을 위해 버퍼에 일정량 쌓았다 보내니까 flush해줘서 바로바로 보내줄 필요가 있음.
		
		f.close();
	}

}
