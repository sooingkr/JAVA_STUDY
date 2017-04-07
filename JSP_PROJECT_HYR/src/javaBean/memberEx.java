// session과 자바빈즈 활용(44번)을 위한 자바빈즈 파일입니다.
package javaBean;

public class memberEx {
	private String id="";
	private String pwd = "";
	private String email = "";
	private String address = "";
	
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
