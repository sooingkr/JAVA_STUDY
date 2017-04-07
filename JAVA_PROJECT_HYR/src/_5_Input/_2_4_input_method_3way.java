/** 
 * 		[ 	사용자의 입력을 받는 방법3 - JOptionPane		]
 * 		/*String inputStr = JOptionPane.showInputDialog("이름을 입력해 주세요");
		// 문자열로 읽어옴
		
		System.out.println("당신의 이름은 : " + inputStr);
		
		int age = Integer.parseInt(JOptionPane.showInputDialog("나이를 입력해 주세요 : "));
		
 * */
package _5_Input;

import javax.swing.JOptionPane;

public class _2_4_input_method_3way {

	public static void main(String[] args) {
		
		// 사용자 입력을 받은 값에 대한 절대값을 구해보자.
		
		int num = Integer.parseInt(JOptionPane.showInputDialog("절대값으로 바꿀 수를 입력해 주세요 : "));
		System.out.println("입력한 값은 : " + num + "이고 절대값은 : " + Math.abs(num) + "입니다.");
	
	}

}
