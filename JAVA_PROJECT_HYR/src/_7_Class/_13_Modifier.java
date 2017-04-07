/** 
 * 	[	제어자(modifiers)	] : "접근제어자" => public, protected, default, private
 * 
 * 	1. final : 
 * 		- 변경될 수 없음을 의미하는 상수 키워드 주로 static final(상수)로 쓰임.
 * 		=> 메서드에 사용시, 오버라이딩 금지되고 클래스에 사용시 해당 클래스를 상속받을 수 없게 됨.
 * 	
 *		---
 *
 * 	1. private : 같은 클래스 내부에서만 접근 가능.
 * 	2. default : 같은 패키지 내부에서만 접근 가능(생략시 default)
 * 	3. protected : 같은 패키지 내부 + 다른 패키지와 자손클래스에서 접근 가능
 * 	4. public : 모든 곳에서 다 접근 가능.
 * 
 * 	제한 정도 : private > default > protected > public	
 * */
package _7_Class;

public class _13_Modifier {
	public int www = 7;

	void x() {
		Modi m = new Modi(); // Modi class가 아무것도 안써있어서
		// default => 같은 패키지 내에서 접근 가능
		// 따라서 같은 패키지에 있음으로 접근이 허용.
	}

}
