//	[	오버라디이딩		] : 부모의 메서드 내용을 다시 정의해서 사용하는 것!

// vs 오버로딩 : 동일한 메서드 명으로 하는 것
package _7_Class;

class Product {
	String name;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name) {
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	public void print() {
		System.out.println("난 부모야");
	}
}

class ProductChild extends Product {
	String name;

	public ProductChild(String name) {
		super();
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print(); // 부모꺼 호출
		System.out.println("난 자식이야");
	}

}

public class _12_Overriding {

	public static void main(String[] args) {
		Product p1 = new Product();
		p1.print();

		ProductChild p2 = new ProductChild(" ");
		p2.print(); // 재정의했기 때문에 재정의한 녀석이 출력됨.
	}

}
