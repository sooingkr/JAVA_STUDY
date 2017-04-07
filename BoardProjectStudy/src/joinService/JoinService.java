/**
 * 		DAO를 이용해
 * 		JoinRequest에 담은 회원가입 정보를 가지고 실재 회원가입을 처리하는 서비스 클래스이다.
 * 
 */
package joinService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import Board.MemberDAO;
import Board.MemberDTO;

public class JoinService {

	MemberDAO dao = MemberDAO.getInstance(); // DB 처리를 위한 객체를 전역변수 선언
	
	// DAO 클래스 이용해서 실재  회원 가입 처리 메서드
	public void join( JoinRequest joinReq ){ // 회원정보를 담은 JoinRequest를 인자로 받는다. 
		
		 // 회원가입 정보를 저장할 DTO
		
		// insert하기 전에 회원가입으로 넘어온 ID가 기존 DB에 저장되어 있는지 확인해야함
		MemberDTO m = dao.findById( joinReq.getId() );
		System.out.println("테스트입니다. : " + m);
		System.out.println(m.getId());
		if ( m.getId() != null ){ // null이 아니면 기존에 db에 회원가입하려는 사람과 동일한 id가 있는 경우임
			Connection c = dao.dbConnect();
			try {
				c.rollback();
			} catch (SQLException e) {}
			
			throw new DuplicatedException(); 
		}
		
		Date now = new Date(); // 회원가입한 시간도 같이 저장하기 위함
		m = new MemberDTO(joinReq.getId(), joinReq.getName(), joinReq.getPassword(), now);
		dao.insert(m); // insert 내부적으로 트랜잭션 처리 되어 있음.
		
	}
}
