package _4_String;

import java.util.Arrays;
import java.util.StringTokenizer;

public class _2_String_Ex {

	public static void main(String[] args) {
		String s = "abc1/abc2/호랑이/123/감자/아빠";
		String[] ss = s.split("/");
		
		for (int i = 0; i < ss.length; i++) {
			System.out.print(ss[i] + " ");
		}
		
		String str = "abc1,abc2&호랑이/123,감자&아빠";
		String[] str2 = str.split("[,&/]"); // 정규화 표현식 이용
		// , 또는 & 또는 / 것
		System.out.println( Arrays.toString(str2) );
		
		str = "abc1/abc2/호랑이/123/감자/아빠";
		StringTokenizer st = new StringTokenizer(str, "/");
		while(st.hasMoreTokens()){
			System.out.print(st.nextToken() + " ");
		}
	}

}
