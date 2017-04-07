package _2_IF_Switch_For_While;

import java.util.Scanner;

public class _5_While_DoWhile {

	public static void main(String[] args) {
		// 1 2 3 4 5 while 문 이용해서 찍기
		int num = 0;
		while (true) {
			if (num >= 6) {
				System.out.println(num);
				break;
			}
			System.out.print(num++ + ", ");
		}

		// 13, 26,39,.... 네 자리수 중 13의 배수까지
		num = 13;
		while (true) {
			if ((num + 13) > 10000) {
				System.out.println(num);
				break;
			} else {
				System.out.print((num));
				num += 13;
			}
			System.out.println(", ");
		}

		// 사용자 입력을 숫자로 받아서 출력
		// 0을 입력하는 순간 종료
		Scanner sc = new Scanner(System.in);
		int num2 = -1;
		while (true) {
			System.out.print("숫자를 입력하세요 : ");
			num2 = sc.nextInt();
			if (num2 == 0) {
				System.out.println("0입력! 종료합니다.");
				break;
			}
		}

		// Do~While : 최소 1번이상은 실행을 보장한다.
		num2 = 1;
		do{
			System.out.println( num );
		}while( num2 > 3);
	////////////////////////////////////////////////////////////
		
		
	}

}
