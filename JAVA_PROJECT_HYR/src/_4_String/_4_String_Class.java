/** 
 * 		[		문자열 String 클래스 내용 비교		]
 * 		: String은 내용이 수정될 때마다 계속 메모리를 새로 할당받음 따라서
 * 
 * 		메모리를 조금이라도 아끼기 위해서 동일내용을 대입시 같은 공간을 가리키도록 하고 new로 생성했을 때만
 * 		다른 곳을 가리키도록 되어 있다.
 * 
 * 		또한, String은 내부에 equals 메서드가 오버라이딩되어 있어서 객체비교가 아닌 내용비교가 가능하다.
 * 		
 * 		"aaa".chartAt(0) 을하면 기존 공간에 a가 저장되있는게 아니라 새로운 공간에 a가 생성되기 때문에
 * 		저장해 놓지 않으면 반영이 안됨.
 * 
 * 		[	StringBuilder, StringBuffer	 ]
 * 		: 내부 버퍼에다 수정내용을 반영해 새로 공간을 할당하지 않고 바로 적용이 가능함.
 * 
 * */
package _4_String;

import java.util.Scanner;
import java.util.regex.Pattern;

public class _4_String_Class {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		
//		String s1 = sc.nextLine();
//		String s2 = sc.nextLine();
//		
//		if(s1 == s2)
//			System.out.println("s1 == s2");
//		else
//			System.out.println("s1 != s2");
//		
		// 객체가 다르기 때문에 다르게 판단됨 ==으로 비교하면
		// 따라서 Object 클래스의 equals를 이용해서 비교해야 함
		// equals도 원래 같은 객체인지 판단하는데
		// String 클래스는 Object의 equals를 오버라이딩해서 내부 값으로 비교할 수 있도록 되어 있기 때문에
		// 따라서 문자열이 같은지 비교는 equals를 사용하자.
//		
//		if( s1.equals(s2) )
//			System.out.println( "s1 == s2" );
//		else
//			System.out.println( "s1 != s2" );
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		int num = 1234;
		String s = num + "";
		StringBuilder sb = new StringBuilder(s); // reverse 메서드 사용 위함
		if ( sb.reverse().toString().equals(s)){ 
			System.out.println("대칭수");
		}else {
			System.out.println("대칭수 아님");
		}
		
		
		
		// 대칭수 중 두 자리 수 2개를 곱해 만들 수 있는 대칭수 중 가장 큰 수는 9009 (91*99) 이다.
		// 세 자리 수 2개를 곱해 만들 수 있는 가장 큰 대칭수는 얼마인가?
		int max = 0;
		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				int mul = i*j;
				if ( isPalindrome(mul + "") ){ // 대칭수
					if ( max < mul ){
						max = mul;
					}
				}
			}
		}
		System.out.println(max);
	
	
	}// end of main
	static boolean isPalindrome(String s){ // 대칭수인지 판별
		StringBuilder sb = new StringBuilder(s);
		
		
		return new StringBuilder(s).reverse().toString().equals(s);
	}
	
	
		

}
