/**
 * 		[	Static Inner Class	] : 이녀석만 static 멤버를 가질 수 있다.
 * 	class D {
		int age;
		static int tall;

		public D() {
			System.out.println("D 클래스 생성자");
		}
		void print(){
		
		}
		static class E { // Static Inner Class
		
		}
	}
 */
package _10_Interface;

class _4_StaticInnerClass {
	public static void main(String[] args) {
		D.tall = 3;
		D.E.water++; // 객체 생성없이 바로 접근할 수 있다.
		D.E.sss();
		D.E eee = new D.E(); // static이기 때문에 D 객체를 생성할 필요 없음.
		eee.cnt++;
		eee.print();
		
	}// end of main
}

class D {
	int age;
	static int tall;

	public D() {
		System.out.println("D 클래스 생성자");
	}

    void print() {
    	
	}

	static class E { // Static Inner Class
		
		int cnt = 6;
		static int water = 10; // static 멤버를 가질 수 있다.
		public E() {
			System.out.println("E클래스 생성자");
		}
		void print() {
			
		}
		static void sss() {}
	}
}