package _8_API;

public class _3_String_Class_Ex {

	public static void main(String[] args) {
		String str = new String("HelloWorld");

		System.out.println("문자열 길이 : " + str.length());
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
		StringBuilder str2 = new StringBuilder("HelloWorld");
		str2.reverse();
		System.out.println(str2);

		System.out.println("일부 값 출력 : " + str.substring(4, 9));
		System.out.println("일부 값 변경 : " + str.replace("ll", "LL"));
		System.out.println("대문자 : " + str.toUpperCase());
		System.out.println("소문자 : " + str.toLowerCase());

	}

}
