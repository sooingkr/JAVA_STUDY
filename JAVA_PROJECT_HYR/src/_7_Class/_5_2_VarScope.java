package _7_Class;

class GG {
	void m1(){
		m2();
		System.out.println("m1");
	}
	void m2(){
		m3();
		System.out.println("m2");
	}
	void m3(){
		System.out.println("m3");
	}
}
public class _5_2_VarScope {

	public static void main(String[] args) {
		GG g = new GG();
		g.m1();
		// m3 m2 m1 순으로 출력
	}

}
