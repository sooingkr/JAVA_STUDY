package _7_Class;

class Modi {
	public int a;
	protected int b;
	int c; // 아무것도 붙이지 않으면 default 접근제어자가 컴파일러에 의해 자동으로 붙게 됨.
	private int d;

}

public class _13_Modifier2 {

	public static void main(String[] args) {
		Modi d = new Modi();
		// d.d => 접근 불가 : private : 같은 class 내부에서만 가능
		System.out.println(d.b);
		// protected의 경우 같은 패키지거나 + 상속받은 자식에서 접근이 가능
		// 따라서 동일 패키지임으로 접근 가능

		// public 은 어디서 다 접근 가능
	}

}
