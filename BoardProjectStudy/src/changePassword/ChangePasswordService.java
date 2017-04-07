package changePassword;

import Board.MemberDAO;
import Board.MemberDTO;
import loginService.LoginUser;

public class ChangePasswordService {
	MemberDAO dao = MemberDAO.getInstance();
	public void changePassword(LoginUser user, String curPwd, String newPwd){
		
		MemberDTO member = dao.findById(user.getId());
		if ( !member.matchPassword(curPwd) ){
			// 비밀번호 변경을 위해 현재 비밀번호 입력한게 기존꺼랑 일치하지 않으면 못바꿔야함
			throw new InvalidPasswordException();
		}
		member.changePassword(newPwd);
		dao.update(member);
		
	}
}
