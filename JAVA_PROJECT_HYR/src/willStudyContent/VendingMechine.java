package willStudyContent;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Mechine {
	int cnt[] = new int[] { 50, 100, 10, 30 };
	int rest;
	int message;

	static String[] productName = new String[] { "콜라", "사이다", "써니텐", "환타", "물", "새우깡", "포카칩", "감자깡", "컵라면" };
	int[] productPrice = new int[] { 1220, 990, 880, 720, 510, 1360, 1110, 840, 1530 };

	Mechine(int inputMoney, int sel) {

		this.rest = inputMoney - productPrice[sel - 1];
		this.message = 0;
	}

	public String changeMoney() {
		int coin[] = new int[] { 0, 0, 0, 0 };
		int temp[] = new int[] { 500, 100, 50, 10 };
		for (int i = 0; i < cnt.length; i++) {
			if (this.cnt[i] > 0) {

				coin[i] = this.rest / (temp[i]);
				if (this.cnt[i] < coin[i]) {
					coin[i] -= (coin[i] - this.cnt[i]);
				}
				this.cnt[i] -= coin[i];
				if (coin[i] != 0) {
					this.rest %= (temp[i] * coin[i]);
				}

			}
		}
		if (this.rest != 0) {
			this.message = this.rest;
		}

		System.out.println("거스름 돈 : "
				+ ((coin[0] * temp[0]) + (coin[1] * temp[1]) + (coin[2] * temp[2]) + (coin[3] * temp[3])) + " ");
		return ("500원 : " + coin[0] + "  100원 : " + coin[1] + " 50원 : " + coin[2] + "  10원 : " + coin[3] + " ");
	}

	public void restCharge() {
		System.out.println(
				"500원 : " + this.cnt[0] + " 100원 : " + this.cnt[1] + " 50원 : " + this.cnt[2] + " 10원 : " + this.cnt[3]);
	}
}

public class VendingMechine {
	public static int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("<자판기 메뉴판>");
		System.out.println(
				"1.콜라:1220원\n2.사이다:990원\n3.써니텐:880원\n4.환타:720원\n5.물:510원\n6.새우깡:1360원\n7.포카칩:1110원\n8.감자깡:840원\n9.컵라면:1530원\n0.종료\n");
		System.out.print("선택 >");
		
		int sel = sc.nextInt();
		return sel;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputCash = 0;
		Mechine m1 = null;

		do {
			System.out.println();
			int sel = menu();
			if (0 <= sel && 9 >= sel) {
				if (sel == 0) {
					break;
				} else {
					switch (sel) {
					case 1:
						System.out.print("입금액 >");
						inputCash = sc.nextInt();

						m1 = new Mechine(inputCash, sel);
						if (inputCash < m1.productPrice[sel - 1]) {
							System.out.println("물건 가격보다 적은 금액을 넣으셨습니다. 다시 금액을 입력해 주세요 : ");
							break;
						}
						System.out.println("선택한 상품은 : " + m1.productName[sel - 1] + "이고, ");
						System.out.println(m1.changeMoney());

						break;
					case 2:
						System.out.print("입금액 >");
						inputCash = sc.nextInt();
						m1 = new Mechine(inputCash, sel);
						if (inputCash < m1.productPrice[sel - 1]) {
							System.out.println("물건 가격보다 적은 금액을 넣으셨습니다. 다시 금액을 입력해 주세요 : ");
							break;
						}
						System.out.println("선택한 상품은 : " + m1.productName[sel - 1] + "이고, ");
						System.out.println(m1.changeMoney());
						break;
					case 3:
						System.out.print("입금액 >");
						inputCash = sc.nextInt();
						m1 = new Mechine(inputCash, sel);
						if (inputCash < m1.productPrice[sel - 1]) {
							System.out.println("물건 가격보다 적은 금액을 넣으셨습니다. 다시 금액을 입력해 주세요 : ");
							break;
						}
						System.out.println("선택한 상품은 : " + m1.productName[sel - 1] + "이고, ");
						System.out.println(m1.changeMoney());
						break;
					case 4:
						System.out.print("입금액 >");
						inputCash = sc.nextInt();
						m1 = new Mechine(inputCash, sel);
						if (inputCash < m1.productPrice[sel - 1]) {
							System.out.println("물건 가격보다 적은 금액을 넣으셨습니다. 다시 금액을 입력해 주세요 : ");
							break;
						}
						System.out.println("선택한 상품은 : " + m1.productName[sel - 1] + "이고, ");
						System.out.println(m1.changeMoney());
						break;
					case 5:
						System.out.print("입금액 >");
						inputCash = sc.nextInt();
						m1 = new Mechine(inputCash, sel);
						if (inputCash < m1.productPrice[sel - 1]) {
							System.out.println("물건 가격보다 적은 금액을 넣으셨습니다. 다시 금액을 입력해 주세요 : ");
							break;
						}
						System.out.println("선택한 상품은 : " + m1.productName[sel - 1] + "이고, ");
						System.out.println(m1.changeMoney());
						break;
					case 6:
						System.out.print("입금액 >");
						inputCash = sc.nextInt();
						m1 = new Mechine(inputCash, sel);
						if (inputCash < m1.productPrice[sel - 1]) {
							System.out.println("물건 가격보다 적은 금액을 넣으셨습니다. 다시 금액을 입력해 주세요 : ");
							break;
						}
						System.out.println("선택한 상품은 : " + m1.productName[sel - 1] + "이고, ");
						System.out.print(m1.changeMoney());
						break;
					case 7:
						System.out.print("입금액 >");
						inputCash = sc.nextInt();
						m1 = new Mechine(inputCash, sel);
						if (inputCash < m1.productPrice[sel - 1]) {
							System.out.println("물건 가격보다 적은 금액을 넣으셨습니다. 다시 금액을 입력해 주세요 : ");
							break;
						}
						System.out.println("선택한 상품은 : " + m1.productName[sel - 1] + "이고, ");
						System.out.print(m1.changeMoney());
						break;
					case 8:
						System.out.print("입금액 >");
						inputCash = sc.nextInt();
						m1 = new Mechine(inputCash, sel);
						if (inputCash < m1.productPrice[sel - 1]) {
							System.out.println("물건 가격보다 적은 금액을 넣으셨습니다. 다시 금액을 입력해 주세요 : ");
							break;
						}
						System.out.println("선택한 상품은 : " + m1.productName[sel - 1] + "이고, ");
						System.out.print(m1.changeMoney());
						break;
					case 9:
						System.out.print("입금액 >");
						inputCash = sc.nextInt();
						m1 = new Mechine(inputCash, sel);
						if (inputCash < m1.productPrice[sel - 1]) {
							System.out.println("물건 가격보다 적은 금액을 넣으셨습니다. 다시 금액을 입력해 주세요 : ");
							break;
						}
						System.out.println("선택한 상품은 : " + m1.productName[sel - 1] + "이고, ");
						System.out.print(m1.changeMoney());
						break;
					} // end switch
				}
			} else {
				System.out.println("잘못입력하셨습니다. 다시입력해 주세요");
			}
		} while (true);

		System.out.println(m1.changeMoney());
		if (m1.message != 0) {
			System.out.println("죄송합니다. 거슬러줄 동전이 부족합니다. 남은 잔액 : " + m1.message + "원");
		}
		// System.out.print("거슬러 주고 남은 잔고 : ");
		// m1.restCharge();

	}

}
