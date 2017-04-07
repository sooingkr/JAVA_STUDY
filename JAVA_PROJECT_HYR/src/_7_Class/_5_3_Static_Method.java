/*
 * 	[	static 메서드 활용  ]
 * 	: 객체 생성없이 클래스명으로 접근할 수 있다.
 * 	=> static 메서드에서는 static이 아닌 변수들은 사용할 수 없다. 아직 객체가 안만들어졌을 경우도 있으니까.
 * 	==> 따라서, 단순히 출력만하거나, static 멤버들만 사용할 경우 static 메서드 사용을 고려할 수 있다.
 * 
 * 	=>>> 굳이, 객체를 안만들고 사용할 수 있을 때 선언하는게 좋다.
 */
package _7_Class;

class MyMath {
	static int sum(int a, int b) { // 입력받은 2숫자의 합을 리턴하는 메서드
		return (a + b);
	}
}

public class _5_3_Static_Method {

	public static void main(String[] args) {

		Math.random(); // Math Class는 모두 static 메서드로 구성되어 있음.
		// 객체 생성없이 이용가능.

		System.out.println( MyMath.sum(10, 3) );
		
		
	} // end of main

} // end of class
