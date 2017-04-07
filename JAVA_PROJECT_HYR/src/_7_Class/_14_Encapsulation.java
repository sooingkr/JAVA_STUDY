/**
 * 	[	Encapsulation 캡슐화	] : 내부 데이터 보호 ( getter/setter를 통해)
 * 
 * */
package _7_Class;

public class _14_Encapsulation {

	public static void main(String[] args) {
		Time2 t = new Time2();
		// t.hour = 170; // 0 ~ 23
		// t.minute = -33;
		// t.second = 27;
		// System.out.println(t.hour + " : " + t.minute + " : " + t.second);

		t.setHour(170);
		t.setMinute(-33);
		t.setSecond(2700);
		System.out.println(t.getHour() + " : " + t.getMinute() + " : " + t.getSecond()); // 0
																							// :
																							// 0
																							// :
																							// 0
		t.setHour(17);
		t.setMinute(33);
		t.setSecond(27);
		System.out.println(t.getHour() + " : " + t.getMinute() + " : " + t.getSecond()); // 17
																							// :
																							// 33
																							// :
																							// 27
	}

}

class Time2 { // 시간을 추상화한 클래스
	private int hour;
	private int minute;
	private int second;

	Time2(){
		this(0,0,0);
	}
	Time2(int hour, int minute, int second) {
		// 생성자에서도 유효성 검사하도록 setter를 통해 초기화
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) { // 0 ~ 23
		if (0 <= hour && 23 >= hour) {
			this.hour = hour;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) { // 0 ~ 59
		if (0 <= minute && 59 >= minute) {
			this.minute = minute;
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) { // 0 ~ 59
		if (0 <= second && 59 >= second) {
			this.second = second;
		}
	}

}
