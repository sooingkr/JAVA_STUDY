/**
 * 		[	Inner Class 활용	]
 * 
 */
package _10_Interface;

public class _6_InnerClass_Ex {

	public static void main(String[] args) {
		
		Out.InA ina = new Out().new InA();
		
		Out.InS ins = new Out.InS();
		System.out.println(new Out.InS().staticins);;
		Out local = new Out();
		local.print();
	} // end of main

} // end of _6_InnerClass_Ex

class Out {
	int a = 3;
	static int s = 4;
	
	class InA { // 인스턴스 멤버 클래스
		String ina = "InA";
		public InA() {
			System.out.println(ina);
		}
	}
	static class InS { // static 이너 클래스
		String ins = "InS";
		static String staticins = "StaticIns";
		public InS() {
			System.out.println(ins);
		}
	}
	void print(){
		class Local { // 지역 이너 클래스
			String local = "Local";
			public Local() {
				System.out.println(local);
			}
		}
		Local l = new Local();
	}
	
	public Out() {
		System.out.println("Out 클래스 생성자");
		// TODO Auto-generated constructor stub
	}
	
}// end of class Out