// [ ȸ�� ������ �����ϴ� �ڹ� ���� Ŭ���� ]
package javaBean;

import java.util.Date;

public class MemberInfo {
	private String id;
	private String password;
	private String name;
	private Date registerDate;
	private String email;
	
	// getter/setter�� get set ������ ù���� �빮�� ��Ģ ����������!
	// boolean Ÿ���� isPassword() �̷�������...
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
