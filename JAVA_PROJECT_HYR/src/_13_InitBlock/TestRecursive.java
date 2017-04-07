/**
 * 		[	재귀함수(Recursive)	 ]
 * 		: 내부에서 자기 자신을 다시 호출하는 메서드 
 * 
 */	
package _13_InitBlock;

public class TestRecursive {

	static int result = 0;
	
	public static void main(String[] args) {
	
		p(0,4);
		System.out.println();
		p2(2,6);
		System.out.println();
		p3(2,11);
		
		System.out.println("팩토리얼 : " + factorial(5));
		////////////////////////////////////////////////////
		
		System.out.println("피보나치");
		fi(9);
		System.out.println("\n");
		///////////////////////////////////////////////////
		int num1 = 1;
		int num2 = 1;
		int sum = 0;
		System.out.print(num1+ " ");
		for (int i = 2; i <= 8; i++) {
			sum = num1 + num2;
			System.out.print(sum + " " );
			num1 = num2;
			num2 = sum;
		}
		
	} // end of main

	
	public static void fi(int index){
        for(int i=1;i<=index;i++){
            System.out.print(function(i) + " ");
        }
    }
    public static int function(int num){
        if(num == 1 || num == 2){
            return 1;
        }else{
            return function(num-2)+function(num-1);
        }
    }


	static int factorial(int n) {

		if (n == 1) return 1;

		else 
			return n * factorial(n - 1);

	}
	static void p(int i, int k) { // 재귀함수
		if ( i >= k) { // 종료파트
			return;
		} else { // 유도파트
			System.out.println(i);
			p(++i,k);
		}
	}
	
	static void p2(int i, int k){
		if ( i>=k+1 ){
			return;
		}else {
			System.out.println(i);
			p2(++i,k);
		}
	}
	
	static void p3(int i, int k) {
		if ( i >= k ){
			
		}else {
			System.out.println(i);
			i = i + 2;
			p3(i,k);
		}
	}
} // end of class
