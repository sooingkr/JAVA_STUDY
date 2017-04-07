/** 
 * 		[	Math Class	] : Math 클래스의 모든 메서드들은 static 선언되어 있기 때문에
 * 			=> Math.메서드() 로 접근이 가능하다.
 * */
package _8_API;

public class _1_Math_Class {

	public static void main(String[] args) {
		
		Math.abs(-3);
		Math.max(3, 7);
		Math.min(3, 7);
		int num = (int)( Math.random() * 10 ) + 1; // 1 ~ 10;
		double PI = Math.PI;
		
	}

}
