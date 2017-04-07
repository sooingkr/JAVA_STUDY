package _9_Object_Class;

public class _2_Clone_ObjectCopy {

	public static void main(String[] args) {
		CloneObject c1 = new CloneObject("황영롱");
		CloneObject c2 = null;
		try {
			
			c2 = c1.clone();
			
		} catch (CloneNotSupportedException e) {
			
		}
		c2.name = "수정";
		System.out.println(c2);
		System.out.println(c1);
		// 얕은 복사되지 않고 깊은 복사된 것을 알 수 있음.
	}

}

class CloneObject implements Cloneable{
	String name="";
	public CloneObject(String name) {
		this.name = name;
		// TODO Auto-generated constructor stub
	}
	@Override
	protected CloneObject clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (CloneObject)super.clone();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
