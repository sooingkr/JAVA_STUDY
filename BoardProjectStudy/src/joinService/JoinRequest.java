/**
 * 		JoinHandler : 전체 회원가입을 처리한다.(흐름 제어)
 * 		- JoinRequest : 폼으로부터 입력해 전송한 회원가입 데이터들을 저장하는 클래스이다.
 * 		- JoinService : JoinRequest에 저장한 데이터들을 이용해 회원가입을 처리한다.
 * 
 */
package joinService;

import java.util.HashMap;

public class JoinRequest {
	private String id;
	private String name;
	private String password;
	private String confirmPassword; // 비번 확인
	
	// 비밀번호와 비밀번호 확인이 맞는지 확인하는 메서드
	public boolean isPasswordEqualToConfirm(){
		return ( password != null && password.equals(confirmPassword) );
	}
	
	// validate를 체크하는 메서드
	// 체크한 validation 중 발생한 에러들을 HashMap에 error가 발생한 부분과 boolean true로 넣을 것
	// 각 항목이 비었는지, 비번과 확인비번이 같은지를 체크해 error 객체에 넣어 둔다.
	public void validate(HashMap<String,Boolean> errors) {
		// 빈 문자열인지 Check : 빈문자열이면 해당 필드명과 true 값을 errors 해시맵에 저장함.
		if ( id == null || id.equals("") ){
			errors.put("id", true);
		}
		if ( name == null || name.equals("") ){
			errors.put("name",true);
		}
		if ( password == null || password.equals("") ){
			errors.put("password",true);
		}
		if ( confirmPassword == null || confirmPassword.equals("") ){
			errors.put("confirmPassword",true);
		}
		
		// 비밀번호와 비밀번호 확인이 일치하는지 판단하는 로직
		if ( !errors.containsKey("confirmPassword") ){ // errors 해시맵에 확인비밀번호가 false이면( 즉 빈 문자열이 아니면)
			if ( !isPasswordEqualToConfirm() ){ // 비밀번호와 확인번호가 같지 않으면
				errors.put("noMatchPWD", true); // noMatchPWD란 key로 true 값을 넣음
				// 이후에 이 에러객체에 에러가 발생시 로그인 폼을 계속 보여줄 수 있도록 할 것임.
			}
		}
	}
	
	// getter/setter
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
}
