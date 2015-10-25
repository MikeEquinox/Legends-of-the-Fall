package tmv_sort;

/**
 * @author teleginmv
 * method implements bubble sorting of existing fixed matrix[3][5]
 */

public class Sort {

	public static void main(String[] args) {
	
		// Matrix init
		int[][] matrix = { {11, -2, 7, 5, -3},
							{14, 6, -4, 12, 3},
							{3, -6, 7, 2, -9} 
						};
		final int ROW_LENGTH = 5;	// Fixed row length
		final int ROWS = 3;			// Fixed rows
		
		// Printing existing matrix
		System.out.println("Existing matrix:");
		for (int i = 0; i < ROWS; i++) {
		    for (int j = 0; j < ROW_LENGTH; j++) {
		        System.out.print(matrix[i][j] + "\t");
		    }
		    System.out.println();
		}  
		 
		// Bubble sorting
		int swaplet;
		for(int i = 0; i < ROWS; i++) {
			for (int row = 0; row < ROW_LENGTH-1; row++) {
				for (int j = 0; j < ROW_LENGTH - row - 1; j++) {
					if(matrix[i][j]>matrix[i][j+1]) {
						swaplet = matrix[i][j+1];
						matrix[i][j+1] = matrix[i][j];
						matrix[i][j] = swaplet;
					}
				}
			}
		}  
		    
		// Printing sorted matrix    
		    System.out.println("Sorted matrix:");
		    for (int i = 0; i < ROWS; i++) {
			    for (int j = 0; j < ROW_LENGTH; j++) {
			    	System.out.print(matrix[i][j] + "\t");
			    }
			    System.out.println();
		    }

		    
	}	
}
