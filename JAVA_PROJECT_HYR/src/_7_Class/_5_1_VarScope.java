package _7_Class;
/* 
 * 		[	변수	  ]
 * 
 * 		1. 전역변수 : 초기화하지 않으면 0 or Null로 초기화 됨. 
 * 			=> "메서드 영역"에 저장.
 * 			=> 메서드 영역에는, 바이트 코드(JVM위에서 동작할 수 있는 코드), static 등이 올라온다.
 * 		2. 지역변수 : 초기화하지 않으면 "쓰레기 값"이 들어가 "컴파일 오류"가 뜸.
 * 			=> "스택"에 저장되어 해당 블록을 벗어나면 소멸됨.
 * 		3. static 변수 : 
 * 			=> "메서드 영역"에 저장되며 클래스가 "메서드 영역"에 잡힐 때 같이 잡히게 된다.
 * 			=> 별도의 객체 생성 없이 접근할 수 있으며, 따라서 "클래스 변수, 클래스 메서드"라고 부른다.
 * 			=> 프로그램 종료시에 소멸되기 때문에 성능문제상 주의해서 사용해야 한다.
 * 			=> static 변수 등은 지역변수 등에는 접근할 수 없는데 why? 객체가 생성되지도 않았는데 접근할 수도 있잖아.
 * 
 * 		[	메모리 영역	]
 * 		1. 메서드 영역 
 * 			: JVM위에서 동작할 수 있는 "바이트 코드", class 선언, static 변수, 전역변수 등이 저장됨.
 * 		2. 스택
 * 			: 지역변수, 메서드 등이 쌓임 (FILO 구조)
 * 		3. 힙
 * 			: new 연산자를 통한 동적할당, 생성된 객체 들이 저장 됨.
 * 			=> 자바는 Garbage Collector에 의해서, 프로그램이 여유가 있을 때 참조가 끊어진 객체들을 정리함
 * 			=> System.gc() => System.finalization() 호출.
 * */

class BOOK {
	// 클래스 필드
	String name = "";
	String publisher = "";
	int price;

	// 클래스 메서드
	void printBook() {
		System.out.println(this.name + this.publisher + this.price);
	}
}

public class _5_1_VarScope {

	String name; // 전역변수 => 초기화하지 않으면 NULL
	int price; // 전역변수 => 초기화하지 않으면 0이 들어 있음.

	public static void main(String[] args) {
		
		BOOK b1 = new BOOK();
		b1.name = "나는 자바다";
		b1.publisher = "신용권";
		b1.price = 30000;
		b1.printBook();
		
		BOOK b2 = new BOOK();
		b2.name = "자바의 정석";
		b2.price = 27000;
		b2.printBook();
		
	}

}
