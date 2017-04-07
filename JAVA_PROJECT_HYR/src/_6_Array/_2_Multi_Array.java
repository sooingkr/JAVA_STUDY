/** 
 * 		[	다차원 배열	]
 * */
package _6_Array;

class tempArray{
	
}
public class _2_Multi_Array {

	public static void main(String[] args) {
		int[][] arr = new int[][]{ {1,2,3},{4,5,6},{7,8,9,10,11,12} };
		for(int i=0; i<arr.length; i++){
			for(int j=0; j< arr[i].length; j++){
				System.out.print( arr[i][j] + " ");
			}
		}
		////////////////////////////////////////////////////////////////
		
		String[][] strArr = new String[2][];
		// 이건 참조형 String 타입 데이터를 담을 수 있는 공간을 형성한 것에 불과함! 각 내부에 데이터 형성 필요.
		
		strArr[0] = new String[2]; // 각 row에 공간 할당.
		strArr[1] = new String[1];
		
		
		// 할당된 공간들에 실재 담을 String 객체들 형성.(***)
		strArr[0][1] = new String("String Object");
		strArr[0][0] = "Bye Bye";
		strArr[1][0] = "new String";
		
		for(int i=0; i<strArr.length; i++){
			for(int j=0; j<strArr[i].length; j++){
				System.out.print( strArr[i][j] + " ");
			}
		}
		
		tempArray[] ObjectArr = new tempArray[5];
		// tempArray 데이터 타입을 담을 수 있는 공간을 형성한 것
		// 따라서, 각 공간에 데이터 담아주어야 함.
		
		ObjectArr[0] = new tempArray();
		ObjectArr[1] = new tempArray();
		ObjectArr[2] = new tempArray();
		ObjectArr[3] = new tempArray();
		ObjectArr[4] = new tempArray();
		
	}

}
