package tmv_exchange_database_object;

/** 
 * @author teleginmv
 * package shows using of REFLECTION 
 * from record of DATABASE creates instance of CLASS
 * from instance of CLASS creates new record in DATABASE
 */


public class UseDBManager {

		public static void main(String[] args) {

			int id = 1;

			Student t = DBManager.get(Student.class, id);

			if (t == null) {
				System.out.println("no such student with id " + id);
			} else {
				System.out.println(t.name);
			}

			t = DBManager2.get(Student.class, id);

			if (t == null) {
				System.out.println("no such student with id " + id);
			} else {
				System.out.println(t.name);
			}
			
			Student t2 = new Student();
			t2.setName("Rolly");
			t2.setId("5");
			t2.setStip("1800");
			//DBManager.save(Student.class, t2);
			
			Student t3 = new Student();
			t3.setName("Molly");
			t3.setId("6");
			t3.setStip("1550");
			//DBManager.save(Student.class, t3);
	
		}

	}
