/**
 * 		[	FileDialog(파일다이얼로그)	] : 파일업로드
 * 
 */
package _18_Swing;

import java.awt.FileDialog;

import javax.swing.JFrame;

public class _17_Dialog {

	public static void main(String[] args) {

		JFrame f = new JFrame("FileDialog");
		f.setBounds(1000, 100, 800, 800);

		FileDialog fd = new FileDialog(f, "파일을 고르세요", FileDialog.LOAD);
		fd.setDirectory("C:\\DEV"); // 파일 고르는 default 경로 지정
		fd.setFile("c:\\DEV\\퇴근.txt"); // 처음 default로 지정할 파일(초기 파일명 지정)

		// 사용자가 파일 선택한 후 다음 코드로 진행됨
		if (fd.getDirectory() != null || fd.getFile() != null) {
			System.out.println("사용자가 선택한 파일의 디렉토리 위치 : " + fd.getDirectory());
			 // 사용자가 선택한 파일의 디렉토리 위치를 리턴
			System.out.println("사용자가 선택한 파일명 : " + fd.getFile());
		}
		fd.setVisible(true); // main 쓰레드는 파일다이얼로그가 리턴될때까지 블럭 되어 있다.

		f.setVisible(true);
	
	}// end of main

}// end of class
