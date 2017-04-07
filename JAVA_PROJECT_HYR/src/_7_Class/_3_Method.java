package _7_Class;

public class _3_Method {

	static int sumA(int num){
		return (num+10);
	}
	static int sum(int a, int b){
		return (a+b);
	}
	
	static int sub(int a, int b){
		return (a-b);
	}
	static int mul(int a, int b){
		return (a*b);
	}
	static double div(double a, double b){
		return (a/b);
	}
	static int mod(int a, int b){
		return (a%b);
	}
	static double abs(double a){
		return Math.abs(a);
	}
	static int max(int num1, int num2){
		int max = 0;
		if ( num1 < num2 ){
			max = num2;
		}else if( num1 > num2 ){
			max = num1;
		}else{
			max = num1;
		}
		return max;
	}
	static int min(int num1, int num2){
		int min = 0;
		if ( num1 < num2 ){
			min = num1;
		}else if( num1 > num2 ){
			min = num2;
		}else{
			min = num1;
		}
		return min;
	}
	
	static double avg(int num1, int num2){
		int result = (num1 + num2) / 2;
		return result;
	}
	
	static double pow(double num1, double num2){
		return Math.pow(num1, num2);
	}
	public static void main(String[] args) {
		int n = sumA(4); // 14
		System.out.println(sumA(3));
		System.out.println(sum(7,3));
		System.out.println(sub(7,3));
		System.out.println(mul(7,3));
		System.out.println(div(7,3));
		System.out.println(mod(7,3));
		System.out.println(abs(-3));
		
		System.out.println(max(3,7));
		System.out.println(min(3,7));
		System.out.println(avg(3,7));
		System.out.println(pow(2,7));
	}
	

}
