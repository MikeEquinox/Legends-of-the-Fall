package tmv_construction_package;

/**
 *  @author teleginmv
 *  this example shows inheritance CONSTRUCTION
 *  overriding of ArrayList's method "clear" to overwrite elements by "10"
 *  instead of clearing
 */

import java.util.ArrayList;

public class Construction {

	//public static ArrayListN<String> myarray;

	static class ArrayListN<Object> extends ArrayList<Object> {

		@Override
		public void clear() {
			for (int i = 0; i < this.size(); i++) {
				this.set(i, (Object) "10");
			}
			return;
		}

		public static void main(String[] args) {

			ArrayListN<String> myarray = new ArrayListN<>();
			myarray.add("first element");
			myarray.add("second element");
			myarray.add("third element");
			System.out.println("Source ArrayList: " + myarray.toString());

			myarray.clear();

			System.out.println("New ArrayList: " + myarray.toString());
		}

	}
}
