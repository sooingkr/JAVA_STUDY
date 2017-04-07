package willStudyContent;

public class VendingMechine_class3 {

	public static void main(String[] args) {
		
		
		
		Product p1 = new Product();
		p1.item = "콜라"; p1.price = 910;
		Product p2 = new Product();
		p2.item = "사이다"; p2.price = 870;
		Product p3 = new Product();
		p3.item = "환타"; p3.price = 690;
	
		Product[] product = {p1, p2, p3};

		for (int i = 0; i < product.length; i++) {
			System.out.println(product[i].item + "," + product[i].price);
		}
	}

}

class Product { // 제품 정보를 담고 있는 클래스
	String item = "";
	int price;
	
}
