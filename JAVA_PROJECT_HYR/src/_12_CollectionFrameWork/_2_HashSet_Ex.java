package _12_CollectionFrameWork;

import java.util.HashSet;
import java.util.Iterator;

public class _2_HashSet_Ex {

	public static void main(String[] args) {
		HashSet<Integer> hs1 = new HashSet<Integer>();
		HashSet<Integer> hs2 = new HashSet<Integer>();
		HashSet<Integer> hap = new HashSet<Integer>();
		hs1.add(1);
		hs1.add(2);
		hs1.add(3);
		hs1.add(4);
		hs1.add(5);

		hs2.add(4);
		hs2.add(5);
		hs2.add(6);
		hs2.add(7);
		hs2.add(8);

		Iterator<Integer> it = hs1.iterator();
		Iterator<Integer> it2 = hs2.iterator();

		while (it.hasNext()) {
			hap.add(it.next());
			hap.add(it2.next());
		}

		HashSet<Integer> sub = new HashSet<Integer>();
		Iterator<Integer> i = hs1.iterator();
		Iterator<Integer> i2 = hs2.iterator();
		while (i.hasNext()) {
			sub.add(i.next());
		}
		i = hs1.iterator();
		while(i2.hasNext()){
			sub.remove(i2.next());
		}

		
		// 교집합
		/*while(it.hasNext()){
			int num = it.next();
			if(hs2.contains(num)){
				hap.add(num);
			}
		}*/
		Iterator<Integer> ithap = hap.iterator();
		while (ithap.hasNext()) {
			System.out.println(ithap.next());
		}
	}

}
