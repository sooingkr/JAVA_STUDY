/**
 * 	[	abstract 추상 클래스		]
 * 	: 추상메서드를 최소 하나 이상 가지는 클래스를 추상클래스라 한다.
 * 
 * 	=> "추상메서드"란??
 * 		: 선언만하고 구현은 자식에게 위임하는 메서드를 말한다. 즉, 대가리만 있고, 몸통이 없음
 * 
 * 	특징)
 * 		: - 불완전한 추상메서드가 있기 때문에 추상클래스는 객체를 생성할 수 없다.(불완전하니까)
 * 
 */
package _10_Interface;

public class _1_Abstract_Class {

	public static void main(String[] args) {
		
	}

}

abstract class AbsBoy { // 추상 클래스(abstract)
	int age = 10; // 일반전역변수
	int tall;
	
	public abstract void setTall(); // 추상메서드 : 선언부만 있고 구현부 X => 자식에게 구현을 위임
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "나이:" + this.age;
	}
}
