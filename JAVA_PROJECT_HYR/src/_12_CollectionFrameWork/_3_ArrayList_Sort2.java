// 2��° ���� ��� Comparator �� �����ϴ� ���.
// 3���� Comparator�� �͸�Ŭ������ ���� Ȱ��

package _12_CollectionFrameWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _3_ArrayList_Sort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Man2> al2 = new ArrayList<Man2>();
		al2.add(new Man2("Ȳ����",28));
		al2.add(new Man2("�迵��",28));
		
		// 2
		Collections.sort(al2, new ManComparator());

		// 3. �͸� Ŭ���� Ȱ��
		Comparator<Man2> com = new Comparator<Man2>(){
			public int compare(Man2 o1, Man2 o2) {
				return o1.age - o2.age;
			};
		};
		Collections.sort(al2, com);
		System.out.println(al2);
	}
}

class Man2 {
	String name = "";
	int age;

	public Man2() {
		// TODO Auto-generated constructor stub
	}

	public Man2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + this.age;
	}
};

class ManComparator implements Comparator<Man2> {
	public int compare(Man2 o1, Man2 o2) {

		// return o1.age - o2.age;
		// 1. ���̸� �������� ��������
		// 2. ���̸� �������� ��������
		// return o2.age - o1.age;
		// 3. �̸��� �������� ��������
		// return o1.name.compareToIgnoreCase(o2.name);
		// 4. �̸��� �������� ��������
		return o2.name.compareToIgnoreCase(o1.name);
	};
}