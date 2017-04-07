package _5_Input;

import java.util.Scanner;

public class testQuize2 {

	public static void calculatorMethod(){
		//계산기
		
		// 숫자, 연산자, 숫자 순서로 입력받는다. (+ - * /)
		Scanner sc = new Scanner(System.in);
		
		
		int num1 = Integer.parseInt(sc.next()); // 화이트 스페이스(엔터, 공백) 전까지 문자열을 가져감.
		String op = sc.next();
		int num2 = Integer.parseInt(sc.next());;
		double result = 0.0;
		boolean flag = false;
		
		switch (op) {
		case "+":
			result = (double)(num1 + num2);
			break;
		case "-":
			result = (double)(num1 - num2);
			break;
		case "*":
			result = (double)(num1 * num2);
			break;
		case "/":
			if( num2 == 0 || num1 == 0){
				flag = true;
			}else{
				result = ((double)num1 / num2);
			}
			break;
		}
		
		if(flag){
			System.out.println("0으로 나눌 수 없습니다.");
		}else if(flag == false){
			System.out.println(num1 + " " + op + " " + num2 + " = " + result + " 입니다.");
		}
	}
	
	public static void main(String[] args) {
		calculatorMethod();
	}

}
