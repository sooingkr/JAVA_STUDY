package Article;

public class Writer {
	private String id; // 작성자 아이디
	private String name; // 작성자 이름
	
	public Writer() {
		// TODO Auto-generated constructor stub
	}
	
	public Writer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
