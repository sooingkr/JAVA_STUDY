// 제품 시리얼넘버 부여하기 - static 활용해 객체 생성할 때마다 서로 다른 제품번호가 할당되도록...

package _7_Class;

class Tv {
	int serialNum; // 제품의 시리얼 넘버(제품마다 다른(Unique))
	static int serial = 1000; // static을 이용해서 객체 생성시마다 다른 제품 번호가 들어갈 수 있도록 함.

	Tv() {

		this.serialNum = serial++;
	}
}

public class _5_4_Static_Ex {

	public static void main(String[] args) {

		Tv t1 = new Tv();
		Tv t2 = new Tv();
		Tv t3 = new Tv();
		System.out.println(t1.serialNum);
		System.out.println(t2.serialNum);
		System.out.println(t3.serialNum);
	}

}
