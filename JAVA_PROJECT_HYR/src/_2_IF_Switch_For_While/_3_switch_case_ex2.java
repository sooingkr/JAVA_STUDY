package _2_IF_Switch_For_While;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class _3_switch_case_ex2 {

	// 마지막 날짜 구하기
	public static void main(String[] args) {
		for (int month = 1; month <= 12; month++) {
			GregorianCalendar cld = new GregorianCalendar(2017, month - 1, 1);
			System.out.println(month + "/" + cld.getActualMaximum(Calendar.DAY_OF_MONTH));
			
		}
			
		
	}

}
