/**
 * 		[	Local Inner Class	] : 특정 메서드 내부에서만 잠시 해당 객체가 필요할 때 주로 사용(다른곳에선 안쓰고 일회용으로...)
 * 		: 메서드 내부에서만 오직 사용이 가능함
 * 		=> static 이너를 제외하고는 모두 static 멤버 사용 불가능
 * 
 */
package _10_Interface;

public class _5_LocalInnerClass {

	public static void main(String[] args) {
	
		F f = new F();
		f.print();
		//f.ppp();

	}
}

class F {
	
	int age = 3;
	static int tall = 4;
	public F() {
		System.out.println("클래스 F의 생성자");
	}
	
	void print() {
		int water = 10;
		class G { // 지역변수 영역에 작성된 이너클래스
			int a = 7;
			// static int b = 8; static 사용 불가능 : static 멤버는 static Inner Class에서만 사용 가능
			public G() {
				System.out.println("G클래스의 생성자");
			}
			void x() {}
			// static void y () {}; 불가능
		}
		
		G g = new G();
		g.a++;
		g.x();
	}
	
}
