package _3_Random;

import java.util.Arrays;
import java.util.Random;

public class _1_2_Random {

	public static void main(String[] args) {
		
		// 1 ~ 45 로또 번호 6개 출력
		Random ran = new Random();
		
		int[] rottoNum = new int[45];
		long seed = System.currentTimeMillis();
		
		Random rand = new Random(seed);
		//rand.setSeed();
		
		for(int i=0; i<rottoNum.length; i++){
			rottoNum[i] = (rand.nextInt(45) + 1);
		}
		
		// shuffle 0번 방과 랜덤위치방의 값을 교환
		
		for(int i=0; i<rottoNum.length*2; i++){
			int r = ran.nextInt(45); // 0 ~ 44
			int temp = rottoNum[0];
			rottoNum[0] = rottoNum[r];
			rottoNum[r] = temp;
		}
		System.out.println("섞은후"+Arrays.toString(rottoNum));
		
		for(int i=0; i<6; i++){
			System.out.print(rottoNum[i] + ", ");
		}
		
	}

}
