package tmv_threads_matrix;

import java.util.Random;

/**
 * @author teleginmv
 * package shows multithreading
 * to generate a matrix and to compute this matrix
 */

public class HomeWork {

	public static void main(String[] args) {
		
		long start, start1, start2;
		long stop, stop1, stop2;
		double[][] matrix;
	
		System.out.println("starting program");
		
		System.out.println("generating matrix WITHOUT THREADS");
		start1 = System.nanoTime();
		matrix = generateOrdinary();
		stop1 = System.nanoTime();
		System.out.println("elapsed generating matrix time= " + (stop1 - start1) + " nanoseconds");		
		
		System.out.println("computing matrix");
		start = System.nanoTime();
		process(matrix);
		stop = System.nanoTime();
		System.out.println("elapsed computing time= " + (stop - start) + " nanoseconds");
		
		System.out.println("generating matrix WITH THREADS");
		start2 = System.nanoTime();
		matrix = generate();
		stop2 = System.nanoTime();
		System.out.println("elapsed generating matrix time= " + (stop2 - start2) + " nanoseconds");		
		
		System.out.println("computing matrix");
		start = System.nanoTime();
		process(matrix);
		stop = System.nanoTime();
		System.out.println("elapsed computing time= " + (stop - start) + " nanoseconds");
		
		double index1 = stop1 - start1;
		double index2 = stop2 - start2;
		
		System.out.println("generating matrix WITH THREADS is " + index1/index2 + " times faster");
		
		System.out.println("ending program");
		System.out.println("committing release");
	}

	
	private static void process(double[][] matrix) {
		
		Thread[] threads = new Thread[matrix.length];
		
		for (int i = 0; i < matrix.length; i++) {
			final double[] row = matrix[i];
			threads[i] = new Thread() {
				@Override
				public void run() {
					processRow(row);
				};
			};
			threads[i].start();
		}
		
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void processRow(double[] ds) {
		for (int i = 0; i < ds.length; i++) {
			Math.pow(ds[i], ds[i]);
		}
	}

	
	private static double[][] generateOrdinary() {
		
		Random random = new Random();
		final int MATRIX_COLUMNS = 10_000_000;
		final int MATRIX_ROWS = 10;
		double[][] matrix = new double[MATRIX_ROWS][MATRIX_COLUMNS];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextDouble();
			}
		}
		return matrix;
	}
	
	
	private static double[][] generate() {
		
		final int MATRIX_COLUMNS = 10_000_000;
		final int MATRIX_ROWS = 10;
		double[][] matrix = new double[MATRIX_ROWS][MATRIX_COLUMNS];
		
		Thread[] threads = new Thread[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			final double[] row = matrix[i];
			threads[i] = new Thread() {
				@Override
				public void run() {
					generateRow(row);
				};
			};
			threads[i].start();
		}
		return matrix;
	}
	
	
	private static void generateRow(double[] ds) {
		Random random = new Random();
		for (int j = 0; j < ds.length; j++) {
			ds[j] = random.nextDouble();
		}
	}
	
}
