/**
 * 		[	Console	 ]
 * 		: 콘솔 창에서 입력을 쉽게 받기 위해 jdk 6에서 추가됨. but 이클립스에선 실행 안됨...(cmd 창에서 실행해야함)
 * 		readLine(), readPassword()
 */
package _19_FileIO;

import java.io.Console;

public class _11_Console {

	public static void main(String[] args) {
	
		Console con = System.console(); // Eclipse 에서 리턴값이  null
		
		if ( con == null ){
			System.out.println("콘솔 객체를 받아오지 못했습니다.");
			return;
		}
		
		System.out.println("이름을 입력하세요");
		String name = con.readLine();
		System.out.println("비밀번호를 입력하세요");
		char[] password = con.readPassword();
		String pass = new String(password);
		System.out.println(pass);
	} // end of main

} // end of class
