package _19_FileIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class _9_Copy {

	public static void main(String[] args) throws IOException {
		//	nio 가장 빠른 입출력 방법 : 기존의 자바의 느린 IO를 계선하기 위한 방법
		long start = System.currentTimeMillis();
		FileInputStream fis = null;
		FileOutputStream fos = null;

		FileChannel in = null;
		FileChannel out = null;
		try {
			fis = new FileInputStream("C:\\DEV\\kosta\\P1000183.jpg");
			fos = new FileOutputStream("C:\\DEV\\kosta\\P10001832.jpg");

			in = fis.getChannel();
			out = fos.getChannel();
			in.transferTo(0, in.size(), out);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 클로즈들..........
			out.close();
			in.close();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		
/*		long start = System.currentTimeMillis();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bs= null;
		BufferedOutputStream bo= null;
		byte[] temp = new byte[1024 * 1024 * 8 * 5];
		try {
			fis = new FileInputStream("C:\\DEV\\kosta\\P1000183.jpg");
			fos = new FileOutputStream("C:\\DEV\\kosta\\P10001832.jpg");
			bs = new BufferedInputStream(fis);
			bo = new BufferedOutputStream(fos);
			int readNum = bs.read(temp,0,temp.length);
			bo.write(temp,0,readNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 클로즈들..........
			bs.close();
			bo.close();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		*/
	}

}
