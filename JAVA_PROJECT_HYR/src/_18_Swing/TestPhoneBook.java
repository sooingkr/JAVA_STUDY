package _18_Swing;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 전화번호부
 */
public class TestPhoneBook {
	static HashMap phoneBook = new HashMap();
	public static void addGroup(String group) {
		if (!phoneBook.containsKey(group)){//없으면
			phoneBook.put(group, new HashMap());
		}
	}
	public static void addPhonebook
		(String group, String name, String phone) {
		addGroup(group);//phoneBook에 group에 있는지 확인
		HashMap hm = (HashMap)phoneBook.get(group);
		hm.put(phone, name); // 전화번호부에 추가
	}
	public static void addPhonebook
		(String name, String phone) {
		addPhonebook("기타", name, phone);
	}
	public static void main(String[] args) {
		addPhonebook("쌤","서민규","010-9128-0000");
		addPhonebook("쌤","송중기","010-1111-1111");
		addPhonebook("친구","송승윤","010-2222-2222");
		addPhonebook("친구","김용래","010-3333-3333");
		addPhonebook("친구","김영관","010-4444-4444");
		addPhonebook("김지혜","010-5555-5555");
		addPhonebook("윤주희","010-6666-6666");
		addPhonebook("반상수","010-7777-7777");
		addPhonebook("김지혜","010-8888-8888");
		
		printPhoneBook();
	} // end of main
	static void printPhoneBook() {// phoneBook 출력
		Set s = phoneBook.entrySet();
		Iterator iter = s.iterator();
		while(iter.hasNext()) {
			Map.Entry e = (Map.Entry)iter.next();
			System.out.print(e.getKey());//그룹이름
			HashMap hs = (HashMap)e.getValue();//전번,이름 HashSet
			System.out.println(hs.size()+"명");
		
			Set subset = hs.entrySet();
			Iterator subiter = subset.iterator();
			while(subiter.hasNext()) {
				Map.Entry subE
					= (Map.Entry)subiter.next();
				System.out.println( "\t"+
				subE.getValue()+", "+subE.getKey());
			}
		}
	}
} // end of class















