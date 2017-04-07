package _10_Interface;
public class TestProduct {
	public static void main(String[] args) {

		 Television t = new  Television("삼성","tv",1000000,40);
		 t.displayProductInfo();
		 Computer c = new Computer("엘지","컴터",500000,5,5);
		 c.displayProductInfo();
		 
	}// end of main
}// end of class
interface ProductInfo{
	public abstract void displayProductInfo();	
}

abstract class Product implements ProductInfo{
	String company="";
	String name="";
	int price;
	public Product() {
	}
	public Product(String company, String name, int price) {
		super();
		this.company = company;
		this.name = name;
		this.price = price;
	}
}

class Television extends Product{
	int inchSize;
	public Television() {
	}
	public Television(String company, String name, int price,int inchSize) {
		super();
		this.company = company;
		this.name = name;
		this.price = price;
		this.inchSize = inchSize;
	}
	public void displayProductInfo(){
		System.out.println(company+","+name+","+price+","+inchSize);
	}
}

class Computer extends Product{
	int hddSize;
	int memorySize;
	public Computer() {
	}
	public Computer(String company, String name, int price,int hddSize, int memorySize) {
		super();
		this.company = company;
		this.name = name;
		this.price = price;
		this.hddSize = hddSize;
		this.memorySize = memorySize;
	}
	public void displayProductInfo(){
		System.out.println(company+","+name+","+price+","+hddSize+","+memorySize);
	}
}
