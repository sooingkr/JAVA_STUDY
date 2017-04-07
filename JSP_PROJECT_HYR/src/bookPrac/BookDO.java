package bookPrac;

public class BookDO {
	private int id;
	private String title;
	private String author;
	private int price;
	private int qty;
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public int getQty() {
		return qty;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	
}
