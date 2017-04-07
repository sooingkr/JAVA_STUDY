package _12_CollectionFrameWork;

import java.util.Stack;

public class _8_Stack {

	public static void main(String[] args) {
		Stack s = new Stack();
		System.out.println(s.push(1) + "을 스택에 저장");
		System.out.println(s.push(2) + "을 스택에 저장");
		System.out.println(s.push(3) + "을 스택에 저장");
		
		s.peek();// pop과 달리 stack의 top값을 가지고오되 제거하진 않음.
		System.out.println("top에 있는 객체 구경 : " + s.peek());
		
		System.out.println("2데이터의 위치 : " + s.search(2)); // 2번째
		
		System.out.println(s.pop() + " 데이터 삭제");
		System.out.println(s.pop() + " 데이터 삭제");
		System.out.println("비어있는지 여부 " + s.empty());
	}

}
