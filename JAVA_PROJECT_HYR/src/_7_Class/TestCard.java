package _7_Class;

class Tank {
	int hp = 100;
	int attackPowerOn = 50;
	int attackPowerOff = 20;
	boolean mode;

	void attack(Tank temp) { // 상대방을 공격하는 메서드
		if ( temp.hp == 0 ){
			System.out.println("상대방은 이미 죽어 공격할 수 없습니다.");
			return; // 아래 수행하지 않고 메서드 종료.
		}
		if (mode == true) {
			temp.hp -= this.attackPowerOn;
		} else if (mode == false) {
			temp.hp -= this.attackPowerOff;
		}

		if (temp.hp < 0) {
			temp.hp = 0; // 음수 방지
		}
	}

	void printTank(String name) {
		if (this.hp == 0) {
			System.out.println(name + "은 죽었습니다.");
		} else {
			System.out.println(name + " 체력: " + this.hp + ", mode : " + this.mode);
		}
	}
}

public class TestCard {

	public static void main(String[] args) throws CloneNotSupportedException {

		Tank t1 = new Tank();
		Tank t2 = new Tank();
		t1.printTank("t1");
		t1.attack(t2);
		t2.printTank("t2");

		t2.mode = true;
		t2.attack(t1);
		t1.printTank("t1");
		t2.printTank("t2");
	}
}