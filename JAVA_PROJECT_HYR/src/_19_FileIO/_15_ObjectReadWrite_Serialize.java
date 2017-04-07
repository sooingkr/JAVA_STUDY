/**
 * 		[	객체 읽기/쓰기	 ] : Serializeable 구현해주어야 함!
 * 			
 * 		ObjectInputStream : 역직렬화 - 연속적인 byte형식의 데이터에서 객체로 변경하는 작업.
 * 		ObjectOutputStream : 직렬화 - 객체를 연속적인 byte형식의 데이터로 변경하는 작업.
 * 
 * 		소켓 통신시 객체로해서 주고받을 수 있음.
 * 
 * 			-> 직렬화 되는 데이터 : 전역변수
 * 				transient를 붙이면 해당 변수는 직렬화 작업에서 제외됨.
 * 			
 * 				생성자, 메서드도 직렬화에서 제외됨
 * 				
 */
package _19_FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class _15_ObjectReadWrite_Serialize {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Person p1 = new Person("황영롱",28,"서울시");
		Person p2 = new Person("황영롱2",26,"서울시 용산구");
		
		ObjectOutputStream oo = null;
		FileOutputStream f = new FileOutputStream("C:\\DEV\\kosta\\two.dat");
		oo = new ObjectOutputStream(f);
		
		oo.writeObject(p1);
		oo.writeObject(p2);
		
		oo.close();
		
		ObjectInputStream oi = null;
		FileInputStream fi = new FileInputStream("C:\\DEV\\kosta\\two.dat");
		oi = new ObjectInputStream(fi);
		
		Person temp = (Person) oi.readObject();
		Person temp2 = (Person) oi.readObject();
	
		System.out.println(temp.name + " : " + temp.age + " : " + temp.address);
		System.out.println(temp2.name + " : " + temp2.age + " : " + temp2.address);
		temp.show();
		temp2.show();
		
		oi.close();
	}

}


class Person implements Serializable{ // Serialize 구현해주어야 함 -> 객체 주고받을 때는 byte를 객체로 객체를 byte로 변환이 필요하기 때문에
	String name="";
	int age;
	String address="";
	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public void show(){
		System.out.println(this.name  + "출력");
	}
	
}