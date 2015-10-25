package tmv_comparator_package;

/**
 * @author teleginmv
 * package shows an example of using COMPARABLE and COMPARATOR
 * COMPARABLE: lastName
 * COMPARATOR: hobby, firstname, month
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UseKidsGarden {

	public static void main(String[] args) {
		
		List<KidsGarden> kl = new LinkedList<>();
		kl.add(KidsGarden.fillList("Маша", "Евстигнеева", 2009, 2, 2, "rythmics"));
		kl.add(KidsGarden.fillList("Настя", "Зайцева", 2009, 3, 5, "swimming"));
		kl.add(KidsGarden.fillList("Саша", "Телегина", 2009, 4, 8, "skating"));
		kl.add(KidsGarden.fillList("Маша", "Бак", 2009,4, 8, "rythmics"));
		kl.add(KidsGarden.fillList("Марина", "Олейникова", 2008, 11, 16, "rythmics"));
		kl.add(KidsGarden.fillList("Ваня", "Граховский", 2009, 1, 22, "boxing"));
		kl.add(KidsGarden.fillList("Ярослав", "Сильченко", 2010, 2, 21, "boxing"));
		kl.add(KidsGarden.fillList("Поля", "Соколова", 2009, 3, 22, "swimming"));
		
		Collections.sort(kl);
		System.out.println("COMPARABLE: lastName");
		System.out.println(kl);
		
		Collections.sort(kl, KidsGarden.MIX_COMPARATOR);
		System.out.println("COMPARATOR: hobby, firstname, month");
		System.out.println(kl);
	}

}
