package tmv_anonymous_class_package;

/**
 * @author teleginmv
 * package shows transformation from anonymous class inside Dog class
 * to Dog class with external BadMood and GoodMood classes  
 */

//added implements BrainState
//added public BrainState brainState;
public class Dog2 implements BrainState {
	
	public static BrainState brainState;
	
	Dog2() {
		brainState = new BadMood();
	}
	
	public void feed() {
		System.out.println("--> feed dog");
		brainState.feed();
	}

	public void stroke() {
		System.out.println("--> stroke dog");
		brainState.stroke();
	}
	
	// private body methods
	//changed from private to public static
	public static void bite() {
		System.out.println("bites");
	}

	public static void bark() {
		System.out.println("barks");
	}

	public static void eat() {
		System.out.println("eats");
	}

	public static void wag() {
		System.out.println("wags");
	}


}
