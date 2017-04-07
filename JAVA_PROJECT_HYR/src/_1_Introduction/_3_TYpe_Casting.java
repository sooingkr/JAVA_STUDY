/** 
 * 		[	Type Casting	]
 * 
 * 		- 자동 형변환	: 데이터의 표현범위가 손상되지 않도록은 자동형변환이 된다.
 * 			char,byte->short->int->long->float->double //용량 순 X 표현 범위 순임
 * 
 * 		- 강제 형변환(Type Casting)(=명시적 형변환) : (casting할 타입)
 * */
package _1_Introduction;

public class _3_TYpe_Casting {

	public static void main(String[] args) {
		
		int x = 3;
		long y = x; // 자동 형 변환
		
		x = (int)y; // 명시적 형 변환
		
		double ddd = 3.14;
		int iii = (int)ddd; // 명시적 형 변환
		ddd = 3; // 정수를 double로 자동 형 변환
		
		// 자신의 이름을 저장할 상수에 이름 저장
		final String NAME = "황영롱";
		//자신의 나이를 저장할 변수에 나이 저장 후 출력
		int age = 28;
		
		System.out.println("제 이름은 : " + NAME + "입니다. 나이는 : " + age + "살 입니다.");
		
		int aa = 3;
		int bb = 4;
		int cc = 5;
		System.out.println("aa=" + aa + ", bb=" + bb + " cc=" + cc); //3 4 5
		
		//값의 교환 swap
		int temp = 0;
		temp = aa;
		aa = bb;
		bb = cc;
		cc = temp;
		
		System.out.println("aa=" + aa + ", bb=" + bb + " cc=" + cc); // 4 5 3
		
		
	}

}
