package _13_InitBlock;

public class TestBook {

	public static void main(String[] args) {
		
		Book b1 = new Book();
		Book b2 = new Book();
		b1.printSN();
		b2.printSN();
		
	} // end of main

} // end of class

class Book {
	private String name = "";
	private int booksn; // 책의 시리얼 넘버
	static int sn = 1000; // 시리얼 넘버를 관리하기 위한 변수
	
	{ // 초기화 블럭 : 각 객체별 시리얼 넘버를 세팅
	// 초기화 블럭에서 이 일을 안해주면, 기본생성자, 오버로딩된 생성자에도 중복으로 들어갔어야 함.
    // 모든 생성자에 넣어줘야 하는 코드면 초기화블럭으로 중복을 줄일 수 있다.
		this.booksn += (sn++);
		
	}
	
	public Book() {
		
	}

	public Book(String name, int booksn) {
		super();
		this.name = name;
		this.booksn = booksn;
	}
	
	public void printSN() { // 시리얼 넘버 출력
		System.out.println("시리얼 넘버 : " + this.booksn);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}