/** 
 * 		[	배열	  ]
 * 	   : 같은 Type 변수들의 묶음
 * 
 * */
package _6_Array;

public class _1_Array {

	public static void main(String[] args) {
		
		int[] arr; // 배열 변수 선언
		arr = new int[3]; // 변수에 int형 공간3개의 주소 할당.
		
		int[] arr2 = new int[]{1,2,3,4};
		// 생성과 동시에 초기화
		
		String[] arr3 = new String[]{"one","two","three"};
		
		for(int i=0; i<arr.length; i++){ // arr.length => 배열의 길이를 반환.
			System.out.println( arr[i] ); // 배열의 값은 초기화하지 않으면 전역변수처럼 0으로 초기화되어 진다.
			// 이와 다르게, 지역변수는 초기화하지 않고 사용시 쓰레기 값이 들어가 컴파일 오류가 뜬다.
		}
		
		for(int i=0; i<arr3.length; i++){
			System.out.println( arr3[i] );
		}
		
		/////////////////////////////////////////////////////////////////
		int d[][] = new int[4][5];
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				d[i][j] = i * d[i].length + j;
			}
		}
		// 지그재그 순회 방법
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				if( i % 2 == 0){
					System.out.println( d[i][j] + ",");
				} else {
					System.out.println( d[i][ d[i].length -1 -j ] + ",");
				}
			}
		}
	} // end of main

} // end of class
