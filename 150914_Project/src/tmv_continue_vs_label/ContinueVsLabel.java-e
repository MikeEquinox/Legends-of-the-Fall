package tmv_continue_vs_label;

/**
 * @author teleginmv
 *method shows usage "continue" with label
 *
 * to scan rows to first negative digit, after continue scanning the next row 
 */

public class ContinueVsLabel {

	public static void main(String[] args) {
	
		
		int[][] matrix;
		final int ROWS = 3;
		final int ROW_LENGTH = 6;
		
		matrix = new int[][] { {3, 4, 0, -9, 0, 3},
					{4, 6, 0, 77, 14, 5},
					{0, 15, -2, -6, 2, -12},	
					};
		
		System.out.println("Existing matrix:");
		for (int i = 0; i < ROWS; i++) {
		    for (int j = 0; j < ROW_LENGTH; j++) {
		        System.out.print(matrix[i][j] + "\t");
		    }
		    System.out.println();
		}
		
		System.out.println();
		Negative:
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < ROW_LENGTH; j++) {
				if (matrix[i][j] >= 0)
				System.out.println("Positive number: " + matrix[i][j]);
				else { 
					System.out.println("Found negative number: " + matrix[i][j] + ". Stop scanning row №" + (i+1));
					continue Negative;
				}
			}
			System.out.println("Row " + (i+1) + " has only positive numbers.");
		}
		System.out.println(ROWS + " rows has been scanned. The end.");
	}
}
