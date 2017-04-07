package _10_Interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bank {
	ArrayList accountArray = new ArrayList();
	Scanner scanner = new Scanner(System.in);
	Account account = new Account();
	ArrayList arr = new ArrayList();

	class Account {
		private String accountnum = "";
		private String name = "";
		private String pw = "";
		private int money;

		public Account() {
		}

		public Account(int money) {
			this.money = money;
		}

		public Account(String accountnum, String name, String pw, int money) {
			super();
			this.accountnum = accountnum;
			this.name = name;
			this.pw = pw;
			this.money = money;
		}

		public String getAccountnum() {
			return accountnum;
		}

		public String getName() {
			return name;
		}

		public String getPw() {
			return pw;
		}

		public int getMoney() {
			return money;
		}

		public void setAccountnum(String accountnum) {
			this.accountnum = accountnum;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setPw(String pw) {
			this.pw = pw;
		}

		public void setMoney(int money) {
			this.money += money;
		}

	}

	void menuStart(Bank b, boolean run) {
		while (run) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("1.입금|2.출금|3.잔고조회|4.거래내역조회|5.이체|6.계좌생성|7.종료");
			System.out.println("-----------------------------------------------------------");
			System.out.println("선택>");
			int selectNo = scanner.nextInt();
			switch (selectNo) {
			case 1:
				b.deposit();
				break;
			case 2:
				b.withdraw();
				break;
			case 3:
				b.balance();
				break;
			case 4:
				b.checkAccount();
				break;
			case 5:
				b.transfer();
				break;
			case 6:
				b.createAccount();
				break;
			case 7:
				run = false;
				break;
			default:
				System.out.println("1~7까지의 숫자 중 하나로 입력하세요");
				break;
			}
		}
		System.out.println("프로그램종료");

	}

	void deposit() {
		exit: while (true) {
			System.out.print("입금 할 계좌를 입력하세요");
			String accountnum = scanner.next();
			for (int j = 0; j < accountArray.size(); j++) {
				Account aa = (Account) accountArray.get(j);
				if (aa.getAccountnum().equals(accountnum)) {
					System.out.println("입금 할 금액을 입력하세요");
					int money = scanner.nextInt();
					if (money < 0) {
						System.out.println("0보다 큰 금액을 입력해주세요");
						break;
					} else {
						aa.setMoney(money);
						String m = money + "";
						arr.add(aa.getName() + "님께서" + m + "을(를) 입금해서 잔고가" + aa.getMoney() + "원이 되었습니다");
						System.out.println("입금되었습니다");
						System.out.println(aa.getName() + "님의 잔고는" + aa.getMoney() + "원 입니다");
						break exit;
					}
				} else if (j == accountArray.size() - 1) {
					System.out.println("해당 계좌번호는 존재하지 않습니다");
					break exit;
				}
			}
		}
	}

	void withdraw() {
		System.out.print("출금을 원하는 계좌를 입력하세요");
		String accountnum = scanner.next();
		for (int j = 0; j < accountArray.size(); j++) {
			Account aa = (Account) accountArray.get(j);
			if (aa.getAccountnum().equals(accountnum)) {
				System.out.println("출금 할 금액을 입력하세요");
				int money = scanner.nextInt();
				aa.setMoney(-money);
				accountArray.add(aa);
				String m = money + "";
				arr.add(aa.getName() + "님께서" + m + "을(를) 출금해서 잔고가" + aa.getMoney() + "원이 되었습니다");
				System.out.println("출금되었습니다");
				System.out.println(aa.getName() + "님의 잔고는" + aa.getMoney() + "원 입니다");
				break;
			} else if (j == accountArray.size() - 1) {
				System.out.println("해당 계좌번호는 존재하지 않습니다");
			}
		}
	}

	void balance() {// 잔고조회
		System.out.print("잔고를 확인하고 싶은 계좌를 입력하세요");
		String accountnum = scanner.next();
		for (int j = 0; j < accountArray.size(); j++) {
			Account aa = (Account) accountArray.get(j);
			if (aa.getAccountnum().equals(accountnum)) {
				System.out.println(aa.getName() + "님의 잔고는" + aa.getMoney() + "원 입니다");
				break;
			} else if (j == accountArray.size() - 1) {
				System.out.println("해당 계좌번호는 존재하지 않습니다");
			}
		}
	}

	void checkAccount() {// 거래내역조회
		String arr2[] = new String[arr.size()];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = (String) arr.get(i);
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}

	void transfer() {// 이체
		System.out.print("내 계좌를 입력하세요");
		String accountnum1 = scanner.next();
		System.out.print("이체 할 계좌를 입력하세요");
		String accountnum3 = scanner.next();
		System.out.print("이체 할 금액 입력하세요");
		int money = scanner.nextInt();
		exit: for (int j = 0; j < accountArray.size(); j++) {
			Account aa = (Account) accountArray.get(j);
			if (aa.getAccountnum().equals(accountnum1)) {
				for (int i = 0; i < accountArray.size(); i++) {
					Account aa2 = (Account) accountArray.get(i);
					if (aa2.getAccountnum().equals(accountnum3)) {
						aa2.setMoney(money);
						aa.setMoney(-money);
						System.out.println("이체되었습니다");
						String m = money + "";
						arr.add(aa.getName() + "님께서" + aa2.getName() + "님께" + m + "원 을(를) 이체해서\n" + "-" + aa.getName()
								+ "의 잔고는" + aa.getMoney() + "원," + aa2.getName() + "님의 잔고는" + aa2.getMoney() + "원 입니다");
						System.out.println(aa.getName() + "님께서" + aa2.getName() + "님께" + m + "원 을(를) 이체했습니다");
						System.out.println(aa.getName() + "님의 잔고는 " + aa.getMoney() + "원," + aa2.getName() + "님의 잔고는"
								+ aa2.getMoney() + "원 입니다");
						break exit;
					} else if (j == accountArray.size() - 1) {
						System.out.println("해당 계좌번호는 존재하지 않습니다");
						break exit;
					}
				}
			}
		}
	}

	void createAccount() {// 계좌생성
		System.out.print("통장을 개설할 계좌번호를 입력하세요");
		scanner.nextLine();
		String accountnum = scanner.nextLine();
		System.out.print("이름을 입력하세요");
		String name = scanner.nextLine();
		System.out.print("비밀번호를 입력하세요");
		String pw = scanner.nextLine();
		int money2 = 0;
		boolean f = true;
		while (f) {
			System.out.print("통장에 천원이상 입금하세요");
			int money = scanner.nextInt();
			money2 = money;
			if (money >= 1000) {
				System.out.print("입금되었습니다");
				System.out.println("통장 개설이 완료되었습니다");
				System.out.println(name + "님의 계좌번호는:" + accountnum + ",비밀번호는:" + pw + ",잔고는:" + money + "원 입니다");
				f = false;
			} else {
				System.out.println("금액은 0보다 큰 액수로 입력  해 주세요");
			}
		}
		Account a = new Account(accountnum, name, pw, money2);
		accountArray.add(a);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bank b = new Bank();
		boolean run = true;
		b.menuStart(b, run);
	}// end of main

}// end of class
