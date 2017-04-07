/**
 * 		[	List 인터페이스 계열 	]
 * 		- Vector(동기) but 구형 
 * 		- ArrayList(비동기) : 검색에 유리, 잦은 삽입 삭제에는 효율이 좋지 못함
 * 		- LinkedList : 삽입, 삭제에 유리 => Doubly Circular LinkedList로 구현되어 있음
 * 
 * 
 */
package _12_CollectionFrameWork;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class _6_LinkedList {

	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		ll.add("hi");
		ll.add(3);
		ll.add(3);
		ll.add(7);
		p("크기 : " + ll.size());
		p("출력 : " + ll.toString());
		p("포함여부 : " + ll.contains(3.14)); // true
		p("인덱스 위치 : " + ll.indexOf(3)); // 1
		p("인덱스 위치2 : " + ll.lastIndexOf(3)); // 2
		
		ll.add(0, "insert");
		System.out.println(ll.toString()); // [insert, hi, 3, 3.14, 7]
		ll.addLast("last insert");
		System.out.println(ll.toString()); // [insert, hi, 3, 3.14, 7, last insert]
		ll.set(1, "hi modify");
		System.out.println( ll );
		ll.remove(ll.size()-1);
		System.out.println(ll.toString());
		
		ll.isEmpty(); // 비어있는지 여부
		Object q[] = ll.toArray(); // 내부 내용을 배열로 반환...
		System.out.println(Arrays.toString(q));
		
		// Enumeration(구버전) == Iterator(신버전) : list, set 계열에서 사용 가능... but Map에서도 keySet을 가져와 사용할 수 있음...
		// ListIterator는 양방향성 Iterator는 단방향성
		ListIterator li = ll.listIterator();
		Iterator it = ll.iterator();
		Iterator desit = ll.descendingIterator(); // 역순...(TreeSet 등은 정렬된 데이터를 역순으로 꺼낼 수 있게 됨... 이걸로 Iterator 가져오면)
		// Iterator는 해당 객체에서 데이터를 새로 꺼내 담고 있는 개념으로 next로 꺼내면서 다음 데이터를 가리키도록 됨 따라서 내부에서 변수에 저장하고 또 출력시
		// 두 번에 데이터가 넘어가기 때문에 주의해야 함..
		while(desit.hasNext()){
			System.out.print(desit.next() + " " );
		}
		System.out.println();
		System.out.println(li.next());
		System.out.println(li.previous());
		
		
	} // end of main

	public static void p(String str){
		System.out.println(str);
	}
} // end of class
