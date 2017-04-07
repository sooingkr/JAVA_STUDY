package _7_Class;

import java.util.Calendar;
import java.util.Scanner;

public class _2_Method2 {

	static void printHour(){
		Calendar cal = Calendar.getInstance();
		
		System.out.println("현재 시간은 : " + cal.getTime() +"입니다.");
	}
	
	static int yourAge(int age){
		return age;
	}
	
	public static void main(String[] args) {
		
		printName("황영롱"); // 전달받은 인자값 이름 출력 메서드
		
		String name = getName(); // 이름을 리턴하는 메서드
		System.out.println("전달받은 이름 : " + name);
		
		// 현재시간 출력하는 메서드
	//	printHour();
		
		// 나이를 출력하는 메서드
		int age = yourAge( 28 );
		System.out.println("당신의 나이 : " + age + "살");
		////////////////////////////////////////////////////////////
		
		
	}

	

	private static String getName() {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		return name;
	}

	private static void printName(String name) {
		System.out.println("전달받은 이름 : " + name);
	}

}
