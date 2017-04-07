package _2_IF_Switch_For_While;

public class _5_Quize2 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1;; i++) {
			if (sum >= 100) {
				if ((i - 1) % 2 == 0) {
					System.out.println("마지막 더해진 수 : " + (i - 1) * (-1) + " 누적 값 : " + sum);
					break;
				} else {
					System.out.println("마지막 더해진 수 : " + (i - 1) + " 누적 값 : " + sum);
					break;
				}
			}
			if (i % 2 == 0) {
				sum -= i;
			} else {
				sum += i;
			}
		}
	}

}
