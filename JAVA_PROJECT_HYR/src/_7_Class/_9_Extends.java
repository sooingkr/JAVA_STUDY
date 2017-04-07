/** 
 * 	[		클래스의 상속(Inheritance)		]
 * 
 * 	 : 클래스간의 (부모-자식) 관계를 맺어 주는 것
 * 		=> 부모의 전역변수와 메서드만 상속받을 수 있다. // 생성자 등은 x
 * 	
 * 	키워드)   "extends"
 */
package _7_Class;

class Tv2 {
	String name;
	int channel;
	boolean power;

	public Tv2() {

	}

	public Tv2(String name, int channel, boolean power) {

		this.name = name;
		this.channel = channel;
		this.power = power;
	}

	void channelUp() {
		this.channel++;
	}

	void powerOnOff() {
		power = !power;
	}

}

class CaptionTv extends Tv2 {

	boolean caption; // 자막방송 유무

	CaptionTv() {

	}

	public CaptionTv(boolean caption) {
		super();
		this.caption = caption;
	}

	public CaptionTv(String name, int channel, boolean power) {
		super(name, channel, power);
		// TODO Auto-generated constructor stub
	}

	public CaptionTv(String name, int channel, boolean power, boolean caption) {
		super(name, channel, power);
		this.caption = caption;
		// this.name = name; 처럼 해도 되고....
	}

	void displayCaption(String text) {
		if (this.caption) {
			System.out.println(text);
		} else {
			System.out.println("caption 자막방송이 꺼져 있음");
		}
	}

	void print() {
		System.out.println(name + channel + power + caption);
	}
}

public class _9_Extends {

	public static void main(String[] args) {

		Tv2 t = new Tv2("삼성파브", 11, true);
		CaptionTv ct = new CaptionTv();
		ct.name = "삼성파브";
		ct.channel = 11;
		ct.power = true;
		ct.caption = false;

		CaptionTv ct2 = new CaptionTv("삼성파브", 11, true, false);
		ct2.print(); // 삼성파브11truefalse
		ct2.powerOnOff(); // 삼성파브11falsefalse
		ct2.print();
		ct2.caption = true;
		ct2.displayCaption("호랑이가 살금살금 다가온다.(자막)");

	} // end of main

} // end of class
