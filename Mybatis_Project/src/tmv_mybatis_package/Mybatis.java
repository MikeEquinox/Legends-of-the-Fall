package tmv_mybatis_package;

/* MyBatis configuration xml to configure database environment
and mapper interface. In our example we are using MySQL. 
*/

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatis {
	
	

	public static void main(String[] args) {

		
		doWork();
		
	}

	private static void doWork() {
		
			FamilyDAO familyDAO1 = new FamilyDAO();	
			
			Family family = familyDAO1.getName("Olly");	
			System.out.println(family.getName());
			System.out.println(family.getYear());
			System.out.println(family.getHeight());
			System.out.println(family.getWeight());
			
			Family family1 = new Family();
			
			family1.setName("Dolly");
			family1.setYear(2003);
			family1.setHeight(145);
			family1.setWeight(34);
			familyDAO1.insertFamily(family1);
			System.out.println("Added Family Dolly");
		
			Family family2 = new Family();
			
			family2.setName("Dolly");
			family2.setYear(2005);
			family2.setHeight(145);
			family2.setWeight(34);
			familyDAO1.updateFamily(family2);
			System.out.println("Updated Family Dolly");
			
			familyDAO1.deleteFamily("Dolly");
			System.out.println("Deleted Family Dolly");
			
			List<Family> fam = familyDAO1.getFamily();
			for (Family family4 : fam) {
				System.out.println(family4.getName());
				System.out.println(family4.getYear());
				System.out.println(family4.getHeight());
				System.out.println(family4.getWeight());
			}
			
//			for(int i = 0; i < fam.size(); i++) {
//				System.out.println(fam.get(i).getName());
//				System.out.println(fam.get(i).getYear());
//				System.out.println(fam.get(i).getHeight());
//				System.out.println(fam.get(i).getWeight());
//			}

	}
	
}