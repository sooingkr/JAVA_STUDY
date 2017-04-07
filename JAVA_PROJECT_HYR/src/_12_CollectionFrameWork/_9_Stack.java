package _12_CollectionFrameWork;

import java.util.Iterator;
import java.util.Stack;

public class _9_Stack {

	public static void main(String[] args) {
		Stack<Man3> s = new Stack<Man3>();
		s.push(new Man3("홍길동", 1));
		s.push(new Man3("류현진", 1));
		s.push(new Man3("임창용", 1));
		
		/*Man3 m = s.pop();
		System.out.println(m);
		System.out.println(s.pop());*/

		// Iterator 이용해 출력하기
		Iterator<Man3> it = s.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}

class Man3 {
	String name = "";
	int age;
	public Man3(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return this.name + " : " + this.age;
	}
}