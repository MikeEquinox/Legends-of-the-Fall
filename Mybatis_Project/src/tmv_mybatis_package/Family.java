package tmv_mybatis_package;

/**
 * @author teleginmv
 * class for database Family
 * 
 */ 
 /* http://www.concretepage.com/mybatis-3/
 * mybatis-3-annotation-example-with-select-insert-update-and-delete
 * 
 * http://habrahabr.ru/post/247885/
 */

public class Family {

		private String name; 
		private int year; 
		private int height; 
		private int weight;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		} 

}
