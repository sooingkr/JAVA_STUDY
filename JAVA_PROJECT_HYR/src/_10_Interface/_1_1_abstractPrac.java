package _10_Interface;

public class _1_1_abstractPrac {
	public static void movePrint(Unit u) { // 다형성(Polymorphism)
		u.move(3, 3);
		//((Dropship)u).load();
	}
	public static void main(String[] args) {
		
		Marine m = new Marine();
		Tank t = new Tank();
		Dropship d = new Dropship();
		m.stimPack(); m.move(3, 1);
		t.changeMode(); t.move(2, 4);
		d.load(); d.move(5, 8);
		///////////////
		System.out.println("\n");
		System.out.println("다형성 이용 : ");
		movePrint(m);
		movePrint(t);
		movePrint(d);
	} // end of main

} // end of class

abstract class Unit {
	int x;
	int y;
	abstract void move(int x, int y);

	void stop(){
		System.out.println("정지");
	}
}

class Dropship extends Unit {

	public Dropship() {
		this(0, 0);
		// TODO Auto-generated constructor stub
	}

	public Dropship(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	void load() {
		System.out.println("유닛 승차 슈웅!");
	}

	void unload() {
		System.out.println("유닛 하차 슈웅!");
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		this.x += x;
		this.y += y;
		System.out.println("(직진이동)이동한 현재 좌표 : ( " + this.x + ", " + this.y + " )");
	}

}

class Marine extends Unit {
	
	void stimPack() {
		System.out.println("스탬팩 사용 쏴아~!");
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		this.x += x;
		this.y += y;
		System.out.println("(언덕은돌아감)이동한 현재 좌표 : ( " + this.x + ", " + this.y + " )");
	}

}

class Tank extends Unit {
	

	void changeMode() {
		System.out.println("시즈모드변경 쓰탱~!");
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		this.x += x;
		this.y += y;
		System.out.println("(느릿느릿)이동한 현재 좌표 : ( " + this.x + ", " + this.y + " )");

	}

}