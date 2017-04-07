package practicefolder;

public class Person implements Comparable<Person>{
	private String name = "";
	private int age;
	private int math;
	private int eng;
	private int kor;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age ){
		this(name, age, 0,0,0);
	}
	public Person(String name, int age, int math, int eng, int kor) {
		super();
		this.name = name;
		this.age = age;
		this.math = math;
		this.eng = eng;
		this.kor = kor;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getMath() {
		return math;
	}
	public int getEng() {
		return eng;
	}
	public int getKor() {
		return kor;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		double avgThis =( this.getMath() + this.getKor() + this.getEng() ) / 3.0;
		double avgCompare = ( o.getEng() + o.getKor() + o.getMath() ) / 3.0;
		return (int)(avgCompare - avgThis);
	}
}
