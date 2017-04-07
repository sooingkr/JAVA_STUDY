/**
 * 		[	Wrapper Class	]
 * 		: java의 8가지 기본형 타입에 대한 class
 * 
 * 		존재이유)
 * 			: Object로 받아야하는 다형성의 경우 기본형 타입은 넘겨줄 수 없음... 객체가 아니어서
 * 			  따라서 이러한 기본형 타입을 객체로 Boxing해줘 넘기고 처리한 뒤 다시 UnBoxing해 기본형 타입으로 돌리는 작업을 하게 됨...
 * 
 * 		=> 근대 요즘엔 AutoBoxing과 AutoUnBoxing이 되기 때문에 딱히 고려할 사항은 아님...
 */
package _17_WrapperClass;

public class _1_WrapperClass {

	public static void main(String[] args) {
		byte bb = 3;
		
		// Boxing...
		Byte b = new Byte(bb);
		Short s = new Short((short)3);
		Integer i = new Integer(3);
		Long l = new Long(3);
		
		int num = i.intValue(); // Unboxing
		int num2 = i; // AutoUnboxing
		Integer ii = 3; // AutoBoxing
		
		
		WrappingMethod( new Integer(3) );
	}
	// 이렇게 원래 Object처럼 객체를 받을 때 기본형 타입은 받을 수 없어서 Boxing해서 보내야함(기본데이터)는
	public static void WrappingMethod(Object obj){
		if ( obj instanceof Integer){
			Integer num = (Integer)obj;
			System.out.println(num.intValue());
		}
	}
	// 하지만... 요즘엔 AutoBoxing, AutoUnBoxing되니까... 그냥 넣어!!
}
