/*
 * 		[	싱글톤 패턴	]
 * 		: 전체 pg에서 하나의 객체만 존재해야하는 Manage 클래스 등의 경우 사용 됨.
 * 		객체가 없을 시 생성하지만, 기존 객체가 있으면 객체를 생성하지 않고 기존의 객체를 반환.
 */
package DesignPattern;

class SingleTone {
	private static SingleTone st;

	private SingleTone() { // 생성자를 통한 직접 객체 생성 방지(private)
	};

	public static SingleTone getInstance() { // 기존 객체가 있으면 기존 객체 반환
		// 객체가 없을 시 생성
		// 외부에서 호출가능하도록 static public 선언
		if (st == null) {
			st = new SingleTone();
		}
		return st;
	}
}

public class SingleTonePattern {

	public static void main(String[] args) {
		SingleTone st = SingleTone.getInstance(); // 객체 가져오기
	}

}
