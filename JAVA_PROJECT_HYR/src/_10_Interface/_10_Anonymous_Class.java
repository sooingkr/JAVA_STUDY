/**
 * 		[	Anonymous 클래스(익명 클래스)	]
 * 
 * 		: 일회성으로 부모 메서드에 있는 메서드를 수정해서 사용하고자 하는 경우
 * 			한번사용할 것인데 부모를 상속받고 오버라이딩해서 한다면 낭비적으로 새로운 class를 기술해야할 것이다.
 * 		
 * 			이 경우, 익명 클래스를 사용하면 유용하다.!!
 * 
 * 		조건)
 * 			- 클래스 or 인터페이스 등이 존재해야 사용가능(단독으론 사용 불가능) : class, 인터페이스 등을 구현해야 객체를 생성할 수 있다.
 * 			- 생성자를 사용할 수 없다.(익명클래스는 클래스 이름이 없으니까...)
 * 			- 익명클래스 작성시 호출하는 생성자는 부모클래스의 것이다.
 */
package _10_Interface;

public class _10_Anonymous_Class {

	public static void main(String[] args) {
		
		Parent p = new Parent( 100 ) { // 익명 클래스
			int b;
			void read(){
				
			}
			@Override
			void print() {
				System.out.println("익명클래스에요");
				read(); // 억지로 read 호출시키려면...
			};
		};
		
		p.print();
		System.out.println(p.a);
		// 이때, p는 Parent 객체가 아니라 Parent를 상속받아 print() 메서드를 오버라이딩한 객체의 주소가 들어있게 되는 것이다!
		// 특히, 이벤트 처리시에 익명 클래스가 많이 쓰인다.
		// read() 메서드는 사용할 수 없음 접근가능한 데이터 Scope가 Parent이기 때문임... Parent가 가지고 있는 메서드들만 사용가능함...
		// 근데, 익명클래스는 이름이 없으니까 자식으로 형변환할 수가 없기 때문에 read()는 사용할 수가 없어...
		// 그니까, 오버라이딩해서 사용할 경우만 쓰게되겠지?
		
		love(p); // 다형성...
		
		love(new Parent(){ // 익명 클래스 활용
			void print(){
				System.out.println("엄마");
			}
		});
	}

	public static void love(Parent p) {
		System.out.println("러브 메서드");
		p.print();
	}
}

class Parent {
	int a;
	public Parent() {
		System.out.println("부모클래스 생성자...");
	}
	
	public Parent(int a) {
		super();
		this.a = a;
		System.out.println(this.a);
	}

	void print() {
		System.out.println("아빠");
	}
}

class Child extends Parent { // 한번만 "딸"로 수정할라고 이렇게 정의하는 것 자체가 낭비
	int b;

	void print() {
		System.out.println("딸");
	};
}