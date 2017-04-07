// catch절의 멀티 catch
package _14_exception;

public class _4_MultiException {

	public static void main(String[] args) {
	
		try {
			System.out.println(3/0);
			String str =  null;
			str.length();
		} catch (ArithmeticException | NullPointerException e) {
			
			// 여러가지 Exception 내용을 묶어서 catch 절에서 한번에 처리가 가능하다.
			e.printStackTrace();
			// 멀티 catch 할 각각의 exception은 서로 상속관계면 안된다.
		}
		
	}

}
