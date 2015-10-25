package tmv_extension_package;

/**
 *  @author teleginmv
 *  this example shows inheritance EXTENSION
 *  adding of ArrayList's method "add_dup" to duplicate values
 */

import java.util.ArrayList;

public class Extension {

	static class ArrayListN<Object> extends ArrayList<Object> {

		public void add_dup(String s) {
			this.add((Object) s);
			this.add((Object) s);
			return;
		}
		
		public static void main(String[] args) {

			ArrayListN<String> myarray = new ArrayListN();
			myarray.add("first element");
			myarray.add("second element");
			myarray.add("third element");
			System.out.println("Source ArrayList: " + myarray.toString());

			myarray.add_dup("forth element");

			System.out.println("New ArrayList: " + myarray.toString());

		}
	}
}
