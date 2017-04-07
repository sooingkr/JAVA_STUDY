/**
 * 	[	 다형성의 활용	]
 * */
package _7_Class;

public class _16_PolyMorphism {

	public static void main(String[] args) {

		Human h = new Human();
		Boy b = new Boy();
		Girl g = new Girl();
		Baby ba = new Baby();

		// 배열에 여러가지 타입을 저장해 보자(배열 : 같은 타입만 저장 가능)

		Human[] HumanArray = new Human[4];
		HumanArray[0] = h;
		HumanArray[1] = b; // 다형성 ex
		HumanArray[2] = g;
		HumanArray[3] = ba;

		for (int i = 0; i < HumanArray.length; i++) {
			if (HumanArray[i] instanceof Boy) { // Boy로 형변환 가능하면...
				System.out.println(((Boy) HumanArray[i]).strong);
			} else if (HumanArray[i] instanceof Girl) { // Girl로 형변환 가능하면...
				System.out.println(((Girl) HumanArray[i]).money);
			} else if (HumanArray[i] instanceof Baby) {
				System.out.println(((Baby) HumanArray[i]).age);
			} else if (HumanArray[i] instanceof Human) {
				System.out.println(((Human) HumanArray[i]).name);
			} else {
				System.out.println("형변환 불가");
			}
		}
		System.out.println();
		printHuman( h );
		printHuman( b );
		printHuman( g );
		printHuman( ba );
		

	} // end of main

	static void printHuman( Human h ) {
		if ( h instanceof Boy ){
			Boy b = (Boy)h;
			System.out.println( b.name + " " + b.strong);
		} else if ( h instanceof Girl ){
			Girl g = (Girl)h;
			System.out.println( g.name + " " + g.money);
		} else if ( h instanceof Baby ){
			Baby ba = (Baby)h;
			System.out.println( ba.name + " " + ba.age);
		} else if ( h instanceof Human ){
			Human hh = (Human)h;
			System.out.println( hh.name );
		} else {
			System.out.println("형변환 불가");
		}
	}
} // end of class

class Human {
	String name = "HYR";
}

class Boy extends Human {
	int strong = 10;
}

class Girl extends Human {
	int money = 200;
}

class Baby extends Human {
	int age = 3;
}