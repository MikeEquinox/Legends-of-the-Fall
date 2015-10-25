package tmv_comparator_package;

import java.util.Comparator;
import java.util.Date;


public class KidsGarden implements Comparable<KidsGarden> {

	//COMPARATOR
	//Use hobby, firstname, month
	static class MixComparator implements Comparator<KidsGarden> {

		@Override
		public int compare(KidsGarden other1, KidsGarden other2) {
		if(other1.hobby == other2.hobby)
			if(other1.firstName == other2.firstName)
				if(other1.date.month == other2.date.month)
					return 0;
				else return other1.date.month - other2.date.month;
			else return other1.firstName.compareTo(other2.firstName);
		else return other1.hobby.compareTo(other2.hobby);
		
		}
		
	}
	
	String firstName;
	String lastName;
	String hobby;

	Date date;
	
	public static final Comparator<KidsGarden> MIX_COMPARATOR = new MixComparator();
	
	//private constructor
	private KidsGarden() {};

	//fabric
	public static KidsGarden fillList(String firstName, String lastName,
			int year, int month, int day, String hobby) {
		
		KidsGarden kg = new KidsGarden();
		kg.firstName = firstName;
		kg.lastName = lastName;
		kg.date = new Date();
		kg.date.year = year;
		kg.date.month = month;
		kg.date.day = day;
		kg.hobby = hobby;
		
		return kg;
	}
	private static class Date {
		int year;
		int month;
		int day;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + ", " + date.year + "-" + date.month + "-" + date.day + ", " + hobby;
	}
	
	//COMPARABLE
	//Use lastName
	@Override
	public int compareTo(KidsGarden other) {
		
		return this.lastName.compareTo(other.lastName);
	}

	
	
}
