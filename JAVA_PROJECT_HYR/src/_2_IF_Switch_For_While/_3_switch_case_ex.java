package _2_IF_Switch_For_While;

public class _3_switch_case_ex {

	public static void main(String[] args) {

		// 100이하 90이상 수, 90미만 80이상 우, 80미만 70이상 미, 70미만 60이상 양, 나머지 가
		
		int num = 88;
		
		switch( num / 10){
		case 10:
		case 9:
			System.out.println("수");
			break;
		case 8:
			System.out.println("우");
			break;
		case 7:
			System.out.println("미");
			break;
		case 6:
			System.out.println("양");
			break;
		default:
			System.out.println("가");
			break;
		}
	}

}
