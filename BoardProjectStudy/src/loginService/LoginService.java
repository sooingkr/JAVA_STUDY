package loginService;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Board.MemberDAO;
import Board.MemberDTO;

public class LoginService {
	MemberDAO dao = MemberDAO.getInstance();
	
	public LoginUser login(String id, String password){
		MemberDTO m = dao.findById(id); // DB에 로그인하려는 id가 있는지 확인한다.
		
		if ( m.getId() == null ){ // 로그인하려는 ID가 DB에 없는 경우( 즉, 가입한적이 없는 회원인 경우)
			throw new LoginFailException(); // runtimeException을 던짐 : 이 메서드를 수행하는 loginHandler에서 catch로 잡아 에러시 처리할 것을 지정해 주면 됨.
		}
		
		// 일단 가입된 id가 있다면 여기로 내려와 실행될 것이다.
		if ( !m.matchPassword(password) ){ // pwd가 틀린경우
			throw new LoginFailException();
		}
		
		// id와 pwd가 둘 다 완전하면
		LoginUser u = new LoginUser(m.getId(), m.getName()); // 로그인 성공시 세션에 저장할 인증 객체를 위해 LoginUser 객체에 사용자 정보를 저장한다.
		
		return u;
		
	}
}
