package cookiepackage;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieHandling { // 쿠키 관련 처리를 도와줄 보조 클래스

	private HashMap<String, Cookie> cookieMap = new HashMap<String, Cookie>();

	// CookieHandling 객체 생성시 기존에 가지고 있던 쿠키 데이터 가져와 내부에 저장하기(hashMap에...)
	public CookieHandling(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]); // 쿠키 이름에 대응해
																	// 쿠키 자체를 담을
																	// 수 있도록 함
			}
		}
	}

	// 해당하는 쿠키 반환하는 메서드
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}

	// 해당하는 쿠키 값 가져오는 메서드
	public String getValue(String name) {
		if (cookieMap.get(name) != null) {

			return URLDecoder.decode(cookieMap.get(name).getValue());
		} else {
			return null;
		}
	}

	// 해당하는 쿠키가 존재하는지 판단하는 메서드
	public boolean exits(String name) {
		if (cookieMap.get(name) != null) {
			return true;
		} else {
			return false;
		}
	}

	// 새로 쿠키를 생성하는 메서드(생성 밑 설정)
	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge)
			throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "UTF8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);

		return cookie;
		// cookie 반환하면 이거 호출하는 쪽에서 response.addCookie(cookie) 해줘야하는거 잊지말길...
	}

	// 새로 쿠키를 생성하는 메서드(생성 밑 설정)
	public static Cookie createCookie(String name, String value, String path, int maxAge)
			throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "UTF8"));

		cookie.setPath(path);
		cookie.setMaxAge(maxAge);

		return cookie;
		// cookie 반환하면 이거 호출하는 쪽에서 response.addCookie(cookie) 해줘야하는거 잊지말길...
	}

	// 새로 쿠키를 생성하는 메서드(생성 밑 설정)
	public static Cookie createCookie(String name, String value) throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "UTF8"));

		return cookie;
		// cookie 반환하면 이거 호출하는 쪽에서 response.addCookie(cookie) 해줘야하는거 잊지말길...
	}
}
