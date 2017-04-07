package _12_CollectionFrameWork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * List 구현클래스 LinkedList
 * 	ArrayList, Vector 의 비순차적 추가 삽입 기능을 개선한 클래스
 * 	데이터저장공간, 다음데이터가 저장된 위치를 가리키는 변수
 */
public class _4_LinkedList {
	public static void main(String[] args) {
		MyLL1 m1 = new MyLL1();
		m1.data = 1;
		MyLL1 m2 = new MyLL1();
		m2.data = 2; m1.next = m2;
		MyLL1 m3 = new MyLL1();
		m3.data = 3; m2.next = m3;
		MyLL1 m4 = new MyLL1();
		m4.data = 4; m3.next = m4;
		
		m2.next = m4; //삭제
		
		// 삽입작업...
		MyLL1 m9 = new MyLL1();
		m9.data = 9; m1.next = m9; m9.next = m2;
		// m1 참조변수부터 사용해서 1,2,3,4 데이터를 순차적으로 출력
		/*System.out.println(m1.data);
		System.out.println(m1.next.data);
		System.out.println(m1.next.next.data);
		System.out.println(m1.next.next.next.data);
		*/
		MyLL1 m = m1;
		while(m != null){
			System.out.println(m.data);
			m = m.next;
		}
		
		
		
	} // end of main
} // end of class
class MyLL1 {
	MyLL1 next; // 다음 데이터객체의 위치
	int data; // 값저장
}