// 한줄주석
/* 부분 주석 */
/** 다큐먼트 주석 : 부분 주석과 사용방법은 동일 
  		=> 사용법 등을 기술해 놓으면 나중에 자동으로 이 주석부분은 문서파일로 만들어 줌.(관리의 용이)
  		
  		클래스, 메서드, 변수 선언부 앞에 주석으로 작성한다.
  		개발자, 개발일, 기능, 입력/출력 값, 해당 버그 이슈 등의 history를 기록.
  		
 */

/*
 * 	[Java 의 특성]

1. 운영체제에 독립적( Write Once, run anywhere )
	: JVM위에서 동작해서 JAVA->바이트코드(JVM에서 실행가능 코드)로 변환해서 JVM이 
	  이것을 컴파일해서 특정 OS에 맞게끔 변환해 수행하기 때문에 코드를 OS에 종속적이게 할 필요가 없다.
	  JVM은 특정 OS에 종속적이라 OS에 맞는 JVM을 설치해야 하지만 프로그램을 작성은 OS와 독립적이다.

2. 객체지향 언어
	: 상속, 캡슐화, 다양성

3. 자동 메모리 관리
	: 가비지컬렉션을 제공

4. 분산처리 지원
	: 네트워크 관련 API 제공

5. 멀티 쓰레드 지원
	: 시스템 지원여부와 무관

6. 동적 로딩 지원.
	: 실행시 필요한 클래스만 로딩

JDK = JRE(=JVM+Java API) + 개발도구




jdk폴더안에 src zip파일 => API 소스들이 들어 있음.

			=> bin폴더 : javac(컴파일), java(실행), javadoc(주석)

==> 어느곳에서나 javac등의 응용pg을 수행할 수 있도록 Path 환경변수를 등록해 주어야 함.

;%JAVA_HOME%\bin

//JAVA_HOME : 자바 설치 jdk 경로


 * 
 */




package _1_Introduction;

public class _1_Java_summery {

	public static void main(String[] args) {
		
		System.out.println(Math.pow(4,2));

	}

}
