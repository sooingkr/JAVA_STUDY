package _3_Random;

import java.util.Arrays;
import java.util.Random;

public class shffleAlgorithm {

	public static void main(String[] args) {
		String[] arr = {"one","two","three","four","five","six","seven","eight"};
		Random rand = new Random();
		
		for(int i=0; i<arr.length*2; i++){
			//int index = rand.nextInt(8); // 0 - 7
			int index = (int)(Math.random() * 8);
			String temp = arr[0];
			arr[0] = arr[index];
			arr[index] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
