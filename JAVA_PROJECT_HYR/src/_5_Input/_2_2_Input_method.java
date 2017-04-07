/**
 * 		[ 사용자의 입력을 받는 방법 2 : Scanner		]
 * 
 */
package _5_Input;

import java.util.Scanner;

public class _2_2_Input_method {

	public static void main(String[] args) {
		
		
		
		/*
		String inputStr = sc.nextLine(); // 한줄 입력 받기 
		// 주의! enter를 기준으로 들어가게 됨.
		// nextInt()해서 숫자 enter하면 숫자만 들어가고 버퍼안에 enter키가 남아있는데
		// 이 바로 아래에 nextLine()을 해버리면 enter 때문에 공백만 가져가 입력받을 기회가 없어진다.
		// 이점 주의!
		// 1. nextInt() 는 앞에 있는 화이트 스페이스(공백, 엔터)는 제거해주고 숫자만 받아 간다.
		 * 숫자 뒤 엔터 등은 남아 있게 된다.
		// 2. nextLine() 은 enter를 기준으로 그 앞까지 문자열을 가져가고 가져간 뒤에는 enter를 제거해 준다. 버퍼에서
		// 3. next()는 문자열만 가져간다.( nextInt()처럼 문자열 앞의 화이트스페이스(공백, 엔터)는 제거하고 (화이트 스페이스) 전까지의
		 *문자열만 받아간다.
		
		// 따라서, nextInt() 다음에는 1) next()를 써서 문자열을 받던지
		//									 2) nextLine()을 한번 더 수행해 주어 해결할 수 있다.
		 * 
		int num = sc.nextInt();
		double numDouble = sc.nextDouble();*/
		
		// 사용자의 입력을 숫자로 3개 받아서 최대값을 출력
		
		
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		
		for(int i=0; i<arr.length; i++){
			System.out.println( (i+1) + "번째 수 입력 : ");
			arr[i] = sc.nextInt();
		}
		for(int j=0; j<arr.length; j++){
			if(arr[j] > arr[j]){
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
		System.out.println("최대값 : " + arr[arr.length-1] + " 최소값 : " + arr[0]);
		
	} // end of main

} // end of class
