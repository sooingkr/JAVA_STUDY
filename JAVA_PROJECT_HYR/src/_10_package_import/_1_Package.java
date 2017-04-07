/** 
 * 	[	package	] : 소스코드가 저장된 위치를 선언하는 실행문
 * 			- 자바파일의 가장 첫번째 줄에 선언해야 한다.
 * 	
 * 	: 팀 작업시 Class명이 <<중복되는 것을 방지하기 위해>> 분류하는 역할을 한다.
 * 	==> 다른 패키지에 있는 클래스를 이용시 패키지명.클래스명 으로 해주어야 하는데
 * 	==> 이것이 번거로울 경우 해당 패키지를 import해서 패키지명을 생략하고 클래스명만으로도 접근이 가능하다.
 * 
 * 
 * */
package _10_package_import;

import _10_package_import.PackageClassTemp; // 사용할 패키지명.클래스명 을 import 해줌.

// import _10_package_import.*   ==> 패키지명.* 해당 패키지명에 있는 모든 클래스를 추가(비추천)

public class _1_Package {

	public static void main(String[] args) {
		_10_package_import.PackageClassTemp pacObj = new _10_package_import.PackageClassTemp("ttt");
		// 패키지명.클래스명으로 접근할 수 있음.
		// 현재는 동일 패키지 내에 있음으로 바로 클래스명으로 접근할 수 있지만, 
		// 패키지명이 다른 곳에 있는 클래스를 가져올 때 패키지명을 생략하고 싶으면 import 문을 이용한다.
		
		// import하면
		PackageClassTemp pacObj2 = new PackageClassTemp("ddd"); // 패키지명을 생략할 수 있다.
	}

}
