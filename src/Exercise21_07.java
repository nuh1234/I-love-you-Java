//Nuh Mohamud
//Passed Exercise check tool, figured out that the compareTo function I made needed to be slightly modified to support alphabetical order 
import java.util.*;
import java.util.Map.Entry;
public class Exercise21_07 {

	public static void main(String[] args) {
		//This top portion of my code is from the book
		String text = "Good morning. Have a good class. " + "Have a good visit. Have fun!";

		Map<String, Integer> map = new TreeMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();

			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		List<WordOccurrence> list = new ArrayList<>();
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for (Map.Entry<String, Integer> entry: entrySet) {
			list.add(new WordOccurrence(entry.getKey(), entry.getValue()));
		}
		Collections.sort(list);
		for(WordOccurrence w : list) {
			System.out.println(w.toString());
		}
	}
}


class WordOccurrence implements Comparable<WordOccurrence>{
	private String word = "";
	private int count = 0;

	public WordOccurrence(String word, int count) {
		this.word = word;
		this.count = count;
	}

	@Override
	public int compareTo(WordOccurrence o) {
		if(this.count < o.count) {
			return -1;
		}else if(this.count > o.count) {
			return 1;
		}
		return this.word.compareTo(o.word); //If both words have the same count then I return which string comes first
	}

	@Override
	public String toString() {
		return this.word + ": " + this.count;
	}
}



