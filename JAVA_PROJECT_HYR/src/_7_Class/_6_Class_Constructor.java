package _7_Class;

class Car {
	String name;
	String color;
	int speed;
	
	Car(){ // 인자가 있는 생성자 정의시 default 생성자가 자동으로 컴파일러에 의해 추가되지 않기 때문에
		// 명시해주는 것이 좋다.
		this.name = "default";
		this.color = "default";
		this.speed = 0;
	}
	Car(String name, String color){
		this.name = name;
		this.color = color;
		this.speed = 0;
	}
	Car(String name, String color, int speed){ // 생성자 오버 로딩.
		this(name,color);
		this.speed = speed;
	}
	
	void speedUp(){
		this.speed++;
	}
	void speedDown(){
		this.speed--;
	}
	void stopCar(){
		speed = 0;
	}
	void printCar(){
		System.out.println("자동차명 : " + this.name + "색 : " + this.color + " 스피드 : " + this.speed);
	}
}
public class _6_Class_Constructor {

	public static void main(String[] args) {
		
		Car c1 = new Car("포르쉐","Black",100);
		c1.printCar();
		c1.speedUp();
		c1.speedUp();
		c1.speedDown();
		c1.printCar();
		
		c1.stopCar();
		c1.printCar();
	}

}
