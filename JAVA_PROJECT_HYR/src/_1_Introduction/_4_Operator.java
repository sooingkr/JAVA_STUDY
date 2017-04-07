/** 
 * 		[	연산자(Operator)	]
 * 		
 * 		=> 단항연산자는 어셈블리어에서 4차례로 이루어지는 계산을 
 * 			단축시켜 한번에 할 수 있어 효율상 1증가 감소에는 단항연산인 ++ --를 쓰는 것이 좋다.
 * 
 * 		=> ***정수 타입들 중 int보다 작은 녀석들은 연산시 int로 변환해 연산하게 된다.
 * */
package _1_Introduction;

public class _4_Operator {

	public static void main(String[] args) {
		
		int a = 3;
		
		System.out.println(++a); // 4 : 전위 증가 => 증감 후 참조
		System.out.println(a++); // 4 : 후위 증가 => 참조 후 증가
		
		//*******************************************
		
		// 논리부정 연산자 : "!"
		boolean flag = true;
		System.out.println(!flag); //false
		
		// 비트부정 연산자 : "~"
		int c = 3;
		System.out.println(~c); // -4
		
		System.out.println(7%3); // 1 (나머지 연산자)
		System.out.println(7/3.0); // 2.333 (나머지 연산자)
		System.out.println(7/(double)3); // 2.333 (나머지 연산자)
		
		// 비트 연산자 : | & ^ >> <<
		System.out.println(13 & 5); // 5
		System.out.println(13 | 5); // 13
		System.out.println(13 ^ 5); // 8
		
		// 논리 연산자 : && ||
		System.out.println(true && true); //true
		System.out.println(true && false);//false
		System.out.println(false && true);// 앞이 false이면 &&는 뒤는 볼필요도 없이 false임으로 뒤는 처리하지도 않는다.
		System.out.println(false && false);//false
		
		System.out.println(true || true);//true => ||는 앞이 true이면 뒤가 머가와도 다 true임으로 뒤를 처리하지 않는다.
		System.out.println(true || false);//true
		System.out.println(false || true);//true
		System.out.println(false || false);//false
		
		// 비교 연산자 : < > <= >= ==(같다.) !=(다르다)
		// 자바스크립트에서는 ===, !== 로 비교가 권장 됨.
		System.out.println(1<<3); // 8
		System.out.println(16>>3); // 2
		
		// 삼항 연산자 : (조건식) ? (true일 때 수행할 식) : (false일 때 실행할 식)
		String conditional = "3항연산자 값 : " + ( "hyr".equals("hyr") ? "이름은 hyr" : "hyr이 아닙니다." );
		System.out.println(conditional);
		
		System.out.println( 3==5 ? "안녕" : 3.14 );
	
		// 대입 연산자 : "=" "+=" "-=" "*=" "/=" "%=" 
		//		: 연산 중 가장 마지막에 수행 됨.
		int num = 4;
		num %= 3;
		System.out.println("4 % 3 값은 : " + num);
	
		int d=3, f, e=4; // 콤마연산자, (같은 타입)을 한번에 선언할 수 있다. 다른 타입끼린 불가능.
		f = d = e = 5; // 대입 연산자( 우->좌 )
		
		System.out.println( 3 * 4 == 12 && 2 + 1 < 4 ); // true
		
		
	}

}
