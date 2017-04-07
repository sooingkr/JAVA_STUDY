package _7_Class;

class Car3 {
	String name = "";
	int door;
	String color = "";

	Car3() {

	}

	Car3(String name, int door, String color) {
		this.name = name;
		this.door = door;
		this.color = color;
	}
}

class SportsCar extends Car3 {
	boolean openRoof;

	SportsCar() {
		super();
		this.openRoof = false;
	}

	SportsCar(boolean openRoof) {
		super();
		this.openRoof = openRoof;
	}

	SportsCar(String name, int door, String color, boolean openRoof) {
		super(name, door, color);
		this.openRoof = openRoof;
	}

	void print() {
		System.out.println(this.name + this.door + this.color + this.openRoof + "출력");
	}
}

public class _10_Extends2 {

	public static void main(String[] args) {

		SportsCar c1 = new SportsCar("아반떼", 2, "블랙", true);
		c1.print();

	}

}
