// 양방향 LinkedList

package _12_CollectionFrameWork;

public class _5_DoubleLinkedList {

	public static void main(String[] args) {
		
		Node m1 = new Node();
		m1.data = 1; 
		Node m2 = new Node();
		m2.data = 2; m2.pre = m1; m1.next = m2; // m1, m2 연결
		Node m3 = new Node();
		m3.data = 3; m3.pre = m2; m2.next = m3;
		Node m4 = new Node();
		m4.data = 4; m4.pre = m3; m3.next = m4;
		
		// 5를 1과 2 사이에 삽입...
		Node m5 = new Node();
		m5.data = 5; m5.pre = m1; m5.next=m2; m1.next = m5;
		m2.pre = m5;
		
		// 3을 삭제
		m2.next = m4; m4.pre = m2;
		
		// 끝과 처음을 연결(Circular Double LinkedList)
		m1.pre = m4;
		m4.next = m1;
		
		Node m = m1;
		Node Um = m4;
		while(m != null){
			System.out.println(m.data);
			m = m.next;
		}
		
		System.out.println("--");
		
		while(Um != null){
			System.out.println(Um.data);
			Um = Um.pre;
		}
	}

} // end of class

class Node {
	Node next; // 다음 데이터객체의 위치
	Node pre; // 이전 데이터 객체의 위치
	int data; // 값 저장
	
}
