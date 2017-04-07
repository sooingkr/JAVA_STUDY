package _10_Interface;
/**
 * interface의 상속
 */
public class TestInterface2 {
	public static void main(String[] args) {
		//Movable m = new Movable();			interface는 객체를 생성할 수 없다
		// Attackable a = new  Attackable();
		//Fightable f = new Fightable();
		Fight f = new Fight();
		System.out.println(f.a);
		System.out.println(f.m);
	}// end of main
}// end of class
interface Movable{
	int m=3;
	void move();
}
interface Attackable{
	public static final int a = 5;
	public abstract void attack();
}
//class의 상속은 자바에서 단일상속만 가능, 최고조상 class = object
//interface의 상속은 다중상속이 가능하다.최고조상의 개념이 없다
interface Fightable extends Movable,Attackable{
}

//implements도 다중 구현이 가능하다,애매모호(ambiguous)한 에러가 발생할 수 있다.
//같은 이름의 상수가 오면 에러가 발생.메소드는 추상메소드이므로 새롭게 구현하므로 신뢰성이 있지만..
class Fight extends Boy implements Fightable,Attackable {//Fightable을 구현한다.
	public void move() {
	}
	public void attack() {
	}
}

class Boy{
	String name="";
	int age;
}