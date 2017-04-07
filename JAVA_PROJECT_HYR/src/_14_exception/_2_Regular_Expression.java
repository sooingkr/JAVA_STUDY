package _14_exception;

import java.util.Scanner;
import java.util.regex.Pattern;

public class _2_Regular_Expression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		String str = sc.next();
		
		// 정규표션식을 사용해서 숫자인지 판단하기
		
		if ( Pattern.matches("[0-9]+", str)){ // 숫자를 하나 이상 입력했는지 판단
			int num = Integer.parseInt(str);
			System.out.println("입력한 숫자 : " + num);
		}else {
			System.out.println("숫자를 입력하시라니까요.");
		}
	}

}
