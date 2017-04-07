package cookiepackage;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookiePractice {
	ArrayList<Cookie> al = new ArrayList<Cookie>(); // 쿠키들을 저장할 객체

	public CookiePractice(HttpServletRequest request) { // 이 핸들링 객체 생성시 기존의 쿠키
														// 정보를 전부 ArrayList에
														// 저장하자.

		// 기존에 존재하는 쿠키들 정보 객체 생성시 저장하기...
		Cookie[] cookies = request.getCookies();
		if (cookies != null || cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				al.add(cookies[i]);
			}
		}

	}

	public boolean exist(String name) {
	
		for(int i=0; i<al.size(); i++){
			if ( al.get(i).getName().equals(name)){
				return true;
			}
		}
		return false;
	
	}

	public Cookie getCookie(String name) { // 저장해 논 쿠키 ArrayList를 반환
		Cookie cookie = null;
		if (al != null) {
			for (int i = 0; i < al.size(); i++) {
				if (al.get(i).getName().equals(name)) {
					return al.get(i);
				}
				if (i == al.size() - 1) {
					System.out.println("찾는 값이 없습니다...");
				}
			}
		}
		return cookie;
	}

	public void createCookie() {

	}

	public Cookie createCookie(String name, String content, String path, int maxAge) {
		Cookie cookie = new Cookie(name, content);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);
		return cookie;
	}

}
