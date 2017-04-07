/**
 * 		[  	 Inner Class : 내부 클래스, 중첩(nested) 클래스	 ]
 * 		: 꼭 class A를 사용할 때만 class B가 사용되고 다른대서는 사용할 일이 없을 때.
 * 			A의 멤버처럼 포함시켜 구현.
 * 			내부에서 데이터 쉽게 접근 가능
 * 			외부에서 이름이 중복될 걱정 없음
 * 			
 * 		class A {
 * 			class B {
 * 				
 * 			}
 * 		}
 * 
 * 		종류)
 * 			1. 인스턴스 내부(Inner) 클래스 : 
 * 						외부 클래스 안에 위치하며 static이 붙지 않은 클래스로 외부 클래스의 객체가 생성되어야
 * 						객체를 생성할 수 있음.
 * 				-> 외부 클래스 객체가 생성되어야 이용가능하기 때문에, 내부 클래스 안에는 static 변수, static 메서드가 올 수 없다.
 * 			2. static 이너 클래스
 * 			3. 지역 이너 클래스
 */
package _10_Interface;

public class _3_InnerClass { // 외부(Outer) 클래스

	public static void main(String[] args) {
		
		AA aaa = new AA();
		aaa.a = 3;
		
		AA.B b = aaa.new B(); // 내부 이너 클래스 - 인스턴스 클래스 객체 생성 방법.
		// A클래스 객체가 생성되어 있어야 B객체를 생성할 수 있음.
		AA.B c = new AA().new B();
	}

} // end of class

class AA {

	int a; // 인스턴스 변수
	static int b; // static 변수

	void print() { // 메서드
		int c; // 지역변수
	}

	class B { // 내부(inner) 클래스 -> 1. 인스턴스 클래스(static이 안붙은 경우) : A객체가 생성되 있어야 사용 가능.
		int inb; // 인스턴스 변수
		
		public B() {
			System.out.println("B클래스 생성");
		}
		
		// static int ins; 내부 클래스에서는 static 멤버를 가질 수 없다.(외부 클래스 객체가 생성되어야 이용 가능하니까)
		void p() {} // 인스턴스 메서드는 가능
		// static void pp(){} 는 불가능
	}

}