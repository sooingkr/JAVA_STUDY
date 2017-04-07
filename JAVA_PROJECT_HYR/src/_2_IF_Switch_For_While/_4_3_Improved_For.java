/**
 * 	[	향상된 For문	]

 */
package _2_IF_Switch_For_While;

import java.util.ArrayList;

public class _4_3_Improved_For {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		for(int num : a){
			System.out.print(num + " ");
		}
	
		ArrayList<String> al = new ArrayList();
		al.add("xx");
		al.add("aa");
		al.add("cc");
		al.add("tt");
		System.out.println();
		for (String string : al) {
			System.out.print(string + " ");
		}
		
	}
	
	

}
