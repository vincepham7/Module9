import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

//Vincent Pham 1/30/2023

public class wordCount {

	public static void main(String[] args) throws IOException {
		// This is used to read the file
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader("C:\\Users\\Vince\\Desktop\\School\\Software Development I\\The Raven.txt"));

		// Creating map to store words and word frequencies of all words in the file
		Map<String, Integer> word_count = new HashMap<>();

		String line;

		// Creating while loop (also add throw IOException)
		while ((line = bufferedReader.readLine()) != null) {

			// splitting line by use regular expression
			String[] words = line.split("[\\s.;,?:!()\"]+");

			// Reads each word repeatedly
			for (String word : words) {

				word = word.trim();

				if (word.length() > 0) {

					if (word_count.containsKey(word)) {
						word_count.put(word, word_count.get(word) + 1);
					}

					else {
						word_count.put(word, 1);
					}
				}

			}

		}

		// Sort words to highest frequency
		Map<String, Integer> sortWordMap = word_count.entrySet().stream()
				.sorted(Collections.reverseOrder(Entry.comparingByValue()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		// printing word and frequencies of all words
		System.out.printf("%-20s%15s\n", "WORD", "TIMES OCCURRED");

		System.out.printf("%-20s%15s\n", "", "");

		for (Map.Entry<String, Integer> entry : sortWordMap.entrySet()) {

			System.out.printf("%-20s%10s\n", entry.getKey(), entry.getValue());
		}

		bufferedReader.close();

	}
}