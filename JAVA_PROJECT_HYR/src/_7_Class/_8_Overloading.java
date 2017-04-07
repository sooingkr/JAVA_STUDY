/** 
 * 	[	Overloading(오버로딩)		]
 * 
 * 	: 같은 class 내에서 메서드 명을 동일하게 사용하는 기법
 * 
 * 	조건)
 * 		=> 매개변수의 개수 or 타입이 다르거나 순서가 달라야 한다. 그 외로 구분될 순 없다.(리턴 타입만 다른 경우는 X)
 * 	
 * 	종류)
 * 		1. 메서드 오버로딩(Method Overloading)
 * 		2. 생성자 오버로딩(Constructor Overloading)
 * */
package _7_Class;

class MyMath2 {
	int x;
	int y;
	
	// 생성자 오버로딩
	public MyMath2() {
		super();
	}
	public MyMath2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	// 메서드 오버로딩
	void sum(boolean a){}
	void sum(boolean a, int b){}
	
	void sum(int a) {
		System.out.println(a + 3);
	}

	void sum(int a, int b) {
		System.out.println(a + b);
	}

	void sum(int a, int b, int c) {
		System.out.println( a + b + c );
	}

}

public class _8_Overloading {

	public static void main(String[] args) {
		MyMath2 mm = new MyMath2();
		mm.sum(5);
		mm.sum(3, 9);
		mm.sum(3,9,7);
	} // end of main

} // end of class
