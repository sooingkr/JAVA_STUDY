/** 
 * 	[	String	vs		StrinvBuilder	]
 * 
 * 		: String 클래스는 문자열에 + 해줄 때마다 메모리가 계속 새로 잡히는 것이다.
 * 		=> 하지만, 최근에는 내부 버퍼에서 한번에 처리해 데이터가 누적될 수 있는 StringBuilder로 구현되어서
 * 		=> 메모리 낭비를 줄였다. 하지만 StringBuilder로 되기 전 메모리 낭비를 줄이기 위해서 
 * 		=> 동일한 문자열을 가리킬 경우 같은 곳을 가리키도록 되어 있다.
 * 
 * 		String str1 = "hhh"
 * 		String str2 = "hhh" 
 * 		=> 이때, str1과 str2는 같은 hhh객체를 가리키기 때문에 str1 == str2 은 true가 된다.
 * 
 * 		하지만,
 * 		
 * 		String str1 = new String("hhh")
 * 		String str2 = new String("hhh")
 * 		의 경우, str1 == str2 는 false가 된다. 두 객체는 서로 다르기 때문이다.
 * 
 * 		어쨋든, String은 문자열을 조작시 기존 메모리 공간에 있는 데이터를 바꾸는게 아니라 새로 데이터를 바꾸기 때문에 다음과 같은 특징이 있다.
 * 
 * 		String str = "abc"
 * 		str.charAt(0) 을 했을 때, str의 값이 a로 들어가지 않는다. why? 새로 메모리가 잡히기 때문에 기존에 str이 가리키던 곳의 데이터는 변하지 않음.
 * 		str = str.charAt(0) 따라서 이렇게 해주어야 한다.
 * 
 * 		하지만, StringBuilder의 경우 내부 버퍼에서 수정작업을 한 뒤 다시 반영하기 때문에 값이 반영이 된다는 차이가있다.
 * 		StringBuilder str = "abc"
 * 		str.charAt(0)을 하면 str은 a를 가리키고 있게 된다.
 * 
 * 		
 * 		[	String 클래스는 문자열을 처리하는 다양한 메서드들을 가지고 있다.  ] : API를 참조
 * 		
 * */
package _8_API;

import java.util.Arrays;

public class _1_String_Class {
	public static void p(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		String str = "abcDEFghij";

		p("해당 index의 문자 : " + str.charAt(0));
		p("문자열의 길이 : " + str.length());
		p("시작은 포함 끝은 포함 X : " + str.substring(0, 3)); // abc
		p("문자열추출2 : " + str.substring(7)); // hij
		p("문자열 연결 : " + str.concat("xyz"));
		p("대문자로 전환 : " + str.toUpperCase());
		p("소문자로 전환 : " + str.toLowerCase());
		p("문자열 포함 여부 : " + str.contains("Fgh"));
		p("문자열 시작위치 : " + str.indexOf("EF")); // 4
		p("문자열 교체 : " + str.replace("DEF", "XYZ"));
		p("내용물 비교 : " + str.equals("abcdefghij")); // false
		p("대소문자는 무시하고 내용물 비교 : " + str.equalsIgnoreCase("abcdefghij"));

		String s = " /고양이/강아지/곰/호랑이/사자";
		
		String[] ss = s.split("/");
		System.out.println(Arrays.toString(ss));
	
	}

}
