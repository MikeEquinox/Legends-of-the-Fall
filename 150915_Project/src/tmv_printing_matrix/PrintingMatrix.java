package tmv_printing_matrix;

/**
 * @author teleginmv
 * method implements matrix printing
 */

public class PrintingMatrix {

	public static void main(String[] args) {
		
		int[][] matrix;
		final int ROWS=20;
		final int COLUMNS = 10;
		matrix = new int[ROWS][COLUMNS];
		
		// Fill matrix with zero values
		for(int i=0; i< ROWS; i++) {
			for(int j=0; j< COLUMNS; j++) {
				matrix[i][j] = 0;
			}
		}
		
		// Fill matrix with "1" values
		int bubble = 0; //bias
		for(int i=0; i< ROWS; i++, bubble++) {
			matrix[i][bubble] = 1;
			matrix[i][COLUMNS - 1 - bubble] = 1;
			if(bubble == COLUMNS-1) bubble = 0; //reset bias
		}
		
		// Printing created matrix
		System.out.println("Created matrix:");
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				 System.out.print(matrix[i][j] + "   ");
			}
		System.out.println();
		}  
				 
}
}
