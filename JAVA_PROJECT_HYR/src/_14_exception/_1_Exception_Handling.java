/**
 * 		[	예외처리	 ]
 * 		: 
 */
package _14_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _1_Exception_Handling {

	public static void main(String[] args) {
		try {
			System.out.println(3 / 0);
		} catch (ArithmeticException e) {
			System.out.println( 3 );
		}
		
		Scanner sc = new Scanner(System.in);
		try{
		int num = sc.nextInt();
		System.out.println("입력값 : " + num);
		}catch(InputMismatchException e){
			System.out.println("값 잘못입력했습니다.");
		}
		
		sc.close();
	}

}
