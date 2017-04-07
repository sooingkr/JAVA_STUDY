/**
0o * 	[	ArrayList ?��?��  ] : 
		[List ?��?��?��?��?��] : 배열 + bound증�? : 중복?��?��, ?��?�� O ( 배열과비?��?���? ?��?��?���? ?�� )
		- ArrayList ?��?��?�� : 배열�? 비슷, ?��?��,?��?��?�� ?�� ?��칸씩 미루거나 ?��칸씩 ?���? ?��?��?��, ?��?��?��?���? 많을?�� 불리
				=> but, ?��차탐?��?���? ?��문에 �??���? ?��?�� 경우?�� ?��?��?�� 매우 좋음.
		- LinkedList ?��?��?�� : 링크�? ?��?��?�� ?��?��,?��?��?�� 매우 ?���?, �??�� ?��?��?? ArrayList보다 ?��?�� ?��?���?.
 * 
 * 	// 메서?���? ?��?��?�� ?��?��
		Collections.sort(ar);
		
 */
package _12_CollectionFrameWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class _1_ArrayList {

	public static void main(String[] args) {
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("d");
		ar.add("a");
		ar.add("c");
		ar.add("z");
		
		for (int i = 0; i < ar.size(); i++) {
			System.out.print(ar.get(i) + ", ");
		}
		System.out.println( ar );
		// ?��?��?��?��
		for (int i = 0; i < ar.size(); i++) {
			int minIndex = i;
			for (int j = i; j < ar.size(); j++) {
				if ( (ar.get(minIndex)).charAt(0) > (ar.get(j)).charAt(0) ){ // 문자?��?��?���? ?��?�� 문자 ASCII�? 비교?���? ?��?��
					minIndex = j;
				}
			}
			String temp = ar.get(minIndex);
			ar.set(minIndex, ar.get(i));
			ar.set(i, temp);
		}
		System.out.println(ar);
		/////////////////////////////
		
		// 정렬을 위해 사용한 Collections 인터페이스의 sort 메서드...
		Collections.sort(ar);
		
		Iterator<String> it = (Iterator<String>)ar.iterator();
		
		while(it.hasNext()){
			System.out.print(it.next() + ", ");
		}
	}

}
