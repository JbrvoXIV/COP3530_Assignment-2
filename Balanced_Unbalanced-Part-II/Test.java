import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Test {
    
	public static final String INPUT = System.getProperty("user.dir") + "/input/";
    public static final String OUTPUT = System.getProperty("user.dir") + "/output/";

    public static void main(String[] args) throws FileNotFoundException {

		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		long startTime;
		long totalTime = 0;

		for(int i = 1; i <= 77; i++) {
			Scanner scnr = new Scanner(new File(INPUT + i + ".okpuncs"));
			while(scnr.hasNext()) {
				String word = scnr.next();
				startTime = System.nanoTime();

				if(!map.containsKey(word)) {
					map.put(word, 0);
				}
				map.put(word, 1 + map.get(word));
				
				totalTime += (System.nanoTime() - startTime);
			}
		}

		PrintWriter out = new PrintWriter(OUTPUT + "frequencies.txt");
		startTime = System.nanoTime();
		Set<String> allWords = map.keySet();
		totalTime += (System.nanoTime() - startTime);

		for(String word: allWords) {
			startTime = System.nanoTime();
			int frequency = map.get(word);
			totalTime += (System.nanoTime() - startTime);
			out.printf("%s\t%d\n", word, frequency);
			out.flush();
		}
		out.close();
		System.out.printf("TreeMap: %.3f ms\n", totalTime/1e6);

		/******************************************************/

		UnbalancedTreeMap map2 = new UnbalancedTreeMap();
		long startTime2;
		long totalTime2 = 0;

		for(int i = 1; i <= 77; i++) {
			Scanner scn = new Scanner(new File(INPUT + i + ".okpuncs"));
			while(scn.hasNext()) {
				String word = scn.next();
				startTime2 = System.nanoTime();

				if(map2.get(word) == 0) {
					map2.put(word, 0);
				}
				map2.put(word, 1 + map2.get(word));

				totalTime2 += (System.nanoTime() - startTime2);
			}
			scn.close();
		}

		PrintWriter out2 = new PrintWriter(OUTPUT + "frequencies.txt");
		startTime2 = System.nanoTime();
		String[] allWords2 = map2.keySet();
		totalTime2 += (System.nanoTime() - startTime2);

		for(String word: allWords2) {
			startTime2 = System.nanoTime();
			int frequency = map2.get(word);
			totalTime2 += (System.nanoTime() - startTime2);
			out2.printf("%s\t%d\n", word, frequency);
			out2.flush();
		}
		out2.close();
		System.out.printf("Unbalanced Tree Map: %.3f ms\n", totalTime2/1e6);
    }
}
