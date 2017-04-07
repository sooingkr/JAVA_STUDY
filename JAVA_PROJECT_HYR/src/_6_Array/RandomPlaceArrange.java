/** 
 * 		[	랜덤 자리 배치		]
 * 
 * */
package _6_Array;

import java.util.Random;

public class RandomPlaceArrange {

	public static void main(String[] args) {
		
		String name[] = {
				"한혜연","황영롱","강승원","김민주",
				"김재현","김주연","김지혜","김지혜","김찬현",
				"박덕환","박재우","반상수","서현우","송승윤",
				"송아름","윤주희","이대형","이병호","이영민",
				"이윤지","이한나","정다린","정대희","정동철",
				"정윤오","정재환","정진근","정홍의","조보람",
				"지윤식","최현식","김영관","김용래",
		};
		
		Random rand = new Random();
		
		
		for(int i=0; i<name.length * 2; i++){
			
			int r = rand.nextInt(31) + 2; // 2 ~ 32
			String temp = name[2];
			name[2] = name[r];
			name[r] = temp;
		}
		
		for(int i=0; i<name.length*2; i++){
			int r = rand.nextInt(15); // 0 ~ 14
			String temp = name[0];
			name[0] = name[r];
			name[r] = temp;
		}
		
		for(int i=0; i<name.length; i+=5){
			
			if(i < name.length - 5){
				System.out.print( name[i] + "," + name[i+1] + "," + name[i+2] + "," + "    " + name[i+3] + "," + name[i+4]);
				System.out.println();
			}else{
				System.out.println(name[i] + "," + name[i+1] + "," + name[i+2] );
			}

		}
	}

}
