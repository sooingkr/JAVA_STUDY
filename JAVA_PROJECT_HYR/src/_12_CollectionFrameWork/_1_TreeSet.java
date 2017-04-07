/** 
 * 		[	TreeSet	 ]
 * 		: Set계열이며 이진트리를 이용해 내부적으로 정렬해서 저장함
 * 		
 * 			사용을 위해 비교하는 Comparable을 implements하고
 * 			비교기준을 지정하기 위해 compareTo 메서드를 오버라이딩해준다.
 * */
package _12_CollectionFrameWork;

import java.util.Iterator;
import java.util.TreeSet;

public class _1_TreeSet {

	public static void main(String[] args) {
		TreeSet<Dummy> t1 = new TreeSet<Dummy>();
		t1.add(new Dummy("hyr",1));
		t1.add(new Dummy("hyr",1));
		t1.add(new Dummy("aaa",3));
		t1.add(new Dummy("hyr",2));
		t1.add(new Dummy("ggg",4));
		
		Iterator<Dummy> it = t1.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
	}

}

class Dummy implements Comparable<Dummy>{
	String name;
	int num;
	Dummy(String name, int num){
		this.name = name;
		this.num = num;
	}
	
	@Override
	public int compareTo(Dummy o) {
		//이름순 정렬
		//return this.name.compareTo(((Dummy)o).name);
		
		// num을 기준으로 오름차순...
		return this.num - ((Dummy)o).num;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( this.name.equals(((Dummy)obj).name) && this.num == ((Dummy)obj).num){
			return true;
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (this.name + num).hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " : " + this.num;
	}
}