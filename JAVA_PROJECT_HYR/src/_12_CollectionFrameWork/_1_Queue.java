/**
 * 		[	Queue	]
 * 		: Queue 인터페이스를 구현한 LinkedList 를 객체로 생성하여 확인할 수 있다.
 * 			
 * 			특징)
 * 					FIFO(First In First Out)
 * 
 * 			Front(머리) -------------------- Liear(꼬리)
 * 							---------------------
 * 
 */
package _12_CollectionFrameWork;

import java.util.LinkedList;
import java.util.Queue;

public class _1_Queue {

	public static void main(String[] args) {
		Queue q = new LinkedList<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		// 큐에 데이터 저장, boolean 타입의 리턴, 저장성공시 true 실패시 false
		
		System.out.println("들여다보기 : " + q.peek()); // front 데이터 보기
		System.out.println(q.size());
		System.out.println("front 값 삭제 : " + q.poll()); // 값 없으면 null발생
		System.out.println("front 값 삭제2 : " + q.remove()); // 값 없으면 exception 발생
	}

}
