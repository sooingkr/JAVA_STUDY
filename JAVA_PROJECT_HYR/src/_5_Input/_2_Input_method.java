/***
 * 		[	사용자의 입력 받기 방법		]
 * 
 * 		1. BufferedReader
 * 			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * 			br.readLine();
 * 	
 * 		2. Scanner sc = new Scanner(System.in);
 * 				sc.nextInt(), sc.nextLine();
 * 
 * 		3. JOptionPane.showInputDialog("msg");
 * 		
 */
package _5_Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_Input_method {

	public static void main(String[] args) throws IOException {
		
		// [ 1. BufferedReader 를 통한 입력 받기 ]
		
			// 1) 사용자의 입력을 받을 객체 준비.
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			// 2) 사용자가 입력한 한줄을 받아오기.(문자열로 받아옴)
			System.out.println("당신의 이름을 입력하세요 : ");
			
			String readStr = br.readLine(); 
			
			System.out.println("입력한 값은 : " + readStr);
			
			System.out.println("당신의 나이를 입력하세요 : ");
			String str2 = br.readLine();
			
			// 3) 입력받은 문자열을 정수로 변환 해 출력하기.
			System.out.println("당신의 10년 후 나이는 : " + ( Integer.parseInt(str2) + 10) ); // 문자열을 정수로 바꾸는 방법
			// Double.parseDouble( 문자열 ) : 실수로 바꾸기
			
			
		
		
	} // end of main

} // end of class
