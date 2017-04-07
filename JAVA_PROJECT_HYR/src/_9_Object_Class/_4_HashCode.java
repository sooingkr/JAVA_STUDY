/**
 * 		[	hashCode	]
 * 	: 검색효율을 높이기 위해 알고리즘을 적용해 동일한 값이 나오는
 * 		녀석들을 링크드리스트로 연결해 같은 해시값을 갖는 집합끼리 분류한 후
 * 		equals 등에서 해시값이 같은 곳에서만 비교를하면 효율을 높일 수있음.
 * 
 *			HashSet에서 1. HashCode 값이 같은 녀석들 중에 => 2. equals로 중복데이터가 있는지를 확인함
 *				=> 효율을 높이기 위해서... 	
 * */
package _9_Object_Class;

public class _4_HashCode {

	public static void main(String[] args) {

		Student s1 = new Student(1200, "황영롱", 100, 99);
		Student s2 = new Student(1201, "황영롱", 90, 95);
		Student s3 = new Student(1201, "황영롱", 90, 95);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode()); // 객체의 주소로 해시코드값을 생성(default In
											// Object)

		// 1. 내용물이 같은 객체는 hashCode 값은 동일해야 한다.
		// - Object 클래스의 hashCode() 는 객체의 주소로 hashCode를 생성하기 때문에 객체마다 값이 다르다.
		//
		// - String 클래스의 hashCode() 는 문자열의 내용으로 hashCode 를 생성
		// 문자열의 내용이 같으면 다른 객체라도 동일한 hashCode 값을 리턴한다.
		//
		// 2. 같은 객체를 넣으면 동일한 hashCode 값이 리턴되어야 한다.
		//
		// 3. 다른 내용물이 들어있는 객체라면 hashCode 값이 꼭 다를 필요는 없지만
		// hashCode 값이 다르면 성능이 좋아진다.

	} // end of main

} // end of class

class Student {
	int num; // 학번
	String name = "";
	int kor;
	int eng;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int num, String name, int kor, int eng) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}

	@Override
	public int hashCode() { // String 클래스의 hashCode() 를 활용해 보자.(문자열내용을 계산해 해시코드값나옴)
		// 동일한 문자열은 동일한 값, 다른 문자열은 다른 값이 나옴.
		// TODO Auto-generated method stub
		String result = num + name + kor + eng;
		return result.hashCode();
	}
}