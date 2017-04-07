/**
 * 		로그인 요청한 사용자의 정보를 저장해 로그인되어 있는지 세션에 저장할 클래스.
 */
package loginService;

public class LoginUser {
	private String id;
	private String name;
	
	
	
	public LoginUser(String id, String name) {
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
