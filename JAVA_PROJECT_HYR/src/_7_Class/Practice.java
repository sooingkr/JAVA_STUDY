package _7_Class;

class Student implements Cloneable{
	String name;
	int age;
	String partnerName;
	Student temp;
	
	Student(String name, int age){
		this.name = name;
		this.age = age;
		temp = new Student();
	}
	Student(){
		
	}
	void print(){
		System.out.println("이름 : " + this.name + " 나이 : " + this.age);
		System.out.println("파트너 이름 : " + this.partnerName + "파트너 나이 : " + temp.age);
		
	}
	void match(Student s) throws CloneNotSupportedException{
		this.partnerName = s.name;
		s.partnerName = this.name;
		
		temp = (Student) s.clone();
	}
	@Override
	protected Student clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Student)super.clone();
	}
}
public class Practice {
	
	public static void main(String[] args) throws CloneNotSupportedException {
	
		Student s1 = new Student("황영롱",28);
		Student s2 = new Student("김재현",26);
		
		s1.match(s2);
		s1.print();
		
		s2.match(s1);
		s2.print();
	
	}

}
