package _14_exception;

public class _6_Exception_Throw {

	public static void main(String[] args) throws Exception {
		Exception e = new Exception(); // 예외 생성
		
		// throw e; // Exception 발생시키기
		method1();
		System.out.println("main 끝");
	}
	public static void method1() {
		System.out.println("method1() 시작");
		try {
			method2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("method1() 끝");
	}
	public static void method2() throws Exception{
		System.out.println("method2() 시작");
		Exception e = new Exception(); // 예외 생성
//		try {
//			throw e;
//		} catch (Exception e1) {
//			System.out.println("던진 폭탄 처리");
//		}
		throw e;
		//System.out.println("method2() 끝");
	}

}
