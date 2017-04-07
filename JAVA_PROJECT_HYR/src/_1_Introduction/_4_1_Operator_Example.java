package _1_Introduction;

public class _4_1_Operator_Example {

	public static void main(String[] args) {
		
		/*
		 *  삼각형 넓이 = 밑변 * 높이 /2
		 */
		
		int w = 10, h = 5;
		
		double result = (w * h) / 2.0;
		
		System.out.println("삼각형 넓이는 : " + result);
		/////////////////////////////////////////////////////
		
		int numOfApples = 123; // 사과의 개수
		int sizeOfBucket = 10; // 바구니의 크기(바구니에 담을 수 있는 사과)
		
		int numOfBucket = (numOfApples/sizeOfBucket) + ( (numOfApples % sizeOfBucket == 0) ?  0 : 1 );
		System.out.println("필요한 바구니의 수 : " + numOfBucket);
		//////////////////////////////////////////////////////
	
		// 거스름돈
		int coin = 3780;
		int obek = coin / 500;
		coin = coin % 500;
		int bek = coin / 100;
		coin = coin % 100;
		int osip = coin / 50;
		coin = coin % 50;
		int sip = coin / 10;
		
		System.out.println("500원짜리 : " + obek + "개");//7
		System.out.println("100원짜리 : " +  bek + "개");//2
		System.out.println("50원짜리 : " + osip + "개");//1
		System.out.println("10원짜리 : " + sip + "개");//3
		
		
	}

}
