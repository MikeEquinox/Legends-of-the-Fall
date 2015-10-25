package tmv_specialization_package;

public class MySquare extends MyRectangle {
	
	private int x;
	private int y;
	private int side;

	MySquare(int x, int y, int side) {
		this.x = x;
		this.y = y;
		this.side = side;
		System.out.println("Constructor square: "+ x + " " + y + " " + side);
	}
	
	void draw() {
		System.out.println("Drawing square");
	}
}
