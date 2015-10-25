package tmv_mylist_with_iterator_package;

/**
 *  @author teleginmv
 *  package uses Iterator in STATIC NESTED CLASS 
 */

import java.util.Iterator;

public class UseMyListInnerStaticIterator {

	public static void main(String[] args) {
		
		
		MyListInnerStaticIterator<String> list = new MyListInnerStaticIterator<String>() {{
			add("static nested class");
			add("one");
			add("two");
			add("three");
			add("four");
		}};
		
		//create instance of static nested class with outer class instance (parameter)
		MyListInnerStaticIterator.MyIterator innerclass = new MyListInnerStaticIterator.MyIterator(list);
		//iterator
		Iterator<String> it = innerclass.iterator();
		
		System.out.println("Iterator in STATIC NESTED CLASS.");
		while (it.hasNext()) {
			String item = it.next();
			System.out.println(item);
		}
	}
}

