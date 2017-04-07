/**
 * 		[	초기화 블록	 ]
 * 		: 객체가 생성될 때 생성자 보다 먼저 실행되며 자동으로 실행된다.
 * 		실행순서)
 * 			: static 초기화 블럭 -> 인스턴스 초기화 블럭 -> 생성자 ...
 * 			
 * 		용도)
 * 			: 모든 생성자에서 동일하게 처리해야하는 내용을 묶어서 기술 한다. 
 */
package _13_InitBlock;

public class _1_initBlock {

	public static void main(String[] args) {
	
		Car c = new Car(); // 객체 생성시 static 초기화블럭->인스턴스 초기화블럭->생성자 순으로 실행되면서 객체가 생성.
		
		new Car().pr();
		System.out.println("------");
		Car.pr();

	}
}

class Car {
	String name = "";
	int speed;
	static int sn = 1;
	
	// syso : 이곳에서는 실행문을 사용할 수 없다. 
	
	{ // none-static or 인스턴스 초기화 블럭 : 메서드 사용법과 동일함. ( 리턴값과 파라미터는 없다. 그 외는 동일)
		System.out.println("일반 메서드처럼 실행문이 올 수 있다.");
		System.out.println("초기화블럭1");
	}
	{
		System.out.println("초기화블럭2");
	}
	static { // static 초기화 블럭(인스턴스 초기화 블럭보다 먼저 수행된다.)
		System.out.println("static 초기화 블럭1 : " + sn);
		// static 성질 동일하게 가짐 : none-static 멤버엔 접근할 수 없다.
		sn = 10; // sn은 static 멤버임으로 접근할 수 있다.
		System.out.println("static 초기화 블럭1의 sn 값 : " + sn);
	}

	static void pr(){
		System.out.println("static pr");
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
		sn = 100;
		System.out.println("기본 생성자 : " + sn);
	}
	

	public Car(String name, int speed) {
		super();
		this.name = name;
		this.speed = speed;
	}

	@Override
	public boolean equals(Object obj) { // 내용물이 같은지 판별(Object class 오버라이딩)
		// TODO Auto-generated method stub
		if ( obj instanceof Car ){ // 형변환 가능한지 Check
			Car c = (Car) obj; // 형변환
			if ( this.name.equals( c.name ) && this.speed == c.speed ){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() { // equals 구현시 같이 구현해 주는 게 좋음 hash 알고리즘(Object class)
		// Object 클래스의 hashCode()를 그대로 가져다 사용하면 모든 객체마다 객체의 주소를 이용해 해시코드를 생성하기 때문에
		// 모든 객체들의 해시코드 값이 다르게 나온다.
		// 그러니...... HashSet은 hashCode()를 먼저 수행하고 equals를 수행하기 때문에 hashCode를 오버라이딩해 주지 않으면
		// Object의 해시코드를 돌림으로 같은 내용물이 들어있는 다른 객체들의 경우 주소값을 활용한 서로 다른 해시코드값이 나오기 때문에
		// 전부 다른 객체라고 인식해서 중복된 데이터를 배제시키지 못하는 결과가 될 수 있다.
		// 따라서 equals를 구현할 때 반드시 해시코드를 같이 구현해 주자.
		
		// TODO Auto-generated method stub
		return (name+speed).hashCode(); // String 클래스에서는 문자열 내용으로 해시코드값을 만들어 주도록 오버라이딩되어 있는 것을
		// 활용
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + this.speed;
	}

	public String getName() {
		return name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
