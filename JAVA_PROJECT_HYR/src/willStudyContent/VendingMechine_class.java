package willStudyContent;

import java.util.Scanner;

public class VendingMechine_class {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String item[] = { "콜라", "사이다", "써니텐", "환타", "물", "새우깡", "포카칩", "감자깡", "컵라면" };
		int price[] = { 1220, 990, 880, 720, 510, 1360, 1110, 840, 1530 };

		while (true) {
			for (int i = 0; i < item.length; i++) {

				System.out.println((i + 1) + "." + item[i] + ":" + price[i] + "원");
			}
			System.out.println("0.종료");

			System.out.print("입력 >");
			int input = scan.nextInt(); // 사용자가 고른 메뉴번호

			if (input == 0) { // 종료
				System.out.println("종료");

				// 잔액 반환
				break;

			} else if (1 <= (input) && 9 >= (input)) { // 메뉴
				System.out.println(item[input - 1] + " : " + price[input - 1] + "을 선택했습니다.");
				break;
			} else { // 잘못입력한 경우 무한 반복.
				System.out.println("잘못입력했습니다.\n다시입력하세요.");
			}
		}

	} // end of main

} // end of class
