package tmv_genome_package;

/**
 * @author teleginmv
 * this package counts equal char sequences and position in a genome 
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Genome {

	public static int GENOME_SIZE = 3000;
	public static char[] letters = { 'A', 'C', 'G', 'T' };

	char[] sequence;

	public void generateSequence() {
		Random random = new Random();
		sequence = new char[GENOME_SIZE];

		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = letters[random.nextInt(letters.length)];
		}

	}

	//Sort HashMap by value
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map)
	{
    List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
    
    
    Collections.sort( list, new Comparator<Map.Entry<K, V>>()
    {
        @Override
        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
        {
            return (o1.getValue()).compareTo( o2.getValue() );
        }
    } );

    
    Map<K, V> result = new LinkedHashMap<>();
    for (Map.Entry<K, V> entry : list)
    {
        result.put(entry.getKey(), entry.getValue());
    }
    return result;
}
	
	
	public void searchDuplicatesBruteForce(char[] data, int M) {
		for (int i = 0; i < data.length - M + 1; i++) {
			for (int j = i+1; j < data.length - M + 1; j++) {
//				System.out.println(data[i] + "," + data[j]);
				int k = i;
				int m = j;
				int n = 0;
				while (data[k++] == data[m++] && ++n < M) {
				}
				if (n == M) {
					System.out.println("Match at " + i + " and " + j);
				}
			}
		}
	}
	
	public void searchDuplicatesSorting(char[] data, int M) {
//		List<String, Integer> words = new LinkedList<>();
		Map<Integer, String> words = new HashMap<>();
		
		//Filling genome
		System.out.println("Start filling genome.");
		for (int i = 0; i < data.length - M + 1; i++) {
			String word = new String(data, i, M);
			words.put(i, word);
//			words.add(word);
		}

		//Printing genome
		System.out.println("Printing genome.");
		int i = 0;
		for (Map.Entry<Integer, String> entry : words.entrySet()) {
			System.out.println(i + " Key : " + entry.getKey() + " Value : " + entry.getValue());
			i++;
		}
		
		//Sorting genome
		Map<Integer, String> wordsSorted = new LinkedHashMap<>();
		wordsSorted = sortByValue(words);
		
		//Printing sorted genome
		System.out.println("Printing sorted genome.");
		i = 0;
		for (Map.Entry<Integer, String> entry : wordsSorted.entrySet()) {
			System.out.println(i + " Key : " + entry.getKey() + " Value : " + entry.getValue());
			i++;
		}
		
		//Searching duplicates
        System.out.println("Searching duplicates.");
        Iterator<Map.Entry<Integer, String>> entries = wordsSorted.entrySet().iterator();

		String last = "";		//sorted value
		Integer counter1 = 0;	//original key, not sorted
		Integer counter2 = 0;	//original key, not sorted
        while (entries.hasNext()) {         
        	Map.Entry<Integer, String> entry = entries.next();
        	String word = entry.getValue();
        	counter1 = entry.getKey();
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if (word.equals(last)) {
				System.out.println("Match!" + counter1 + " and " + counter2);
			}
            last = word;
            counter2 = counter1;
        }
		
//		Iterator<String> it = words.iterator();
//		String last = "";
//		while (it.hasNext()) {
//			String word = it.next();
//			if (word.equals(last)) {
//				System.out.println("Match!");
//			}
//			last = word;
//		}	
	}

	public static void main(String[] args) {

		Genome genome = new Genome();
		
//		Simple genome
//		genome.searchDuplicatesBruteForce(new char[] { 'A', 'A', 'C', 'T', 'A',
//				'A', 'C' }, 3);
		
		System.out.println("Generating genome.");
		genome.generateSequence();
//		genome.searchDuplicatesBruteForce(genome.sequence, 10);

		System.out.println("Searching equal sequences.");
		genome.searchDuplicatesSorting(genome.sequence, 10);
		
		System.out.println("Ending program.");		
	}

}
