import java.util.*;
import java.util.Map.Entry;
public class Exercise21_09 {
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

			List<Map.Entry<String, Integer>> mapAsList = new ArrayList<>(map.entrySet());
			Collections.sort(mapAsList, new WordOcc());
			for(Map.Entry<String, Integer> e : mapAsList) {
				System.out.println(e.getKey() + ": " + e.getValue());
			}
		}
	}
	class WordOcc implements Comparator<Map.Entry<String, Integer>>{

		@Override
		public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
			if(arg0.getValue() < arg1.getValue()) {
				return -1;
			} else if(arg0.getValue() > arg1.getValue()) {
				return 1;
			}
			return 0;
		}
	}	