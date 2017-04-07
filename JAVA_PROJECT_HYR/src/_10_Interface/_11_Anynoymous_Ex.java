package _10_Interface;

public class _11_Anynoymous_Ex {

	public static void main(String[] args) {

		Fight2 f = new Fight2(){
			@Override
			void fight() { // fight는 추상클래스라 사용못하는데 익명클래스 써서 사용했음.
				// 인터페이스도 마찬가지로 사용될 수 있음.
				System.out.println("추상클래스 Fight 오버라이딩");
			}
		};
		
		f.fight();
		f.print();
		
		friend(new Fight2(){
			@Override
			void fight() {
				// TODO Auto-generated method stub
				System.out.println("하하하");
			}
		});
	} // end of main

	public static void friend(Fight2 f) {
		f.fight();
		f.print();
	}
	
} // end of class

abstract class Fight2 {
	abstract void fight();
	
	void print() {
		System.out.println("나는 파이트");
	}
}