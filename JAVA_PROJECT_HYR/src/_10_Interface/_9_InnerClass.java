/**
 * 		내부클래스 - 외부클래스의 멤버 접근 
 * 			: 외부 클래스명.this.외부클래스멤버변수
 */
package _10_Interface;

public class _9_InnerClass {

	public static void main(String[] args) {

		K.T kt = new K().new T();
		kt.ppp();// 3

		K.ST kst = new K.ST();
		kst.ppp();

		K k = new K();
		k.print();
	} // end of main

} // end of class

class K {
	int a = 3;
	static int sa = 4;

	void print() {
		int a = 5;
		class LT {
				// int a = 3000;
				void ppp() {
					System.out.println(K.this.a);
				}
		}
		LT lt = new LT();
		lt.ppp();
	}

	static class ST {
		// int a = 200;

		void ppp() {
			System.out.println(sa);
			// System.out.println(a); => 전역변수 a접근 불가 non-static이어서...
		}
	}

	class T {
		int a = 10;

		void ppp() {
			System.out.println(K.this.a); // 외부 클래스의 멤버 접근 방법.
		}
	}
}