package _12_CollectionFrameWork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class _1_HashMap {

	public static void main(String[] args) {

		HashMap<Integer, Temp> hm = new HashMap<Integer,Temp>();
		hm.put(2, new Temp("two"));
		hm.put(1, new Temp("one"));
		hm.put(4, new Temp("four"));
		hm.put(3, new Temp("three"));
		
		Set keyset = hm.keySet();
		
		Iterator<Integer> it = keyset.iterator();
		while(it.hasNext()){
			System.out.println( hm.get(it.next()));
		}
	}

}

class Temp{
	String name;
	Temp(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
