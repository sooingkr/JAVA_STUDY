/**
 * 		[	 정렬의 두가지 방법	]
 * 		Collections.sort() 메서드를 사용하기
 * 			단, 이 메서드 사용하기 전 
 * 			1) Comparable 인터페이스 구현 ( compareTo() )
 * 			2) Comparator 인터페이스 구현 (compare()) 
 * 			둘 중 하나를 이용해서 할 수 있다.
 */
package _12_CollectionFrameWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class _2_ArrayList_Sort {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc");
		al.add("zzz");
		al.add("float");
		al.add("ddd");
		System.out.println(al);
		
		Collections.sort(al);
		System.out.println(al);
		
		System.out.println(al.get(1));
		for (int i = 0; i < al.size(); i++) {
			System.out.print(al.get(i) + " ");
		}
		System.out.println();
		
		Iterator<String> i = al.iterator();
		// Iterator �� ��� Collection �������̽� ������ ����� ����
		// => al.iterator() �ϸ� al�� ����� �����͸� ������ �ִ� iterator ��ü�� ��ȯ�ϴ� ���̰�
		// next()�� ���� ���� ������ ���� �����͸� �����Ͱ� ����Ű�� �Ǿ� ����
		// ����, next()�� ������ ������ ��� ����� �� next()�� �� ��� ������ �� �� �������� ���� ���.
		while(i.hasNext()){
			System.out.print(i.next() + " ");
		}
		System.out.println();
		
		
		ArrayList<Man> alMan = new ArrayList<Man>();
		alMan.add(new Man("ȣ����",20));
		alMan.add(new Man("����",24));
		alMan.add(new Man("����ȣ",40));
		alMan.add(new Man("������",32));
		for (int j = 0; j < alMan.size(); j++) {
			System.out.println(alMan.get(j));
		}
		
		// [ ���� ��� ]
		Collections.sort(alMan); // Compareable ����!!( �� �����Ұž�!!! ) ��, compare �޼��� �������̵�.
		System.out.println(alMan);
		
		
	} // end of main

} // end of class

class Man implements Comparable{
	String name = "";
	int age;
	public Man() {
		// TODO Auto-generated constructor stub
	}
	public Man(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
//		if ( this.age > ((Man)o).age ){
//			return 1;
//		}else if ( this.age < ((Man)o).age ){
//			return -1;
//		}else {
//			return 0;
//		}
		// 1.��������
		//return this.age - ((Man)o).age;
		// 2.��������
		// return ((Man)o).age - this.age;
		// 3. �̸� ��������
		//return this.name.compareTo(((Man)o).name);
		// ���ڿ� ������ : String�� �����Ǿ� �ִ� compareTo() �޼��� ȣ���� �ϴ� ���
		// 4. �̸� �������� : - �� �ٿ��� ���� or �ΰ� �Ķ���� ��ġ �ٲٱ�
		
		// this.age - obj.age 
		// 문자열의 경우에는 compareTo()가 내부적으로 오버라이딩되어 있어 가나다 순으로 정렬할 때 이용하면 좋다.
		return - ( this.name.compareTo(((Man)o).name) );
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + this.age;
	}
}
