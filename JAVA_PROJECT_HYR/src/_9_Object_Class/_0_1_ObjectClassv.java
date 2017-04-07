/**
 * 	상속관계의 클래스 객체 생성)
 * 		1. 모든 클래스에는 반드시 하나이상의 생성자가 존재해야한다.
 * 			생성자가 없으면 컴파일러가 기본생성자를 추가해준다.
 * 		2. 모든 생성자에는 반드시 또 다른 생성자를 호출해주는 코드를 첫번째줄에 작성해야 한다.  또 다른 생성자를 호출하지 않으면,
 * 			super() 를 호출해 준다.
 */
package _9_Object_Class;

public class _0_1_ObjectClassv {
	public static void main(String[] args) {
		Ch c = new Ch();
	}
}

class Gr {
	public Gr() {
		super();
	}
}

class Pa extends Gr {

	public Pa() {
		super();
	}
}

class Ch extends Pa {
	public Ch() {
		super();
	}
	public Ch(int a) {
		super();
	}
	public Ch(boolean a) {
		super();// 안적으면 컴파일러가 알아서 추가해줌...
	}
}
