package tmv_restriction_package;

/**
 *  @author teleginmv
 *  this example shows inheritance RESTRICTION
 *  overriding of ArrayList's method "remove"
 */

import java.util.ArrayList;

public class Restriction {

	static class ArrayListN<Object> extends ArrayList<Object> {

		@Override
		public Object remove(int index) {
			System.out.println("Restriction to delete any element from ArrayList.");
			System.out.println("Operation cancelled!");
			return (Object) this;
		}

		public static void main(String[] args) {

			ArrayListN<String> array = new ArrayListN<>();
			array.add("first element");
			array.add("second element");
			array.add("third element");
			System.out.println("Source ArrayList: " + array.toString());

			array.remove(1);

			System.out.println("New ArrayList: " + array.toString());
		}

	}
}
