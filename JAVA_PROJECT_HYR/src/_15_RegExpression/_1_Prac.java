package _15_RegExpression;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class _1_Prac {

	public static void main(String[] args) throws IOException {
		// 이름 :
		// 나이 : (숫자여야함)
		// 주소 : 서울시 강남구 ( 시와 구를 띄어쓰기 형식으로 작성해야함 - 빈칸 한개 포함)
		// 정수 : (숫자이어야함)
		Scanner sc = new Scanner(System.in);

		String name = "";
		int age = 0;
		String address = "";
		int score = 0;
		
		while(true) { // 이름 입력 받기(공백은 입력하지 못하도록...)
			
			System.out.print("이름을 입력하세요 : ");
			name = sc.nextLine(); // enter 입력 전까지 데이터를 가지고 간 뒤 버퍼에서 enter를 제거함(enter가 기준)
			String regular = "[가-힣,a-z,A-Z]+";
			// 한글, 영어 중에 한글자 이상..
			if ("".equals(name) || " ".equals(name) || Pattern.matches(regular, name) == false ){
				System.out.println("형식에 맞게 다시 ");
			}else {
				break;
			}
			
		}
		
		while(true) { // 나이 입력 받기
			
			try {
				System.out.println("나이를 입력하세요 : ");
				age = sc.nextInt(); // inputMismatchException 발생가능...(숫자 외 입력에 대해...)
				sc.nextLine(); // nextInt() 후에 소모되지 않음 앤터를 소모시키기 위함...
				break; // 이 라인을 실행했다는건 정상적으로 입력이 이루어졌음을 의미함...(그니까 빠져나가면 됨...)
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요.");
				sc.nextLine(); // nextInt는 엔터는 남아있어서...
				// 또는, 인천시 서구라고 입력했을 시 정수가 아니니까 버퍼에 문자열이 그대로 포함되어 있음
				// 근대 next()로만하면 띄어쓰기 전인 인천시만 소비하고 서구는 버퍼에 여전히 남음으로 문제될 수 있기 때문에
				// nextLine()으로 한줄을 소비할 수 있음... 
				// 근대 버퍼를 그냥 통째로 비우고 싶으면...
				
			}
			
		}
		
//			address = sc.nextLine(); // 띄어쓰기 포함해야될 수 있음으로 next로는 못받음...
		sc.skip("[\\n\\r]+"); // 해당 정규표현식문자열을 스킵
		// 앤터쳐서 할 때 다음줄로 내려오고 맨 앞으로 커서를 보내는 \r이 같이 작동하게 되어 있기 때문에
		// 위와같이 두개 문자를 처리할 수 있도록 함
		// + 는 [] 안의 문자 중 하나가 한개 이상 올 수 있다는 정규표현식
		while(true) { // 주소를 입력 받기
			
			System.out.print("주소를 입력하세요 : ");
			System.out.println("입력값[ " + address + " ] ");
			if ( address.contains(" ")){
				break;
			}else {
				System.out.println("시와 구 사이에 빈칸을 넣어주세요.");
			}
		
		}
	
		while(true) {// 점수 입력 받기
			
			try {
				System.out.print("점수를 입력하세요 : ");
				score = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.print("정수를 입력하세요 : ");
			}
		}
	

		sc.close();
		System.out.println("\n");
		System.out.println("[사용자입력정보]" + "\n이름 : " + name + "\n나이 : " + age + "\n주소 : " + address + "\n정수 : " + score);
		
		
		
		
		
		
		
		
		//		System.out.print("이름을 입력해 주세요 : ");
//		String name = sc.next();
//		int num = 0;
//		int age = 0;
//		String input = "";
//		while (true) {
//			try {
//				System.out.println("나이를 입력해 주세요 : ");
//				age = sc.nextInt();
//				System.out.println("주소를 입력해 주세요 : ");
//				sc.next();
//				input = sc.nextLine();
//				boolean flag = Pattern.matches("", input);
//				if ( !flag ){
//					System.out.println("주소는 서울시 강남구 처럼 입력해야 합니다. 다시 입력합니다.");
//					continue;
//				}
//				System.out.print("정수 입력 : ");
//				num = sc.nextInt();
//				break;
//			} catch (InputMismatchException e) {
//				sc.next();
//				System.out.print("나이, 정수는 숫자만 입력해 주세요-> 다시 입력해 주세요 : ");
//				continue;
//			}
//		}
//		
//		System.out.println("이름 :" + name + "나이 : " + age + "주소 : " + input + "정수 : " + num);
	}
}
