/**
 * 		[ 변수(Variables)	]
 * 
 * 		: data를 저장할 수 있는 기억 공간.
 */
package _1_Introduction;

public class _2_Variable
{

	public static void main(String[] args)
	{
		int a; // 변수 선언 => 지역변수는 초기화하지 않으면 쓰레기 값이 들어감
		// but Java Compiler는 지역변수를 초기화하지 않으면 오류를 띄움
		// System.out.println(a);
		
		// 전역변수는 초기화하지 않을 경우 0으로 초기화 됨!, static 변수도 마찬가지
		
		//기본형 데이터 타입 8가지
			// 정수형 : byte(1B), short(2B), """int(4B)""", long(8B) : cpu가 4B 체계로 명령어 처리 따라서
					// => 정수는 int 형이 처리 속도가 제일 빠르고, 효율이 좋음 : 정수 default : int
					// long lo = 10L;
			// 실수형 : float(4B), """double(8B)""" : default 실수형 : double
					// float f = 1.0f; double d = 1.0;
			// 논리형 : boolean(1B) : true/false : default false
			// 문자형 : char(2B) : Unicode 체계 사용 : ' '
		
		a = 10; // 변수의 초기화
			
		byte by = 6;
		short sh = 7;
		long lo = 100L; // 리터럴 접미사 L
		
		float fl = 3.14f; // 리터럴 접미사 f
		double d = 3.14;
		
		d = 3.0;
		
		boolean flag = false;
		
		// 문자형
		char c = 'x'; // 한 글자만 저장 가능
		System.out.println((int)c); // 120 : ASCII 코드 값
		
		//**************************************
		
		//		[	상수(리터럴)		] : 일정한 수, 프로그램 종료시까지 같은 값을 유지한다.
		final int AGE = 40; // 상수, 상수명은 대문자로 하자!
		
		//		[	문자열(String)	]
		String str1 = "안녕하세요";
		System.out.println(str1);
		
		//*** 	[ 문자열의 덧셈 연산 ]
		str1 = "a" + "bcd"; // 문자열을 +면 이어붙이는 역할을 해줌.
		System.out.println(str1);
		str1 = "a" + 3; // a3이 저장 됨.
		// 문자 + 비문자열 => 비문자열을 문자열로 변환해 덧셈연산 함
		// "a" + "3" 으로 처리
		
		str1 = 3 + 4 + "a" + 3 + 4;
		// 7a34
		
		int indexOfArray;
		int h = 99; // 10진수
		h = 07; // 8진수 표기 : 0으로 시작
		h = 0xff; // 16진수 표기 : 0x로 시작
		
		char xx = '1';
		xx = '\n'; // escape 문자 : enter
		xx = '\t'; // escape 문자 : tab
		
		int maxNum = Integer.MAX_VALUE;
		int minNum = Integer.MIN_VALUE;
		
		
	} // end of main

} // end of class
