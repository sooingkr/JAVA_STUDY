/**
 * 	BufferedReader
 * 
 */
package _5_Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class _2_1_Input_method {

	public static void main(String[] args) throws IOException {
		
		// 사용자의 숫자를 3개 입력받아서, 입력받은 수 출력, 총점과 평균을 출력
		
		String[] inputNum = new String[3];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br.close(); // stream 해제
		
		int num = 3;
		String str = Integer.toString(3); // 문자열화
		str = 3 + ""; // 또다른 문자열화
		int sum = 0;
		
		for(int i=0; i<inputNum.length; i++){
			System.out.println( (i+1) + "번째 수를 입력하세요 : ");
			inputNum[i] = br.readLine();
			sum += Integer.parseInt(inputNum[i]);
		}
		System.out.println("합은 : " + sum + " 평균은 : " + ((double)sum/inputNum.length) );
		
		
	} // end of main

} // end of class
