/**
 * 		[	다형성과 오버라이딩을 동시에 할 때 발생할 수 있는 주의점!	]
 * 
 * 		=> 메서드는 실제 담긴 객체의 메서드가 호출되고,
 * 		=> 변수는 참조타입이 가리키는 변수가 호출된다.
 * */
package _9_Object_Class;

import java.util.HashSet;

public class _0_ObjectClass {

	public static void main(String[] args) {

		Par p = new Par();
		Chil c = new Chil();
		Par pp = c; // 다형성
//	    Chil cc = pp; 오류!!
		Chil cc = null;
		if (pp instanceof Chil) {
			cc = (Chil) pp;
			
		}
		// Par이 가지고 있는 범위내에서 접근가능하게 됨.
		// 이 같은 이유로 부모를 자식에 넣을 때는 오류가 뜨게 되는 것!
		
		p.over();
		c.over();
		///////////////////
		System.out.println();
		System.out.println( pp.x ); // 10 : 참조변수 타입의 변수가 출력
		System.out.println( c.x ); // 200
		pp.over(); // 자식의 Over : 메서드는 실제 저장된 객체의 메서드가 실행
		cc.over(); // 자식의 Over
	} // end of main

} // end of class

class Par {
	int age;
	int x = 10;
	void p() {
		
	}
	void over() { // Overriding
		System.out.println("부모 Over");
	}
}

class Chil extends Par {
	int money;
	int x = 200;
	void c() {
		
	}
	void over() {
		System.out.println("자식의 Over");
	}
}
