/**
 * 		[	다형성(Polymorphism)	]
 * 		: 여러가지 참조형 타입으로 바꿀 수 있는 성질
 * 		=> 부모의 참조변수에 자식의 객체를 저장할 수 있는 성질
 * */
package _7_Class;

public class _15_PolyMorphism {

	public static void main(String[] args) {
		
		Parent p1 = new Parent();
		Child1 c1_1 = new Child1();
		Child2 c2_1 = new Child2();
		GrandChild g1 = new GrandChild();
		
		Parent p; // 참조 변수
		p = p1;
		p = c1_1; // 다형성 : 부모의 참조변수에 자식의 객체를 저장할 수 있다.
		p = c2_1; // O
		p = (Parent)g1; // O
		
		Child1 c;
		c = c1_1;
		// c = c2_1; 에러
		c = g1; // O
		// c = p1; 에러
		// => why?? 데이터 타입이 참조가능한 범위인데 실제 데이터가 부모이면 참조할려는 범위보다 실제 범위가
		// 작기 때문에 참조 못하는 곳을 참조할 수 있는 불안정성 때문에 오류를 띄움.
		
		GrandChild gg = (GrandChild)p; // 원래 타입으로 타입을 변환 
		// 위의 경우이기 때문에 오류가 뜸 따라서 강제형변환이 필요함.
		// 근대 강제형변환의 경우 내부 데이터의손실 유무를 보장안해주기 때문에 메서드를 이용해서 Check를 해줌.
		// ====> "instanceOf"
		
		if (p instanceof GrandChild) { // p를 GrandChild로 형변환해도 괜찮은가?를 Check
			
			gg = (GrandChild)p; // 원래 타입으로 타입을 변환 
			
		}
		
		
	} // end of main

} // end of class

class Parent {}

class Child1 extends Parent{}
class Child2 extends Parent{}
class GrandChild extends Child1{}
