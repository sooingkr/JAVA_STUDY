/**
 * 		[	입력 받기위한 객체	 ]
 *		Scanner : 문자뿐만 아니라 기본타입도 다 받을 수 있음.(nextInt, nextDouble ...)
 *		Console 은 콘솔창에서 문자만 입력이 가능. 		
 * 
 */
package _19_FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _12_InputObject {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		//System.out.println("이름입력해");
		//String name = scan.nextLine();
		//System.out.println(name);
		//System.out.println("나이를 입력하세요.");
		//int age = scan.nextInt();
		File f = new File("C:\\DEV\\kosta\\test.txt");
		Scanner scan2 = new Scanner(f,"euc-kr");
		System.out.println("test");
		while(scan2.hasNextLine()){
			String n = scan2.nextLine();
			
			System.out.print(n);
		}
		
		
		scan2.close();
	}

}
