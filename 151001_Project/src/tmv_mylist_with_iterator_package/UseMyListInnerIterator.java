package tmv_mylist_with_iterator_package;

/**
 *  @author teleginmv
 *  package uses Iterator in NON STATIC INNER CLASS 
 */

import java.util.Iterator;

public class UseMyListInnerIterator {

	public static void main(String[] args) {
		
		MyListInnerIterator<String> list = new MyListInnerIterator<String>() {{
			add("non static inner class");
			add("one");
			add("two");
			add("three");
			add("four");
		}};
		//create instance of inner class
		MyListInnerIterator.MyIterator innerclass = list.new MyIterator();
		//iterator
		Iterator<String> it = innerclass.iterator();
		
		System.out.println("Iterator in NON STATIC INNER CLASS.");
		while (it.hasNext()) {
			String item = it.next();
			System.out.println(item);
		}
	}
}
