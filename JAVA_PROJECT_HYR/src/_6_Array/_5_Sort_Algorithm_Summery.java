/** 
 * 		[	정렬 알고리즘 정리		]
 * 
 * 		1. 선택정렬 => 가장 단순하게 구현 가능하지만 가장 느림!
 * 		2. count 정렬 => 정렬 방법 중 가장 빠름!!
 * 
 * */
package _6_Array;

import java.util.Arrays;

public class _5_Sort_Algorithm_Summery {

	public static void main(String[] args) {
		
		// => [ *** Count 정렬 방법 *** ]
		
		int[] num = new int[] { 1, 1, 0, 4, 2, 5, 5, 3, 1, 3, 5, 3, 2, 1, 1, 4, 3 };
		int[] temp = new int[num.length];
		int[] count = new int[6]; // 0 ~ 5 까지

		// num배열의 각 값이 인덱스가 됨.
		for (int i = 0; i < num.length; i++) {
			count[num[i]]++;
		}
		// count 배열에 num 데이터의 갯수가 저장되어 있음.

		int k = 0;
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++,k++) {
				temp[k] = i;
			}
		}
		
		System.out.println(Arrays.toString(temp));

	}

}
