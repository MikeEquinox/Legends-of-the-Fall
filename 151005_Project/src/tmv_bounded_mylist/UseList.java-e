package tmv_bounded_mylist;

/**
 *  @author teleginmv
 *  package uses Iterator in OUTER CLASS
 */

import java.util.Iterator;

public class UseList {

	public static void main(String[] args) {
	
		String tmp = null;
		MyList<String> list1 = new MyList<String>(5);
		MyList<String> list2 = new MyList<String>(5);
		try {
				list1.add("one");
				list1.add("two");
				list1.add("three");
				list1.add("four");
				//list1.add("five");
//				list.add("six");
		} catch (FullListException e) {
			//e.printStackTrace();
		}
		
		try {
			tmp = list1.read();
		} catch (EmptyListException e) {
		}
		System.out.println("Reading last element: " + tmp);
		
		try {
			list1.add("six");
			list1.add("seven");
		} catch (FullListException e) {
		}
		
		
		Iterator<String> it1 = list1.iterator();
		System.out.println("Iterator1 is running...");
		
		while (it1.hasNext()) {
			String item = it1.next();
			System.out.print(item + " ");
		}
		System.out.println();
		
		try {
			System.out.println("Reading empty list...");
			list2.read();
		} catch (EmptyListException e) {
			//e1.printStackTrace();
		}
		
		Iterator<String> it2 = list2.iterator();
		System.out.println("Iterator2 is running...");
		
		while (it2.hasNext()) {
			String item = it2.next();
			System.out.println(item);
		}
	}
	
}

