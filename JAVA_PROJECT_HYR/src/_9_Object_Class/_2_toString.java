// Object 클래스의 toString 메소드

// toString 메서드의 경우, 클래스 내부의 필드 변수 값등을 출력하고자 할 때 사용하기 유용하며
// 		==> 특히, 객체명만으로 syso 내에서 출력이 가능하기 때문에 간편하게 이용할 수 있다.
package _9_Object_Class;

class ToStringTempClass {
	String name;

	public ToStringTempClass(String name) {
		this.name = name;
	}

	@Override
	public String toString() { // 필드값 출력을 객체명만으로 하도록 toString메서드를 Object 클래스로부터
								// 오버라이딩 했다.
		// TODO Auto-generated method stub
		return this.name;
	}
}

public class _2_toString {

	public static void main(String[] args) {
		ToStringTempClass t1 = new ToStringTempClass("hhh");
		System.out.println(t1); // t1이라는 객체명만으로 필드 this.name 을 출력한 것을 알 수 있다.
	}

}
