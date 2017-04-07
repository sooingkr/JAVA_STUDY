// Object 클래스의 equals() 메서드와 hashCode() 메서드

/*
 * 	equals() 메서드의 경우 객체가 같은지 비교하는 메서드이다.
 * 		=> 하지만, 문자열의 경우 
 * 			String name = new String("hhh") 와
 * 			String name2 = new String("hhh") 는 객체는 다르지만 문자열은 같다.
 * 			이 경우 문자열의 내용자체를 비교해 주고 싶기 때문에 
 * 
 * 		=> String 클래스 내부에서는 equals 메서드를 오버라이딩(재정의)해서 문자열의 내용자체를 비교하도록 되어 있다.
 * 
 * 		=> 하지만, 우리가 직접 만드는 참조타입의 경우 객체비교가 아닌 내용을 비교하고자 할 때는 equals 메서드를 재정의해주자
 * 
 * 		=> 주의!) equals 메서드를 호출할 때는 hashCode() 메서드도 같이 정의해 주도록 하자!
 * 
 * 		=> hashCode 메서드는 equals 메서드를 수행하기 전, 비슷한 녀석들끼리 그룹핑해서 같은 그룹으로 된 녀석들 내부에서만
 * 
 * 		=> 일치하는지 여부 등을 판별하도록 해서 효율을 높여주는 역할을 한다.
 * 
 * 		ex) 1,2,3,4,5,6,7,8 의 데이터가 있을 때 hashCode의 return에 데이터%2 로 해놓으면(특정 알고리즘)
 * 			2로 나누었을 때 나머지가 같은 것들끼리 그룹핑이 된다.
 * 
 */
package _9_Object_Class;

class EqualsClass {
	String name;

	public EqualsClass(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result;
		if (this.name.equals(((EqualsClass) obj).name)) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.name.length();
		// equals가 돌아가기 전 그룹핑을 위해 name의 길이가 같은 녀석들끼리 그룹핑될 수 있도록
		// return에 name.length() 를 적용시켰다.
		// hashCode가 선언되지 않으면 전체에서 뒤적거리게 됨으로 더 효율이 안좋음을 알아야 한다.
	}
}

public class _3_Equals_And_HashCode {

	public static void main(String[] args) {
		String name = new String("황영롱");
		String name2 = new String("황영롱");
		System.out.println(name == name2); // flase

		System.out.println(name.equals(name2)); // true

		EqualsClass e1 = new EqualsClass("aaa");
		EqualsClass e2 = new EqualsClass("aaa");
		// e1과 e2는 같은 문자열을 가지고 있지만 다른 객체이다. 본래 equals를 재정의하지 않았다면
		// flase가 나왔겠지만 EqualsClass 내부에 재정의해 두었다. 결과를 보자.
		System.out.println(e1.equals(e2)); // 내부 내용만 비교해 true가 나옴을 알 수 있다.

	}

}
