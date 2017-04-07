/*** 
 * 			[		Break		Continue		]
 * 
 * */
package _2_IF_Switch_For_While;

public class _4_2_For_Break_Continue {

	public static void main(String[] args) {
		// 2 4 6 8 10 12
		for (int i = 2; i < 100; i += 2) {
			if (i > 12) {
				break;
			}
			System.out.print(i + " ");
		}
		System.out.println();

		// 1~100 까지의 합을 출력
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			if (sum > 1000) {
				sum -= (i);
				break;
			}
		}
		System.out.println(sum);

		////////////////////////////////////////////////////

		// continue : 반복문의 다음차수로 진행
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				continue;
			System.out.println(i);
		}

		// 7의 배수만 출력
		for (int i = 1; i < 100; i++) {
			if (i % 7 != 0)
				continue;
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		// 구구단
		System.out.printf("\t1단\t           2단\t                 3단\t             4단\t          5단\t              6단\t"
				+ "            7단\t        8단\t             9단\t\t \n");
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%2d * %02d = %02d | ", j, i, (j * i));
			}
			System.out.println();
		}
	}
 
}
