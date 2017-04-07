package _10_Interface;
/**
 * interface : abstract클래스보다 더 추상화도가 높은 개념
 */
public class TestInterface {
	public static void main(String[] args) {

	}// end of main
}// end of class

class A {
	int a;
	void a() {
	}
}

abstract class B {// 추상클래스
	int b;

	void a() {
	}

	abstract void b();// 추상메서드
}

interface Cable {//가능하면 ~able이라고 이름을 지어주는 것이 좋다.다른 클래스와 구분 될 수 있도록.
	public static final int C=3;//상수는 초기화까지 해주어야 한다.
	public int d = 3; // 인터페이스 내부 변수는 static final 생략해도 상수로 인식 됨.
	// void a();//인터페이스에 바디(구현부)가 있는=일반 메소드 구현안됨
	public abstract void b();// 추상메서드 올 수 있음
	void c();//부족한 제어자를 컴파일러가 추가해준다.(abstract 안써도 알아서 abstract로 인식함)
	public void d();
	abstract void e();
}
