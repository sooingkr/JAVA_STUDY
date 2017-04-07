/**
 * 		[	static 멤버의 사용 제한	]
 * 		: Inner Class에서도 static은 non-static 멤버에 접근할 수 없다.
 */
package _10_Interface;

public class _7_InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} // end of main

} // end of class

class Out1 { // static 멤버에서 non-static 멤버를 접근할 수 없다.
	
	// static I i = new I(); 에러! static은 none-static 접근 불가
	I i = new I();
	
	
	
	int a; // 일반 인스턴스 멤버 변수
	int b = a;
	static int sb;
	int c = sb;
	
	static int sa = sb; // static 멤버 변수
	// static int sc = c; 에러! static 멤버는 non-static 멤버 접근 불가능
	
	void q() {
		
	}
	void p () { // 인스턴스 멤버 메서드
		q(); // 인스턴스 멤버끼리는 가능
		sp(); // 일반 메서드에서 static 메서드 호출 가능
	}
	static void sp() { // static 멤버 메서드
		
	}
	static void sq() {
		sp(); // 같은 static 끼린 가능
		// q(); 에러! static에서 non-static 참조 불가능
		// I iii = new I(); 에러!
		SI si = new SI();
	}
	
	class I {
		
	}
	/////////////////////////////
	static class SI {
		void print(){
			// a++; 불가 외부 클래스의 인스턴스 멤버에 접근 불가(statoc은 non-static에 접근 불가)
			sa++;
			// q(); 불가
			sp();
		}
	}
	
} // end of Out1

