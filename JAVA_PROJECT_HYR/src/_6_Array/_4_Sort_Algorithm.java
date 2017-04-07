// visualgo.net => algorithm 설계 전 참고하기 좋은 사이트

package _6_Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _4_Sort_Algorithm {

	public static void main(String[] args) {
		int num[] = { 3, 8, 5, 9, 1, 7, 2 };
		// int max = Integer.MIN_VALUE;
		// int maxIndex = 0;
		// for(int i=0; i<num.length; i++){
		// if( num[maxIndex] < num[i] ){

		// maxIndex = i;
		// }
		// }
		// System.out.println("최대값은 : " + num[maxIndex]);
		// syso("최대값 방번호 : " + maxIndex);

		// 1. 선택정렬 : 오름차순 정렬
		for (int i = 0; i < num.length; i++) {
			for (int j = i; j < num.length; j++) {
				if (num[i] < num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

		// ******************************************************
		int n[] = { 3, 8, 5, 9, 1, 7, 2 };
		// 최대값이 저장된 index 와 최대값 출력, 최소값도
		int maxIn = 0;
		int minIn = 0;
		for (int i = 0; i < n.length; i++) {

			if (n[maxIn] < n[i]) {
				maxIn = i;
			} else if (n[minIn] > n[i]) {
				minIn = i;
			}

		}
		System.out.println("최대값 : " + maxIn + n[maxIn] + " 최소값 : " + n[n.length - 1]);

		/////////////////////////////////////////////////////////////
		// nu배열에 원소 중 6값이 있는지 검색 있다/없다.
		int nu[] = { 2, 4, 5, 2, 3, 1, 3, 2, 3, 5, 3, 0, 3, 1, 3, 0 };

		for (int i = 0; i < nu.length; i++) {
			if (nu[i] == 6) {
				System.out.println("있다.");
				break;
			}
			if (i == nu.length - 1) { // flag 변수 없이 처리하는 방법. 인덱스 끝까지 for문이 돈다면
										// "없는 경우"
				System.out.println("없다.");
			}
		}
		////////////////////////////////////////////////////////
		// nu 배열에 원소중에서 5값이 몇개 있는지 출력
		// int[] count = new int[]{0,0,0,0,0,0};
		// for(int i=0; i<nu.length; i++){
		// if ( 5 == nu[i] ){
		// count[5]++;
		// }
		// }
		// System.out.println(count[5]);

		// nu 배열에서 가장 많이 사용된 숫자를 출력, 횟수 출력
		int[] cnt = new int[6];
		for (int i = 0; i < nu.length; i++) {
			cnt[nu[i]]++;
		}
		int maxCntIndex = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[maxCntIndex] < cnt[i]) {
				maxCntIndex = i;
			}
		}
		System.out.println("가장 많이 사용된 숫자는 : " + maxCntIndex + " 이고 횟수는 : " + cnt[maxCntIndex] + "입니다.");
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("nu : " + Arrays.toString(nu));
		System.out.println("cnt : " + Arrays.toString(cnt));
		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// *********************************************************************************************************
		// *** [ 카운트 정렬 ] *** : 정렬 알고리즘 중 가장 빠름.
		int[] temp = new int[nu.length];

		int count = 0;
		for (int i = 0; i < cnt.length; i++) {

			for (int j = 0; j < cnt[i]; j++, count++) {
				temp[ count ] = i;
			}
		}
		System.out.println(Arrays.toString(temp));

	}

}
