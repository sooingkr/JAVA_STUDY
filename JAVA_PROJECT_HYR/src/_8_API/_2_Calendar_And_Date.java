//		[	날짜를 담당하는 Calendar와 Date 클래스	]

package _8_API;

import java.util.Calendar;
import java.util.Date;

public class _2_Calendar_And_Date {

	public static void main(String[] args) {
		// Date 클래스
		Date now = new Date();
		String time = now.toString();
		System.out.println(time);

		String temp[] = time.split(" ");
		temp = temp[3].split(":");
		System.out.println(temp[0] + " 시 " + temp[1] + " 분 " + temp[2] + " 초 ");

		// Calendar 클래스
		Calendar cal = Calendar.getInstance(); // 싱글톤이기 때문에 getInstance 통해 객체 생성
		Date now2 = cal.getTime();
		String now3 = now2.toString();
		String time2[] = now3.split(" ");
		time2 = time2[3].split(":");
		System.out.println(time2[0] + " 시 " + time2[1] + " 분 " + time2[2] + " 초 ");

	}

}
