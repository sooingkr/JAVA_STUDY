package ControllerFolderPractice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullPointHandler implements ControllHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("null Point Exception 처리 페이지입니다.");
		return null;
	}

	
}
