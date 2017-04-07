/*** 
 * 		[		For문		]
 * 			for(int i=0; i<00.length; i++,( j++:여러개올 수 있음)){
 * 				syso
 * 			}
 * */
package _2_IF_Switch_For_While;

public class _4_For {

	public static void main(String[] args) {

		
		// 1000 ~ 8888 까지 쓰는 8의 개수 카운팅(구글입사문제) : 각 자리 수 판별하기. / 10 % 10
		int count = 0;
		
		for(int i=1000; i<=8888; i++){
			for(int j=i; j>0; j /= 10){
				if(j % 10 == 8){
					count++;
				}
			}
		
		}                                  
		System.out.println(count);
		
		
		
		
	////////////////////////////////////////////////////
		
		
		
		
		for (int i = 4; i >= 1; i--) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 1 4 7 10
		for (int i = 1; i <= 10; i += 3) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 1 22 3 44 5 66
		for (int i = 1; i <= 6; i++) {
			if (i % 2 == 0) {
				System.out.print(i + "" + i + " ");
			} else {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		// a ~ z
		for (int i = 'a'; i <= 'z'; i++) {
			System.out.print((char) i + " ");
		}
		System.out.println();

		//
		for (int i = 'a'; i <= 'z'; i++) {
			if (i % 2 == 0) {
				System.out.print((char) (i - ('a' - 'A')) + " ");
			} else {
				System.out.print((char) i + " ");
			}
		}
		System.out.println();

		//
		for (int i = 1; i <= 100; i++) {
			if (i % 5 == 0) {
				System.out.print("5의 배수 ");
			} else {
				System.out.print(i + " ");
			}
		}

		// 2017년 1월 달력 출력

		System.out.println("2017년 1월");
		System.out.println("  일  월  화  수  목  금  토");
		for (int i = 1; i <= 31; i++) {

			System.out.printf("%2d ", i);
			if (i % 7 == 0) {
				System.out.println();
			}
		}

		System.out.println();
		System.out.println();

		System.out.println(" 일   월   화   수   목   금   토");
		int nn = 1;
		for (int i = -2; i <= 28; i++, nn++) {

			if (i <= 0) {
				System.out.print("    ");
			} else {
				if (i <= 9) {
					System.out.print(" ");
				}
				System.out.printf("%2d ", i);
			}
			if (nn % 7 == 0) {
				System.out.println();
			}
		}

		System.out.println();
		System.out.println();

		// 피보나치
		System.out.println("피보나치");
		int n = 7;
		int a = 0, b = 1;

		for (int i = 1; i <= n; i++) {
			a += b;
			b = a - b;
			System.out.print(a + " ");
		}
		System.out.println();
		/////////////////////////////////////////////////////////////////////////////

		for (int i = 1; i < 5; i++) {
			System.out.print((i + 2) + " ");
		}

		// 1 4 7 10
		System.out.println();
		for (int i = 1; i < 5; i++) {
			System.out.print((1 + (3 * (i - 1))) + " ");
		}
		System.out.println();

		// 8 6 4 2
		System.out.println();
		for (int i = 1; i < 5; i++) {
			System.out.print(((-2 * i) + 10) + " ");
		}

		// 9 6 3 0
		System.out.println();
		for (int i = 1; i < 5; i++) {
			System.out.print(((-3 * i) + 12) + " ");
		}

		// -3 1 5 9
		System.out.println();
		for (int i = 1; i < 5; i++) {
			System.out.print(((4 * i) -7 ) + " ");
		}

		// 2 4 6 8
		for(int i=2; i<8; i+=2){
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 4 8 12 16
		for(int i=2; i<=8; i+=2){
			System.out.print((2*i) + " ");
		}
		System.out.println();
		
		System.out.println();
		System.out.println();
		System.out.println();
   
		// 1~10 합구하기 55
		int sum = 0;  // shift + alt + R 해당 변수 이름 전체를 한번에 변경할 수 있음.
		for(int i=1; i<=10; i++){
			sum += i;
		}
		System.out.println("1 ~ 10까지 합 : " + sum);
		
		sum = 0;
		for(int i=1; i<=9; i+=2){
			sum += i;
		}
		System.out.println(sum);
		
		int oddSum = 0;
		int evenSum = 0;
		for (int i = 1; i <= 10; i++) {
			if( i % 2 == 0){
				evenSum += i;
			}else{
				oddSum += i;
			}
		}
		System.out.println("홀수 합 : " + oddSum + " 짝수 합 : " + evenSum);
		/////////////////////////////////////////////////////////////
		
	
	}

}
