/**
 * 		[	File 내용을 담을 수 있는 객체 ]
 * 
 */
package _19_FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class _13_FileClass {

	public static void main(String[] args) throws IOException {
		File dir = new File("C:\\DEV\\kosta");
		File file1 = new File("C:\\DEV\\kosta\\good.txt");
		File file2 = new File("C:\\DEV\\kosta\\bad.txt");
		File file3 = new File("C:\\DEV\\kosta\\bad2.txt");
		System.out.println(dir);

		System.out.println("디렉토리냐? " + dir.isDirectory());
		System.out.println("파일이냐? " + dir.isFile());

		System.out.println(file1.isDirectory());
		System.out.println(file1.isFile());
		System.out.println("파일명 : " + file1.getName());
		System.out.println("존재하냐? " + dir.exists());

		File dir2 = new File("C:\\DEV\\kosta\\folder");
		if (!dir2.exists()) {
			// 존재안하면 디렉터리 생성
			dir2.mkdirs(); // 상위폴더도 존재하지 않으면 상위폴더들까지 다 생성
			dir2.mkdir(); // 경로 맨 뒤 폴더만 없고 그 앞 경로 폴더까진 다 있을 경우 생성
		}

		// 파일이 존재하지 않으면 파일 생성
		if (!file2.exists()) {
			file2.createNewFile(); // 파일생성
		}
		if (!file3.exists()) {
			file3.createNewFile();
		}

		// 해당 경로에 있는 파일들 목록 파일 객체들로 가져오기
		File[] Filelist = dir.listFiles();
		for (int i = 0; i < Filelist.length; i++) {
			if (Filelist[i].isDirectory()) {
				System.out.println("디렉토리");
				System.out.println(Filelist[i].getName());
			} else {
				System.out.println("파일");
				System.out.println("파일명 : " + Filelist[i].getName() + " 용량 : " + Filelist[i].length() + "byte"
						+ Filelist[i].lastModified());
			}
		}
		
		File ff = new File("C:\\DEV\\kosta\\bad2.txt");
		if ( !ff.exists() ){
			System.out.println("파일이 존재하지 않음");
			return;
		}else {
			InputStream is = new FileInputStream(ff);
			//is.read()
		}
	}

}
