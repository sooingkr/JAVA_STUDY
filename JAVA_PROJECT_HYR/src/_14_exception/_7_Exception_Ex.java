/**
 * 		[	예외처리 활용	]
 * 
 */
package _14_exception;

public class _7_Exception_Ex {

	public static void main(String[] args) {
		System.out.println( sum(7,3) );
		System.out.println( sub(7,3) );
		
		System.out.println( mul(7,2) );
		
		try {
			System.out.println( div(7,0) );
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누면 안되요");
			
		}
	} // end of main

	private static int div(int i, int j) throws ArithmeticException {

			return (i / j);
		
	}

	private static int mul(int i, int j) {
		// TODO Auto-generated method stub
		return (i*j);
	}

	private static int sub(int i, int j) {
		// TODO Auto-generated method stub
		return (i-j);
	}

	public static int sum(int a, int b){
		return (a + b);
	}
} // end of class
