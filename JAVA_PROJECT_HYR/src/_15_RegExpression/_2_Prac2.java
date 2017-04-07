package _15_RegExpression;

import java.util.regex.Pattern;

public class _2_Prac2 {

	public static void main(String[] args) {
//		for (char i = 0; i < 0xffff; i++) {
//			System.out.print(i);
//			if(i%16==0){
//				System.out.println();
//			}
//		}
		
		p(Pattern.matches("[a-z]", "t")); // 알파벳 소문자 한글자 정규표현식
		p(Pattern.matches("[a-z]+", "tw")); // 알파벳 소문자 한글자이상 정규표현식
		p(Pattern.matches("[a-z]*", "가")); // 알파벳 소문자 0개 이상 정규표현식
		p(Pattern.matches("[a-z]?", "t")); // 알파벳 소문자 0개 또는 1개 정규표현식
		p(Pattern.matches("[a-z가-힣]+", "t가")); // 알파벳 소문자 혹은 한글 중 하나 한글자 이상 정규표현식
		p(Pattern.matches("[a-zA-Z가-힣]+", "1")); // 알파벳 소문자 혹은 대문자, 한글 중 하나 한글자 이상 정규표현식
		p(Pattern.matches("[0-9]+", "123")); // 숫자 한글자 이상 정규표현식
		p(Pattern.matches("[가-힣]{3}", "한글")); // 한글 3글자 정규표현식
		p(Pattern.matches("[가-힣]{2,5}", "한글")); // 한글 2자 ~ 5글자 정규표현식
		p(Pattern.matches("x{3}", "xxx")); // x라는 글자 3개인지 정규표현식
		p(Pattern.matches("[^a-z]+", "a")); // a-z 가 들어가면 안된다는 뜻(^) 정규표현식
		// 900317-1111111
		p(Pattern.matches("[0-9]{6}-[1,2]{1}[0-9]{6}", "900317-1111111")); // x라는 글자 3개인지 정규표현식
		// ~시 ~구 ~동
		p(Pattern.matches("[가-힣0-9]{1,5}시 [가-힣0-9]{1,5}구 [가-힣0-9]{1,5}동" , "서울시 도봉구 창2동")); // x라는 글자 3개인지 정규표현식
		p(Pattern.matches("abc|xxx", "xxx")); // or 연산 정규표현식
		// 전화번호 010-3604-0000
		p(Pattern.matches("[0-9]{3}-[0-9]{3,4}-[0-9]{3,4}", "010-3604-7237"));
		p(Pattern.matches(".", "A"));  // .은 아무글자나 한글자를 의미함
		p(Pattern.matches(".{3}", "A"));  // 임의의글자 3글자를 의미함
		p(Pattern.matches("[_,a-z,A-Z]+@[a-zA-Z]+\\.[a-zA-Z]+(\\.kr)?", "abcd@co.kr"));
		// .은 임의한글자이기 때문에 \\. 으로해야 .으로 인식
		// (\\.kr)? 은 .kr은 올수도 있고 아니면 안올수도있다는 의
		
		// (우) 234-1234
		p(Pattern.matches("\\(우\\) [0-9]{3}-[0-9]{4}", "(우) 234-1234"));
		
		// [해당 문자열이 포함되었는지 확인] 1234가 포함되어 있는지 앞뒤로는 머가 오든지 상관없음...
		p(Pattern.matches("(.*)1234(.*)", "가1234dfaf")); 
		// 숫자+(숫자+숫자)*숫자
		p(Pattern.matches("[0-9]+\\+\\([0-9]+\\+[0-9]+\\)\\*[0-9]+", "33+(22+11)*44")); 
	}

	static void p(boolean b){
		System.out.println(b);
	}
}
