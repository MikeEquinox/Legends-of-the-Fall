package tmv_specialization_package;

public class MyRectangle {
	
	private int x;
	private int y;
	private int side1;
	private int side2;

	MyRectangle() {
		//this(0, 0, 5, 5);
	}
	
	MyRectangle(int x, int y, int side1, int side2) {
		this.x = x;
		this.y = y;
		this.side1 = side1;
		this.side2 = side2;
		System.out.println("Constructor rectangle: "+ x + " " + y + " " + side1 + " " + side2);
	}
	
	void draw() {
		System.out.println("Drawing rectangle");
	}
}

