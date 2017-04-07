package _4_String;

public class StringBuilderClass1 {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("abc");
		p("버퍼의 크기 : " + sb.capacity());
		p("데이터의 크기" + sb.length());
		String str = "abc";
		str.concat("d");
		System.out.println(str);
		p("이어붙임 : " + sb.append("d"));
		p("sb:"+sb);
		p("sb: " + sb.toString());
		p("역순 : " + sb.reverse());
		
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			sb2.append("a");
			p(sb2.length() + ", " + sb2.capacity() + ", " + sb2.toString());
		}
	}
	public static void p(String s){
		System.out.println(s);
	}
}
