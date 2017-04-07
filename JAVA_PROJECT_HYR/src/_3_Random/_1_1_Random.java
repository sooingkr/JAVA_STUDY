/** 
 * 		[		Random을 지원하는 2가지 방법		]
 * 
 * 		1. Math.random()	
 * 		2. java.util 패키지의 Random rand = new Random()
 * 
 * */
package _3_Random;

import java.util.Random;

public class _1_1_Random {

	public static void main(String[] args) {
		
		// 1. Math.random()
				//		0.0 <= Math.random() <= 1.0
		int num = (int)( Math.random() * 10 ) + 1; // 1 ~ 10까지의 수 출력
		
		System.out.println("1 ~ 10 까지의 random 값 : " + num);
		
		System.out.println("1 ~ 6 까지의 random 값 : " + ( (int)( Math.random() * 6) + 1 ) );
		
		// 2. Random Class
		
		Random rand = new Random(12);
		
		rand.setSeed(System.currentTimeMillis()); // seed 설정

		num = rand.nextInt(10) + 1; // 1~ 10 까지 랜덤 값
	}

}
