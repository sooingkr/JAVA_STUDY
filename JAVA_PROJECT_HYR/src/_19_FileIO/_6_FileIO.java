package _19_FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class _6_FileIO {

	public static void main(String[] args) throws IOException {
		FileOutputStream fw = new FileOutputStream("C:\\DEV\\kosta\\test.txt",true);
		OutputStreamWriter ow = new OutputStreamWriter(fw, "UTF-8");
		BufferedWriter bw = new BufferedWriter(ow);
		bw.write("씁니다.");
		bw.newLine();
		bw.flush();
		if ( bw != null) bw.close();
		
		FileInputStream f = new FileInputStream("C:\\DEV\\kosta\\test.txt");
		InputStreamReader r = new InputStreamReader(f,"UTF-8");
		// 한글 깨짐 방지 인코딩 지정하기
		BufferedReader br = new BufferedReader(r);
		
		while(true){
			String content = br.readLine();
			if ( content == null ){
				
				if ( br != null) br.close();
				break;
			}
			System.out.print(content + " " );
		}
		
		
	}

}
