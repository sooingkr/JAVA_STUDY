/** 
 * 		[	객체지향이란?  ]: 기존 절차지향 언어 + 클래스 개념		
 * 
 * 		[	Class란??	] = "구조체" + "메서드"
 * 		: 현실 세계에 존재하는 객체의 공통된 속성을 뽑아내는 "추상화" 과정을 통해
 * 		=> 필드값과 메서드로 이루어진 "설계도"와 같은 개념으로
 * 		=> 아직 메모리에 잡히지 않은 상태이며
 * 		=> 이 class를 기반으로 만들어져 메모리에 실제로 공간이 할당되었을 때 "객체"라고 한다.
 * 
 * 
 * 
 * 			===> "코드의 재사용성이 증대"(유지보수성 증대)
 * 			===> "캡슐화"
 * 			===> "은닉화"
 * 
 * 		[	Class	vs	 객체	]
 * 		=> 클래스는 메모리에 잡히지 않은 "설계도"(설계도)
 * 		=> 클래스에 설계된 대로 메모리에 할당되면 "객체"(제품)
 * 
 * ************************************************************************************************
 * 		AAA a = new AAA();
 * 		 1  2    3
 * 
 * 		1) AAA라는 클래스가 쓰일 것=> "메서드"영역에 로드되고, 이후 또 AAA가 쓰일 시 추가로 로딩하지 않고
 * 			=> 한번 로딩후에는 그걸 이용.
 * 		2) a => 메모리의 주소를 가리킬 수 있도록 4Byte로 잡힘(지역변수임으로 스택에 생성 됨.)
 * 		3) new => new연산자를 통해 "Heap"영역에 객체가 생성 됨.
 * 
 * 		=> "=" 연산자를 통해 힙에 생성된 객체의 주소가 a 변수에 들어감.
 * 			
 * */
package _7_Class;



class AAA { // 클래스 정의
	// 클래스의 필드
	int w;
	boolean t;
	String name;
	
}
public class _4_Class {

	public static void main(String[] args) {
	
		AAA a = new AAA(); // 객체화(메모리 할당)
		// AAA => 참조형 타입
		// a 변수 크기는 4Byte => 메모리 주소를 가리키도록 되어 있으니까.
		a.w = 100;
		a.t = true;
		a.name = "이름";
		System.out.println(a.name + a.w + a.t);
		
		AAA a2 = new AAA();
		a2.w = 200;
		a2.t = false;
		a2.name = "이름2";
		System.out.println(a2.name + a2.w + a2.t);
		
		
		
	} // end of main

} // end of class
