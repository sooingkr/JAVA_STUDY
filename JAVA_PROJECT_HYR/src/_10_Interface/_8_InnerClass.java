package _10_Interface;

public class _8_InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class T {
	int a = 3;
	int x = 5;
	
	static int sa = 4;
	Object o;
	
	void print() {
		//int x = 3; // print(){} 벗어나면 없어지는 지역변수
		final int x = 3; // 상수는 메서드 영역에 상수 pool에 저장되기 때문에 에러를 해결 가능.(프로그램 종료시까지...)
		
		class R { // 메서드 영역에 올라와 있음
			void ppp() { // jdk 1.8에서 가능하게 됨
				
				//System.out.println(x); // 외부 클래스의 지역변수를 참조하고 있다.
				// jdk 1.8에서는 모든 지역변수가 final의 속성을 가지도록 컴파일러가 조작해줘서 메모리에 유지기간을 늘려주어 해결했음.
			}
		}
		R r = new R(); // r, x 등은 스택에 쌓여있게 됨 근대 print메서드 실행하고나면 스택에서 소멸됨.
		o = new R(); // 근대 Object는 참조가 끊어지기 전까진 계속 힙에 있는 R() 메모리를 가리키고 있는대
		// 이미 x는 스택에서 소멸됐기 때문에 접근할 수 없게되는게 맞지만
		// jdk 1.8부터는 이게 가능하도록 한 것 (이전 버전에서는 오류)
		
		// [ 해결책 ] : 메모리에서 삭제되지 않도록 하면 에러를 없앨 수 있다.
		// 1. 지역변수 x를 final붙여 상수화시킨다.(상수는 프로그램 종료시까지 메서드 영역에 상수pool에 존재하기 때매)
		// 2. 전역변수로 뺀다.(R과 운영되는 시점이 동일하기 때문에 사용이 가능)
		
	}
}
