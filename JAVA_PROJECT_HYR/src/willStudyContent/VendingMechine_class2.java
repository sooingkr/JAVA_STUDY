// 자판기 프로그램2 : 문자로 물어보면 가격과 선택한 제품을 출력 종료를 누르면 종료.
package willStudyContent;

import java.util.Scanner;

public class VendingMechine_class2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String item[] = { "콜라", "사이다", "써니텐", "환타", "물", "새우깡", "포카칩", "감자깡", "컵라면" };
		int price[] = { 1220, 990, 880, 720, 510, 1360, 1110, 840, 1530 };
		int choice = 0; // 사용자가 선택한 아이템 index

		// 메뉴 출력
		System.out.println("<자판기 메뉴판>");

		for (int i = 0; i < item.length; i++) {
			System.out.println(item[i] + ";" + price[i] + "원");
		}
		System.out.println("종료");
		// **************************************************************************************************

exit:	 while (true) { // lable exit == C언어의 goto 문.
			System.out.println("입력 > ");
			String input = scan.next();

			// 종료를 입력한 경우
			if ("종료".equals(input)) { // 종료는 상수여서 null이 아님을 보장할 수 있기 때문에 이렇게 함.
				System.out.println("종료");
				break;
			}

			// 제품 이름을 입력한 경우
			for (int i = 0; i < item.length; i++) {
				if (item[i].equals(input)) {
					choice = i;
					System.out.println(item[choice] + ": " + price[choice] + "를 선택하셨습니다.");
					break exit; // lable exit
				}
				if (i == item.length - 1) { // for문을 다돌았는대도 exit하지 않은 건 찾지
											// 못한거니까.
											// flag로 처리는 될 수 있으면 하지 말자.
					System.out.println("해당 제품은 없습니다.\n다시입력하세요.");
				}
			} // end of while

		}
	} // end of main
} // end of class
