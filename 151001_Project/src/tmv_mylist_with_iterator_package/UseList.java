package tmv_mylist_with_iterator_package;

/**
 *  @author teleginmv
 *  package uses Iterator in OUTER CLASS
 */

import java.util.Iterator;

public class UseList {

	public static void main(String[] args) {
	
		MyList<String> list = new MyList<String>() {{
			add("one");
			add("two");
			add("three");
			add("four");
		}};
		
//		list.add("One");
//		list.add("Two");
//		list.add("Three");
//		list.add("Four");
		
//		for (String item : list) {
//			System.out.println(item);
//		}
		
		
		Iterator<String> it = list.iterator();
		System.out.println("Iterator in method of outer class.");
		
		while (it.hasNext()) {
			String item = it.next();
			System.out.println(item);
		}
		
		Iterator<String> it1 = list.iterator();
		System.out.println(it1.next());
		System.out.println(it1.next());
		
		Iterator<String> it2 = list.iterator();

		System.out.println(it1.next());
		System.out.println(it1.next());
	}
	
}

