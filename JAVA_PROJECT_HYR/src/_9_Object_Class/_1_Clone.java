/** 
 * 		[	Object Class의 Clone 메서드	]
 * 
 * 		: Object의 clone() 메서드의 경우 복사를 담당한다.
 * 
 * 		=> 기본 데이터 타입의 경우 편리하게 복사가 잘 이루어 지지만 ex)기본데이터 타입 배열 복사 등.
 * 
 * 		==> 하지만, 참조타입의 경우 "얕은 복사"가 이루어 진다. why? 변수에 저장된 값을 그대로 복사하기 때문에 내부 주소값을 그대로
 * 			가지고 와서 같은 데이터를 가리키게 되는 문제가 있다.
 * 
 * 		=> 따라서, clone메서드를 재정의해서 해당 참조변수가 가리키는 공간 자체도 복사를 한번 더 해주어야 한다!
 * 
 * 		[	clone 메서드 사용 방법	]
 * 	
 * 		:1) clone메서드를 사용하기 위해서는 Cloneable 인터페이스를 implmenents 해서 "나 clone메서드 사용할게 허락해줘"라는 허가를 받아야 한다.
 * 		 2) 그리고, clone() 메서드의 경우 protected로 되어 있기 때문에 다른 곳에서 사용하기 위해 clone메서드를 오버라이딩해서
 * 			재정의해서 사용해야 한다.
 * */
package _9_Object_Class;

import java.util.Arrays;


class Temp implements Cloneable{
	String name;
	Temp(String name){
		this.name = name;
	}
	
	@Override
	protected Temp clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Temp)super.clone();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
public class _1_Clone {

	public static void main(String[] args) throws CloneNotSupportedException {
		// 1. 기본데이터 배열의 복사
		int[] num1 = new int[]{1,2,3,4};
		int[] num2 = num1.clone();
		System.out.println(Arrays.toString(num2)); // 복사가 잘 이루어짐
		
		// 2. 참조타입 배열의 복사 => Cloneable implements -> clone() 재정의
		Temp t1 = new Temp("hyr");
		Temp t2 = new Temp("hyr");
		t1 =(Temp)t2.clone();
	    
		t2.name = "수정";
		System.out.println(t2.name);
		System.out.println(t1.name); // 깊은 복사가 됐음.
		
		// 3. 참조타입 배열의 복사
		Temp[] t3 = new Temp[]{new Temp("one"), new Temp("two"), new Temp("Three")};
		Temp[] copy = t3.clone();
		t3[0].name = "modify";
		System.out.println(copy[0]); // modify가 출력됨 => "얕은복사"가 이루어짐.
		// 따라서, 배열이 가리키는 각 요소가 가리키는 공간도 각 인덱스에 대해서 복사를 해 주어야 함.
		
		for (int i = 0; i < t3.length; i++) {
			copy[i] = t3[i].clone(); // 깊은 복사를 진행
		}
		
		t3[1].name = "modify2";
		System.out.println(copy[1]); // 영향을 받지 않고 two가 출력됨 : 깊은 복사가 잘 이루어 졌음.
	}

}
