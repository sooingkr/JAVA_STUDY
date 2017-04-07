/**
 * 			[	Definiation	 ]
 * 
 * 		- Comparator interface : 사용자 정렬 - compare() 오버라이딩...
 * 		- Comparable interface : 기본 정렬 - compareTo() 오버라이딩...
 * 		- Iterator interface : 인덱스 접근...( Collections 객체들의 인덱스 접근을 위해 제공 )
 * 		
 * 		CollectionFramework 는 크게 Collections 인터페이스와 Map인터페이스로 나누어짐... 
 * 			- Collections 인터페이스
 * 					1) set 인터페이스 : 집합개념으로 중복을 배제한 순서없는 저장소
 * 							ex) HashSet(중복배제를 위해 equals와 hashCode를 오버라이딩해야함), TreeSet(정렬기능이 부여된 set), LinkedHashSet ...
 * 
 * 					2) list 인터페이스 : 배열 + 바운더리 증가의 개념으로 중복 허용, 순차 저장 방식
 * 							ex) ArrayList : 배열과 유사함 add, remove시 새로운 배열을 만들고 옮기는 작업을하기 때문에
 * 												  잦은 추가,제거 작업시 불리함 but 순차검색하기 때문에 검색이 많은 경우 좋음
 * 								 LinkedList : 검색은 약하지만, 잦은 삽입 삭제에 유리함...
 * 								 Vector : ArrayList의 구형 버전... 지금은 잘 안씀(동기화처리 되어 있는데 싱글쓰레드에선 불필요하게 성능 감소시킴으로... )
 * 										=> 차라리 ArrayList 사용이 권장됨.
 * 								 Stack
 * 								 
 * 					3) Queue 인터페이스
 * 								ex) LinkedList : 이건 Queue인터페이스와 list인터페이스를 모두 구현해서 되어 있음..
 * 
 * 			- Map 인터페이스 : (key, value) 쌍으로 저장 key는 중복안되지만 value는 중복될 수 있음...
 * 					1) HashMap
 * 
 * 					2) TreeMap(정렬기능이 부여된 Map) : Comparable 구현이 요구되어짐...
 * 				=**> 맵에서도 Set 객체로부터 key집합을 얻어오고, 해당 key집합 객체로부터 Iterator를 얻어와
 * 						인덱스를 이용한 출력도 할 수 있다.
 */
package _12_CollectionFrameWork;

public class _0_Definition {

	public static void main(String[] args) {
		
	}

}
