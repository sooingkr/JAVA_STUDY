// [ 회원 정보를 저장하는 자바 빈즈 클래스 ]
package javaBean;

import java.util.Date;

public class MemberInfo {
	private String id;
	private String password;
	private String name;
	private Date registerDate;
	private String email;
	
	// getter/setter는 get set 다음에 첫글자 대문자 규칙 지켜져야함!
	// boolean 타입은 isPassword() 이런식으로...
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public String getEmail() {
		return email;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
