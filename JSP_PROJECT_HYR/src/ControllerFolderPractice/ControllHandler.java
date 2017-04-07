package ControllerFolderPractice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllHandler {
	// 커맨드 객체를 위해 포괄적으로 관리할 수 있는 ControllHandler
	// 각 명령어에 따라 처리를 위해 수행할 메서드
	public String process(HttpServletRequest request, HttpServletResponse response);
}
