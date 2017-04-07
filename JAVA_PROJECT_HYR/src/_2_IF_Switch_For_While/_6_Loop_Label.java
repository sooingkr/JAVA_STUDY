package _2_IF_Switch_For_While;

public class _6_Loop_Label {

	public static void main(String[] args) {
		
		int count = 1;
		
exit:	while(true){
			if(count == 1){
				break exit; // label 설정 부분으로 탈출함(C언어의 Go To 문과 같음).
			}
		}
	}

}
