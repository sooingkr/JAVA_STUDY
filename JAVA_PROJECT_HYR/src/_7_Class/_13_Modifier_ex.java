package _7_Class;

public class _13_Modifier_ex { // 메인 클래스는 public이나 protected만 가능

	public static void main(String[] args) {
		Chil c = new Chil();
		c.print();
	}

}

class GrandGrandPar {
	int p = -6000;
}

class GrandPar extends GrandGrandPar { // 조부모 클래스
	int p = -500;

	int superP() {
		return super.p;
	}
}

class Par extends GrandPar { // 부모 클래스
	int superP = super.p;
	int p = 1; // 전역 변수

	int superP() { // 부모의 전역변수 p를 리턴하는 메서드
		return super.superP();
	}

	void method() { // 부모 메서드
		int p = -2; // 지역 변수
	}
}

class Chil extends Par { // 자식 클래스
	int p = 30; // 전역 변수

	void print() {
		int p = 400; // 지역 변수
		// 변수의 참조위치에서 가장 가까이 선언된 변수를 참조한다.
		System.out.println(p);
		System.out.println(this.p); // 필드 변수
		System.out.println(super.p); // 부모의 필드 변수

		// 부모의 p 가 없을 경우 조부모의 p가 출력될 것이지만, 부모도 똑같은 이름의 멤버가 있다면
		// 조부모의 p에는 접근할 수 없다.
		System.out.println(new GrandPar().p);
		System.out.println(super.superP());
		System.out.println(super.superP);
		///////////////////////////
		System.out.println("--");
		System.out.println(super.superP());
	}
}
