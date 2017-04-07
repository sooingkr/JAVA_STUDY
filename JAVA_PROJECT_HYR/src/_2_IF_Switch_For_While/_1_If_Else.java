/** 
 * 		[	 자바의 흐름 제어		]
 * 
 * 		: 삼항 연산자, if ~ else, switch ~ case
 * 
 * */
package _2_IF_Switch_For_While;

public class _1_If_Else {

	public static void main(String[] args) {
		
		int num = 8;
		
		if( num > 30 ) { // true or false
			
			System.out.println("num 은 30보다 크다");
		
		} else if(num < 30){
			
			System.out.println("num 은 30보다 작다.");
			
		} else {
			
			System.out.println("num은 30이다.");
			
		}
		
		num = 78;
		// 100이하~90이상 수, 90미만~80이상 우, 80미만~70이상 미, 70미만~60이상 양,
		// 나머지 가
		
		
		
		if(num <= 100 && num >= 90) {
			System.out.println("수");
		}else if(num <= 90 && num >= 80){
			System.out.println("우");
		}else if(num <= 80 && num >= 70)
		{
			System.out.println("미");
		}else if(num <= 70 && num >= 60){
			System.out.println("양");
		}else{
			System.out.println("가");
		}

		num /= 10;
		if(num==10 || num==9){
			System.out.println("수");
		}else if(num == 8){
			System.out.println("미");
		}
		
		num = 7;
		if( num % 2 == 0){
			System.out.println(num + "은 짝수입니다.");
		}else{
			System.out.println(num + "은 홀수입니다.");	
		}
		
		num = -3 ;
		if( num < 0 ){
			System.out.println(num + "은 음수입니다.");
		}else if( num > 0 ){
			System.out.println(num + "은 양수입니다.");
		}else{
			System.out.println(num + "은 0입니다.");
		}
	} // end of main

} // end of class
