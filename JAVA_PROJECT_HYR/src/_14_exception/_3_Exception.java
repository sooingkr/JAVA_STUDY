package _14_exception;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class _3_Exception {

	static String str;

	public static void main(String[] args) {
		
//		try{
//		str.length();
//		}catch(NullPointerException e){
//			System.out.println(e.getClass() + " : " + e.getMessage());
//		}
//		
//		int arr[] = new int[2];
//		try{
//		System.out.println( arr[3] + " " );
//		
//		}catch(ArrayIndexOutOfBoundsException e){
//			System.out.println(e.getClass() + " : " + e.getMessage());
//		}
//		
//		try{
//		System.out.println( 3 / 0 );
//		
//		}catch(ArithmeticException e){
//			System.out.println(e.getClass() + " : " + e.getMessage());
//		}
//		
		Scanner sc = new Scanner(System.in);
//		try{
//		int num = sc.nextInt();
//	
//		}catch(InputMismatchException e ){
//			System.out.println("입력타입을 맞춰주세요");
//		}catch(IllegalStateException e){
//			System.out.println("스캐너를 닫아주세요");
//		}catch(Exception e){
//			System.out.println("위에 올라오면 안되요... 위에선언되면 위에서 다 일로들어와요..(예외 부모니까...");
//		}finally{
//			System.out.println("그래도 이건 무조건 실행되죠");
//		}
//		
		// 사용자의 나이를 입력받고, 이름을 입력받고
		// 정상적으로 입력시 사용자입력정보를 출력 후 종료
		int age = 0;
		String n1 = "";
		int n2 = 0;

		System.out.println("이름입력: ");
		n1 = sc.next();
		do {
	            try {
	                System.out.println("나이입력: ");
	                n2 = sc.nextInt();
	                
	                //bError = false; // 여기를 수행한다는건 정상처리됐다는 것
	                break;
	            } 
	            catch (Exception e) {
	                System.out.println("Error!");
	                sc.next(); // 잘못입력되면 내부 버퍼에 쌓아논 잘못입력된 값을 가져가지 않고잇어
	                // 다시 돌아도 계속 catch로 가게된다. 따라서 소모를 해줘야함...
	            }
	        } while (true);
		System.out.println("name : " + n1 + "age : " + n2);
	}
}
