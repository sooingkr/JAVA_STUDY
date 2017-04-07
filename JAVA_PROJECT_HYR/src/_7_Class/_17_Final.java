/**
 * 	[	상수	:	Final		& 		Enumeration(열거형)	 ]
 * 	: 프로그램 종료시까지 같은 값 유지
 * 
 */
package _7_Class;

public class _17_Final {

	public static void main(String[] args) {
		final float PI = 3.141592f; // 초기화 후 변경 불능
		System.out.println(PI * 3);
		
		_18_Enumeration today = _18_Enumeration.SUNDAY;
		_18_Enumeration today2 = _18_Enumeration.SUNDAY;
		if(today == today2){
			System.out.println("today == today2");
		}
		if(today.equals(today2)){
			System.out.println("today equals today2");
		}
		_18_Enumeration tomorrow = _18_Enumeration.MONDAY;
	
		System.out.println(today.name()); // SUNDAY 문자열로 상수이름 리턴
		System.out.println(today.toString());
		System.out.println(today.compareTo(tomorrow));
		// compareTo => 앞에게 더 크면 0보다 큰 수, 작으면 음수, 같으면 0 출력됨
		System.out.println(today.ordinal()); // 몇번째인지 출력
		System.out.println(day); // null
		day = _18_Enumeration.valueOf("MONDAY"); // _18_Enumeration.MONDAY랑 동일
		System.out.println(day.ordinal());
	}
	static _18_Enumeration day; // 초기값 : null
}
