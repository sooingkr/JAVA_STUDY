package _10_Interface;

/**
 * 애매모호한(ambiguous) 에러
 */
public class TestInterface3 {
	public static void main(String[] args) {

		// 인터페이스 객체생성방법
		Able a = new Able() {
			public int v() {
				return c;
			}

			public void vv() {
			}
		};
		Able b = new Able() {
			int g = 3;

			public void vv() {
				System.out.println("꺄" + g);
			}
		};
		b.vv();
		// System.out.println(b.g); 객체생성시 만들어진 변수,메소는 일회성!!!익명객체안에서만 사용가능
	}// end of main
}// end of class

interface Able {
	public static final int x = 3;
	public static final int c = 3;

	default int v(){
		return c;
	};
	void vv();
	// public abstract int print();//다중상속되는 조상에서 메소드 리턴타입이 서로 다르면 상속x
}

interface Bable {
	public static final int x = 3;

	public abstract void print();
}

interface CCCable extends Able, Bable {

}
/*
 * class DDD implements CCCable{ public void print() {
 * //System.out.println(x);//ambiguous //매개변수가 다르면 두 개 모두 상속 가능하며,하나씩 메소드를
 * 구현해주어야 한다. } } class CCC implements Able,Bable{ public void print() {
 * //System.out.println(x);//ambiguous } int v(int c){int d=c+2; return d;} }
 */