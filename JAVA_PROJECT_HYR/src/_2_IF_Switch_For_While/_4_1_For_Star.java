package _2_IF_Switch_For_While;

import java.util.Scanner;

public class _4_1_For_Star {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("몇 줄 짜리 다이아를 만드시겠어요? : ");
		int num = sc.nextInt();

		for (int i = 0; i < (num / 2); i++) {
			for (int j = 0; j <= (num / 2) - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= (i * 2) + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = (num / 2); i >= 0; i--) {
			for (int j = i; j <= (num / 2); j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i * 2; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
/////////////////////////////////////////////////////////////////////////
		// 스타 찍기
		int n = 0;
		for(int i=1;i<=3;i++)
		{
			for(int j=5;j>=i;j--)
			{
				System.out.print(" ");
			}
			for(int j=0;j<i*2-1;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<5;i++)
		{
			if(i<3)
			{
				for(int j=0;j<i;j++)
				{
					System.out.print(" ");
				}
				for(int j=0;j<11-(i*2);j++)
				{
					System.out.print("*");
				}
			}
			else
			{

				for(int j=i+1;j<5;j++)
				{
					System.out.print(" ");
				}
				for(int j=0;j<9+(n*2);j++)
				{
					System.out.print("*");
				}
				n++;
			}
			System.out.println();
		}
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3+i;j++)
			{
				System.out.print(" ");
			}
			for(int j=0;j<5-(i*2);j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		/////////////////////////////////////////////////
		
		for (int i = 0; i < (num / 2); i++) {
			for (int j = 0; j <= (num / 2) - i; j++) {
				System.out.print("*");
			}
			for (int k = 1; k < (i * 2)+ 1 ; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= (num / 2) - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = (num / 2); i >= 0; i--) {
			for (int j = i; j <= (num / 2); j++) {
				System.out.print("*");
			}
			for (int k = 0; k < i * 2 ; k++) {
				System.out.print(" ");
			}
			for (int j = i; j <= (num / 2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/////////////////////////
		// 1
		// 12
		// 123
		// 1234
		// 12345
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}

		// 34
		// 345
		// 3456
		// 34567
		for (int i = 1; i <= 6; i++) {
			for (int j = 3; j <= 3 + i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}

		// 1
		// 13
		// 135
		// 1357
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= (2 * i); j += 2) {
				System.out.print(j);
			}
			System.out.println();
		}

		// 0
		// 02
		// 024
		// 0246
		// 02468
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < (2 * i); j += 2) {
				System.out.print(j);
			}
			System.out.println();
		}

		// 0
		// 03
		// 036
		// 0369
		//
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < (3 * i); j += 3) {
				System.out.print(j);
			}
			System.out.println();
		}

		// 1 2 4 7 11 16 22

		for (int i = 1, j = 0; i <= 22; i++, j++) {

			System.out.print(i + " ");
			i += j;
		}
		System.out.println();
		System.out.println();
		//
		// 1
		// 123
		// 12345
		// 1234567
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= (2 * i) - 1; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
		// 01
		// 01234
		// 01234567
		for (int i = 1; i <= 4; i++) {
			for (int j = 0; j < (2 * i); j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

		// A
		// AB
		// ABC
		// ABCD
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print((char) (j + ('A' - 1)) + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

		// abcdefg
		// abcdef
		// abcde
		// abcd
		// abc
		for (char i = 'g'; i >= 'c'; i--) {
			for (char j = 'a'; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

		// bc
		// bcdef
		// bcdefgui
		// bcdefghijkl
		// bcdefghijklmno
		for (char i = 'c'; i <= 'o'; i += 3) {
			for (char j = 'b'; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

		// 0
		// 12
		// 345
		// 6789

		for (int i = 1, k = 0; i <= 4; i++) {
			for (int j = 0; j < i; j++) {

				System.out.print((k++) + " ");

			}
			System.out.println();

		}

		// A
		// BC
		// DEF
		// GHIJ
		// KLMNO
		// PQRSTU
		int kk = 'A';
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print((char) (kk++) + " ");
			}
			System.out.println();
		}
		System.out.println();

		// 0
		// 12
		// 345
		// 6789
		// ABCDE
		// FGHIJK
		// LMNOPQR
		// STUVWXYZ
		char alpha = 'A';
		for (int i = 1, num1 = 0; i <= 8; i++) {
			for (int j = 1; j <= i; j++, num1++) {

				if (num1 > 9) {

					System.out.print((char) alpha++ + " ");
				} else {
					System.out.print(num1 + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
		// a
		// bc
		// def
		// ABCD
		// EFGHI

		char alpha3 = 'A';
		for (int i = 1, alpha2 = 'a'; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				if (alpha2 > 'f') {
					System.out.print(((alpha3++)));
				} else {
					System.out.print((char) alpha2++);
				}
			}
			System.out.println();
		}
	}

}
