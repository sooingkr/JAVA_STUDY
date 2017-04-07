/** 
 * 		[	메서드(Method) : 실행문의 집합	]
 * 		= 함수
 * 		리턴타입 메서드명(인자값1, 인자값2, ...){
 * 			실행문...
 * 			return ;
 * 		}	
 * */
package _7_Class;

public class _1_Method {

	static void a(int x) {
		System.out.println("a 메서드 인자값 : " + x);
	}

	static int d(int age) {
		return age;
	}
	
	static int f(int a, int b){
		
		return (a * b);
	}

	public static void main(String[] args) {

		int age = 0;
		
		System.out.println("main 시작");

		_1_Method a = new _1_Method(); // 메서드 사용을 위해 객체화
		a.a(7); // 메서드 호출

		// 현재 나이를 (리턴)가져오는 메서드
		age = d( 28 );
		System.out.println(age);
		
		int result = f(3, 6);
		System.out.println("result : " + result);
		
		System.out.println("main 끝");
		
		
	} // end of main

} // end of class
