package _10_Interface;

public class _12_Anonymous {
	Fightable2 f;

	public static void main(String[] args) {
		Fightable2 f2;
		
		friend(
				new Fightable2(){
					@Override
					public void fight() {
						// TODO Auto-generated method stub
						System.out.println("fight");
					}
				});
		
		f2 = new Fightable2(){
			@Override
			public void fight() {
				System.out.println("hello");
			}
		};
		f2.fight();
		
		
		_12_Anonymous a = new _12_Anonymous();
		a.f = new Fightable2(){
			public void fight() {
				System.out.println("gg");
			};
		};
		a.f.fight();
		System.out.println(a.f.x);
	}

	public static void friend(Fightable2 f3) {
		f3.fight();
	}
}

interface Fightable2 {
	public int x = 3; // interface는 상수 키워드 생략해도 자동으로 붙음

	public void fight(); // interface는 abstract 빼도 abstract로 인식함
	// 불완전하기 때문에 객체를 생성할 수 없음(인터페이스는)
}