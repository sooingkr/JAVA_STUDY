package _19_FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _7_FileIO {

	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fw = new FileWriter("C:\\DEV\\kosta\\good.txt");
			bw = new BufferedWriter(fw);
			
			bw.write("선생님 안녕하세요");
			bw.newLine();
			bw.write("반갑습니다.");
		} catch (IOException e) {
			
		} finally {
			try {
				bw.close();
			} catch (IOException e) {}
		}
		
		try {
			fr = new FileReader("C:\\DEV\\kosta\\good.txt");
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {}
		
		String str = null;
		while(true){
			try {
				str = br.readLine();
			} catch (IOException e) {}
			if ( str == null ) break;
			System.out.print(str);
		}
		try {
			br.close();
		} catch (IOException e) {}
		
		
	} // end of main

} // end of class
