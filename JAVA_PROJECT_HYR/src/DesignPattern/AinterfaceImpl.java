/** 
 * 		[	인터페이스	]
 * 		:1) 기능의 선언과 구현을 분리
 * 		:2) // funcA 기능을 사용하는 통로.
		// ~명칭으로 사용하도록 미연에 약속을 함.
		// 너가 어떻게 작업을 하던 상관없는데
		// 내가 필요한 ~~ 기능은 ~~ 메서드로 하고 싶으니
		// ~~메서드는 ~기능을 하도록 해줘
		// 할때, "인터페이스"에 정의해 사용할 수 있다.
		 * 
		[	델리게이트	]
		: 특정 개체의 기능을 사용하기 위해 특정 개체의 기능을 호출하는 것
		
 * */
package DesignPattern;

public class AinterfaceImpl implements Ainterface{

	public static void main(String[] args) {
		
		Ainterface ainterface = new AinterfaceImpl();
		
		// funcA 기능을 사용하는 통로.
		// ~명칭으로 사용하도록 미연에 약속을 함.
		// 너가 어떻게 작업을 하던 상관없는데
		// 내가 필요한 ~~ 기능은 ~~ 메서드로 하고 싶으니
		// ~~메서드는 ~기능을 하도록 해줘
		// 할때, "인터페이스"에 정의해 사용할 수 있다.
		ainterface.funcA();

	}

	@Override
	public void funcA() {
		System.out.println("AAA");
	}

}
