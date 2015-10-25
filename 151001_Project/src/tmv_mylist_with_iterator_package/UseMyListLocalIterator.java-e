package tmv_mylist_with_iterator_package;

/**
 *  @author teleginmv
 *  package uses Iterator in LOCAL CLASS in method localIterator()
 */

import java.util.Iterator;

import tmv_mylist_with_iterator_package.MyListInnerIterator.MyIterator;

public class UseMyListLocalIterator {

	public static void main(String[] args) {
		
		MyListLocalIterator<String> list = new MyListLocalIterator<String>() {{
			add("local class");
			add("one");
			add("two");
			add("three");
			add("four");
		}};
		
		// call method returning iterator
		Iterator<String> it = list.localIterator();
		
		System.out.println("Iterator in LOCAL CLASS.");
		while (it.hasNext()) {
			Object item = it.next();
			System.out.println(item);
		}
	}
}
