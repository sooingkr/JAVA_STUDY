/**
 * 		[	hashSet	  ]
 * 		: 은 중복을 배제한 집합과같은 데이터를 저장하는데
 * 		중복된 데이터를 배제하기 위해서 내부적으로
 * 		1. 검색 효율을 위해 hashCode()를 호출한 뒤
 * 		2. equals를 호출해 동일 데이터를 배제한다.
 * 		하지만, equals는 Object에선 객체가 같은지 비교하기 때문에 오버라이딩해서 내용물을 비교할 수 있도록 해주어야하며
 * 		hashCode 또한 오버라이딩하지 않으면 Object껄 호출하기 때문에 모든 객체가 전부 다른 주소값처럼 나오게 되어
 * 		중복을 배제할 수 없다.
 * 
 * 		따라서, HashSet을 사용할 때는 중복 배제를 위해 반드시 equals와 hashCode 모두를 오버라이딩하자.( 기본형 타입은 이거 오버라이딩안해도 중복 배제되어 저장됨...)
 */
package _12_CollectionFrameWork;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class _1_HashSet {

	public static void main(String[] args) {
		HashSet<testClass> hs = new HashSet<testClass>();
		hs.add(new testClass("hyr"));
		hs.add(new testClass("hyr"));
		hs.add(new testClass("ddd"));
		hs.add(new testClass("aaa"));
		hs.add(new testClass("fff"));
		hs.add(new testClass("bbb"));
		
		Iterator<testClass> it = hs.iterator();
		while(it.hasNext()){
			System.out.println(it.next() + " ");
		}
		// 중복이 배제된 것을 알 수 있다.
		
		// Collections의 sort 메서드로 정렬하고싶은데 List 계열만 가능
		// 따라서, Set을 List로 변환해서 넣어야 함
		LinkedList  ll =  new LinkedList(hs); // LinkedList 계열로 변환...
		
		System.out.println();
		Collections.sort(ll); // comparable 구현...
		it = ll.iterator();
		while(it.hasNext()){
			System.out.println(it.next() + " ");
		}
		
	}

}

class testClass implements Comparable{
	String name ="";
	public testClass(String name) {
		this.name = name;
		// TODO Auto-generated constructor stub
	}
	public testClass() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.name.compareTo( ((testClass)o).name);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return this.name.equals( ((testClass)obj).name );
	}
	@Override
	public int hashCode() {
		
		return this.name.hashCode();
		// String은 내부적으로 해시코드를 오버라이딩하고 있어서 String껄 그대로 사용하는게 효율이 좋다.
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}