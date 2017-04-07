/**
 * 	[	출력 포맷	]
 * 
 */
package _11_PrintFormat;

public class _1_Print_Format {

	public static void main(String[] args) {
		
		System.out.printf("%.3f\n", 3.141592);
		System.out.printf("%7.3f\n", 3.141592);
		System.out.printf("%3c\n", 'x');
		
		System.out.println("[홍길동]");
		String name = "길동";
		System.out.printf("[%-5s]\n", name);
		System.out.println("-------------------------");
		
		System.out.printf("%010d\n",123456789);
		System.out.printf("%8.2f\n", 123.14);
		System.out.printf("%6s\n","apple");
		System.err.println("err표시");
	}

}
