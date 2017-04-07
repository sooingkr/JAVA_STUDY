package _3_Random;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 순서섞기 shuffle 이용한 로또번호 출력
 * 		=> 중복값 뜨지 않도록 하기.
 */
public class TestRandom {
	public static void main(String[] args) {
		Random ran = new Random();
		// 0+1<= ~ <45+1
		int num[] = new int[45]; // 번호를 한번씩 기록
		for (int i = 0; i < num.length; i++) {
			num[i] = i+1; // 로또번호 초기화
		}
		System.out.println("섞기전"+Arrays.toString(num));
		
		// 섞기 shuffle
		// 0번 방과 랜덤위치방 의 값을 교환 : 랜덤으로 생성한 인덱스 위치와 0번 인덱스 위치를 num.length*2 번만큼 교체해가며 섞음.
		for (int i = 0; i < num.length*2; i++) { // *높을수록 잘 섞임.
			int r = ran.nextInt(45); // 0~44
			int temp = num[0]; // 0번방값 <-> 랜덤방값
			num[0] = num[r];
			num[r] = temp;
		}
		System.out.println("섞은후"+Arrays.toString(num));
		for (int i = 0; i < 6; i++) {
			System.out.print(num[i]+",");
		}
		
		int[] scores = new int[6];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = num[i];
		}
		System.out.println("____");
		System.out.print("로또 번호를 입력하세요(ex 1 2 4 10 45 3) : ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		
		String[] s = temp.split(" ");
		int[] ss = new int[]{
			Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]),Integer.parseInt(s[4]),Integer.parseInt(s[5]),	
		};
		int count = 0;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				if ( scores[i] == ss[j] ) {
					count++;
				}
			}
		}
		
		switch (count) {
		case 2:
			System.out.println("2개 맞춤");
			break;
		case 3:
			System.out.println("3개 맞춤");
			break;
		case 4:
			System.out.println("4개 맞춤");
			break;

		default:
			System.out.println("~~~");
			break;
		}
	} // end of main
} // end of class

















