/**
 * 		[	JoinHandler  ]
 * 		: 사용자의 회원가입 요청을 처리하는 서비스 클래스이다.
 * 		- GET 방식으로 요청할시 회원가입 view를 보여주도록 회원가입페이지 경로를 return한다.(url상으로 요청시 GET방식으로 호출되니 처음엔 회원가입창으로 들어감)
 * 		- POST 방식으로 요청시 회원가입을 처리하고 회원가입 성공 페이지의 경로를 리턴한다.
 * 			(** 회원가입 폼에서 전송시 action에 JoinHandler의 uri를 입력하고 method=post를 설정하고 전송을 누를시
 * 				이 post 선택했을 때 메서드가 호출됨으로 회원가입을 처리하도록 할 수 있다.)
 * 
 * 		매핑 설정)
 * 			information.properties에 /join.do=Board.joinService.JoinHandler 를 추가한다.
 * 			
 * 			-> 허면, URI 요청시 /join.do 가 command로 인식된 경우, 해당 객체를 수행하게 된다.(컨트롤러에서)
 * 
 */
package joinService;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.CommandHandler;


public class JoinHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		if ( request.getMethod().equalsIgnoreCase("GET") ){ // 해당 페이지를 요청한 방식이 GET이면(일반 /join.do로 요청시 GET 방식으로 요청됨)
			return "/view/joinForm.jsp";
		}else if( request.getMethod().equalsIgnoreCase("POST") ){ // method=post로 설정한 가입화면에서 전송을 눌러 action을 통해 /join.do를 호출시
			// 가입을 처리하는 페이지로 분기
			return processSubmit(request, response);
		} else {
			return null;			
		}
		
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		// form에서 전달되어온 정보들을 JoinRequest에 설정한다.
		JoinRequest joinReq = new JoinRequest();
		joinReq.setId( request.getParameter("id"));
		joinReq.setName(request.getParameter("name"));
		joinReq.setPassword(request.getParameter("password"));
		joinReq.setConfirmPassword(request.getParameter("confirmPassword"));
		
		HashMap<String,Boolean> errors = new HashMap<String,Boolean>();
		joinReq.validate(errors); // 각 항목에 대한 에러 여부가 errors 해시맵 객체에 저장된다.
		// 1. id 비었는지 2. name 비었는지 3. password 비었는지 4. confirmPassword 비었는지 5. password==confirmPassword 인지
		
		request.setAttribute("errors", errors); // jsp view 에서 사용하기 위해 저장해 둠
		
		if ( !errors.isEmpty() ){ // errors 해시맵 객체가 비어있지 않다는건 회원가입 전송시 오류가 있다는 뜻임으로 폼 페이지가 다시 뜨도록 해준다.
			return "/view/joinForm.jsp";
		}
		
		JoinService j = new JoinService(); // 저장작업 처리를 위한 객체 생성
		
		try {
			j.join(joinReq); // DB에 회원 정보를 반영하게 됨.
		} catch (DuplicatedException e) { // join 메서드 수행도중 db에 저장된 중복 id를 발견해 DuplicatedException을 던진 경우
			
			errors.put("duplicated", true); // errors 목록에 duplicated 추가
			return "/view/joinForm.jsp"; // 중복이 발생한 경우니까 다시 폼화면 띄워주기.
		}
		
		// 여기까지 수행했다면 이상없이 db에 저장된 것으로 회원가입 성공 페이지를 리턴하면 됨.
		return "/view/joinSuccess.jsp";
	}
	

}
