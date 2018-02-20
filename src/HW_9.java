//I had to be creative with my use of ram. I ended up writing all of the data to a file so it was no longer
//in memory. I then read each string as I go, this results in my program not crashing.
//26 seems like the number with the least amount of collisions at only 12

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
public class HW_9 {

	public static void main(String[] args) {
		saveStrings(generateStrings(8));  //Only called once when first building the project
		long startTime = System.currentTimeMillis();
		for(int i = 10; i <= 45; i++) {
			System.out.println("B = " + i + " Collsions = " +  countCollisionsFromFile(i));
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Done in: " + (endTime - startTime)/1000 + " seconds");
	}
	
	public static int polyHash(String s, int b) {
		int y = 0;
		int k = s.length() -1;
		while(k >= 0) {
			y = s.charAt(k) + b * y;
			k -= 1;
		}
		return y;
				
	}
	public static int countCollisionsFromFile(int b) {
	 	File f  = new File("strings.txt");
		HashSet<Integer> hashCode = new HashSet<>();
		int count = 0;
    	try {
			Scanner read = new Scanner(f);
			while(read.hasNext()) {
				hashCode.add(polyHash(read.next(),b));
				count++;
			}
			read.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	f = null;
    	return count - hashCode.size();
	}
	
	//Not used, I just use the method above instead
	public static int countCollisions(String[] data, int b) {
		HashSet<Integer> hashCode = new HashSet<>();
		
		for(String s : data) {
			hashCode.add(polyHash(s,b));
		}
		return data.length - hashCode.size();
	}
	
    public static String[] generateStrings(int length) {
        ArrayList<String> data = new ArrayList<>();
        makeString(data, "", 0, length);
        String[] result = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }
        return result;
    }

    public static void makeString(ArrayList<String> data, String str, int pos, int length) {

        char[] charset = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        if (length == 0) {
            data.add(str);
        } else {
            for (int i = pos; i < charset.length; i++) {
                makeString(data, str + charset[i], i, length - 1);
            }
        }
    }
    
    public static void saveStrings(String[] data) {
    	File f  = new File("strings.txt");
    	FileWriter writer = null;
    	try {
			writer = new FileWriter(f);
			for(String s : data) {
				writer.write(s + " ");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	f = null;
    	writer = null;
    }


}

