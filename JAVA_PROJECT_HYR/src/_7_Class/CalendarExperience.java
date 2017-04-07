package _7_Class;

import java.util.Calendar;
import java.util.Date;

class Time {
	int hour;
	int minute;
	int second;
	
	Time(){
		
	}
	Time(int hour, int minute, int second){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return hour + " 시 : " + minute + " 분 : " + second + " 초";
	}
}
public class CalendarExperience {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String str = time.toString();
		System.out.println(str);

		String[] split = str.split(" ");
		String[] split2 = split[3].split(":");
		Time t1 = new Time(Integer.parseInt(split2[0]),Integer.parseInt(split2[1]),Integer.parseInt(split2[2]));
		
		System.out.println(t1);

	}

}
