/** 
 * 		[	배열의 복사	]
 * 
 * 		: 배열을 복사하는 방법에는 각 요소에 직접 접근해서 일일이 옮기는 방법을 제외하고
 * 		  간단히 할 수 있는 방법으로 2가지가 존재한다.
 * 
 * 		1. System.arraycopy(src, srcPos, dest, destPos, length);를 이용 => 단) 이건 얕은 복사만 가능!
 * 
 * 		2. Object class의 clone() 메서드를 이용한 방법 => 단, 이때는 참조변수에 대한 clone시에
 * 													얕은 복사가 이루어 짐으로 각 인덱스에 대해서 깊은 복사를 해주어야 한다.
 * */
package _6_Array;

class testClass implements Cloneable{
	int num;
	testClass(int num){
		this.num = num;
	}
	@Override
	protected testClass clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (testClass)super.clone();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.num + " ";
	}
}
public class _3_ArrayCopy {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		// 1. System.arraycopy(src, srcPos, dest, destPos, length);
		int[] arr = new int[]{1,2,3,4};
		int[] temp = new int[arr.length]; // 복사하기 위한 임시 배열
		System.arraycopy(arr, 0, temp, 0, arr.length); // 복사할배열, 복사시작위치, 붙여넣을배열, 붙일시작위치, 붙일 개수
		
		for(int i=0; i<temp.length; i++){
			System.out.print( temp[i] + " ");
		}
		// 복사가 이루어지지만 이는 얕은 복사에만 이용할 수 있다. 즉 기본 데이터 타입은 복사가 가능하지만
		// 참조형 데이터의 경우 배열 공간을 그대로 복사할 때 각 index가 가리키고 있는 주소까지 복사하지 않고 기존값을 그대로 가지고 있다보니
		// 같은 메모리 공간을 가리키게 되어 참조데이터의 경우에서는 복사한 배열을 수정시 원본 배열까지 값이 바끼게 되는 현상이 생길 수 있다.
		// 따라서, 참조타입의 경우 사용을 지양한다.
		
		//***********************************************************************************************************
		
		// 2. Object class의 clone() 메서드를 재정의해서 사용하는 방법.
		// 	=> 기본 데이터 타입을 복사할 경우 얕은 복사만 이루어져도 됨으로 그냥 편하게 clone메서드를 사용해도 된다.
		int[] arr2 = new int[]{1,2,3};
		int[] temp2 = new int[arr2.length];
		temp2 = arr2.clone();
		temp2[0] = 6;
		for(int i=0; i<temp2.length; i++){
			System.out.print("arr2[" + i + "]의 값 : " + arr2[i] + " temp2[" + i + "]의 값 : " + temp2[i] );
		}
		// 참조데이터 타입이 아니어서 별 문제없다. 즉, 복사가 잘 되어 복사한 temp2의 값을 바까도 원본 데이터에 영향을 미치지 않는다.
		
		
		testClass[] arrClass = new testClass[]{new testClass(1), new testClass(2)};
		testClass[] temp3 = new testClass[ arrClass.length ];
		temp3 = arrClass.clone(); // 참조 타입은 얕은 복사가 이루어지기 때문에 복사한 데이터를 수정시 원본데이터도 같이 바끼는 문제가 생긴다.
		// why??? : temp3에는 arrClass 변수에 저장되어 있는 주소가 가리키는 공간 자체가 복사되지만 각 배열 공간안에서 가리키는 공간에 대한
		//		복사까지는 이루어 지지 않고 원본 데이터가 가리키고 있는 장소를 그대로 가리키고 있기 때문이다.
		// 따라서, 각 인덱스별로 배열값을 clone해주어야 한다.
		
		// 일단, 문제가 발생되는 예제를 보자.
		System.out.println();
		temp3[0].num = 5;
		System.out.println( arrClass[0] ); // class에 toString을 재정의했기 때문에 객체명만으로 출력이 가능토록 했다.
		// 결과를 보면 알겠지만 원본데이터 값은 1이었는데 5로 바낀 것을 알 수 있다.
		
		// 해결책 => 각 배열 인덱스별로 clone을 또 해주어야 한다.
		for(int i=0; i<arrClass.length; i++){
			// 하지만 이렇게 clone을 쓸려면 오류가 뜨는데 이는 Object의 clone()메서드가 protected로 선언되어 있기 때문에 나타나는 현상이다.
			// 따라서 clone 메서드를 재정의해서 public으로 바까주던지 아니면 해당 클래스 이용할 수 있도록 해주어야 한다.
			// 이때, clone() 메서드를 재정의하기 위해서는 Cloneable 인터페이스를 implements를 해 주어야 한다.(나 clone 메서드 쓸게 허락해줘? 이런의미)
			
			temp3[i] = arrClass[i].clone(); 
			// 위 작업 + try catch 작업을 해주면 clone을 사용할 수 있다. 여기선 try catch를 throw해버렸다.
			
		}
		
		temp3[1].num = 8;
		System.out.println( arrClass[1] ); // 각 배열요소별로 clone을 해주고 난 뒤엔 temp3의 값을 바까도 원본데이터에 영향을
		// 미치지 않아 원래 값대로 2가 출력됨을 알 수 있다.
	}
	

}
