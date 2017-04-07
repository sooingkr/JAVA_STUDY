package _7_Class;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point() {
		super();
	}

}

class Shape { // 원, 삼각형의 공통적인 내용을 부모클래스로 구현함.
	String color = "";
}

class Circle extends Shape {
	Point p;
	int r; // 반지름

	public Circle(Point p, int r, String color) {
		super();
		this.p = p;
		this.r = r;
		this.color = color;
	}

	public Circle(int x, int y, int r, String color) {
		super();
		this.p = new Point(x, y);
		this.r = r;
		this.color = color;
	}

	public void print() {
		System.out.println(this.p.x + " , " + this.p.y + " : " + this.r + " " + this.color);
	}
}

class Triangle extends Shape {

	Point p[] = new Point[3];

	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public Triangle(Point[] p) {
		super();
		this.p = p;
	}

	public Triangle(Point p1, Point p2, Point p3) {
		this.p[0] = p1;
		this.p[1] = p2;
		this.p[2] = p3;
	}

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.p[0] = new Point(x1, y1);
		this.p[1] = new Point(x2, y2);
		this.p[2] = new Point(x3, y3);
	}
}

public class _11_Extends3 {

	public static void main(String[] args) {

		Circle c1 = new Circle(new Point(3, 4), 10, "빨강");
		Circle c2 = new Circle(3, 4, 10, "빨강");
		c2.print();
		Point p[] = { new Point(1, 1), new Point(2, 2), new Point(3, 3) };
		Triangle t1 = new Triangle(p);

		Triangle t2 = new Triangle(new Point[] { new Point(1, 1), new Point(2, 2), new Point(3, 3) }); // 익명배열을
																										// 넣어서
																										// 하는
																										// 방법.

		Triangle t3 = new Triangle(new Point(1, 1), new Point(2, 2), new Point(3, 3));

		Triangle t4 = new Triangle(1, 1, 2, 2, 3, 3);
	}

}
