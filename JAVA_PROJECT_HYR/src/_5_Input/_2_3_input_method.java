package _5_Input;

import java.util.Scanner;

public class _2_3_input_method {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		// 몸무게와 키를 사용자 입력을 숫자로 받아 비만인지 정상인지 판별한다.
		
		System.out.println("키를 입력 해 주세요 :(cm) ");
		double tall = (sc.nextDouble() );
		tall /= 100;
		
		System.out.println("몸무게를 입력 해 주세요 :(kg) ");
		double weight = (sc.nextDouble() );
		
		double BMI = ( weight / ( Math.pow(tall,2) ) );
		
		if( BMI < 20.0 ){
			System.out.println("저체중");
		}else if( BMI < 25.0){
			System.out.println("정상");
		}else if( BMI < 30.0 ){
			System.out.println("과체중");
		}else{
			System.out.println("비만");
		}
		
		
	} // end of main

} // end of class
