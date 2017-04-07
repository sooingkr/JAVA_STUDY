/**
 * 		[	stack	  ]
 * 		: LIFO(Last In First Out) 구조
 * 
 */
package _12_CollectionFrameWork;

import java.util.Arrays;

public class _7_Stack_Queue {
	static int stack[] = new int[4];
	static int top = -1; // 마지막 인덱스를 가르키는 변수로 : 최초 아무것도 안가리키도록 -1로 세팅

	public static void push(int data) throws Exception { // stack 구조에 데이털르 저장

		if (isFull()) {
			System.out.println("꽉 참 더이상 저장 불가");
			throw new Exception("꽉참");
		} else {
			top++; // 데이터가 하나 추가될 때마다 마지막 가리키는 위치를 증가시켜줌
			stack[top] = data;
		}
	}

	public static boolean isFull() {
		if (top == stack.length - 1) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	public static int pop() throws Exception { // top 위치에 있는 데이터를 삭제(꺼내옴)
		if (isEmpty()) {
			System.out.println("들어있는 데이터가 없습니다.");
			throw new Exception("데이터가 비었습니다.");
			// return -1;
		} else {
			return stack[top--];
		}
	}

	public static void printStack() { // stack 내용물을 출력
		System.out.print("[");
		for (int i = 0; i <= top; i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.println("]");

	}

	public static void main(String[] args) {
		try {
			push(1);
			push(2);
			push(3);
		} catch (Exception e1) {
		}
		try {
			push(4);
			push(5);
		} catch (Exception e1) {

		}
		printStack();
		try {
			int num = pop();
			System.out.println(num);
			System.out.println(pop());
			System.out.println(pop());
			printStack();
			System.out.println(pop());
		} catch (Exception e) {
			e.getMessage();
		}
		// System.out.println(pop());
	}

}
