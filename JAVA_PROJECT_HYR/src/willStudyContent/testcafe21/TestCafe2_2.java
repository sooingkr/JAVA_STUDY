package willStudyContent.testcafe21;

import java.util.Scanner;

/**
 * 메뉴 각항목을 Item 클래스로 정의하여 배열로 작성
 */
public class TestCafe2_2 {
	public static Item item[] = {
			new Item("아메리카노", new Item[]{
					new Item("Hot", 2000),
					new Item("Cold", 2500),
			}),
			new Item("에스프레소", 2400),
			new Item("라떼", new Item[]{
					new Item("땅콩라떼", 5000),
					new Item("돌체라떼", 5200),
					new Item("카페라떼", 4900),
			}),
			new Item("모카", new Item[]{
					new Item("카페모카", 3700),
					new Item("초콜렛모카", 3800),
					new Item("아이스모카", 3900),
					new Item("화이트모카", 4000),
			}),
			new Item("카푸치노", 5500),
			new Item("과일음료", new Item[]{
					new Item("오렌지주스", 8000),
					new Item("바나나주스", 5000),
					new Item("청포도주스", 5000),
			})
	};
	public static void printMenu() { // 전체 메뉴 출력
		System.out.println("<메뉴표>");
		for (int i = 0; i < item.length; i++) {
			item[i].printItem(); // 각 메뉴의 내용을 출력
		}
	}
	public static int select(Item item[]) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("[고를항목]");
			for (int i = 0; i < item.length; i++) {
				System.out.println(item[i].name);
			}
			String input = scan.nextLine(); // 입력받기
			for (int i = 0; i < item.length; i++) {
				if (item[i].name.equals(input)) { // 찾음
					return i; // 찾은 목록의 index
				}
			}
			System.out.println("다시입력하세요");// 못찾은 경우
		}
	}
	public static void main(String[] args) {
		printMenu(); // 전체 메뉴 출력
		int sel1 = select(item);
		if (item[sel1].subItem == null) { // 세부항목 없음
			item[sel1].printItem();
		} else { // 세부항목이 있는 경우
			int sel2 = select(item[sel1].subItem);
			System.out.println(item[sel1].name);
			item[sel1].subItem[sel2].printItem();
		}
	} // end of main
} // end of class

class Item {
	String name = "";
	int price;
	Item subItem[]; // 서브메뉴
	
	public Item() {
	}
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public Item(String name, Item subItem[]) {
		this.name = name;
		this.subItem = subItem;
	}
	
	public void printItem() { // 각 메뉴의 내용을 출력
		if(subItem == null) {
			System.out.println(name+":"+price+"원");
		} else { // 서브메뉴가 있는 경우
			System.out.print(name);
			for (int i = 0; i < subItem.length; i++) {
				System.out.print("\t");
				subItem[i].printItem(); // 재귀
			}
		}
	}
} // end of class Item














