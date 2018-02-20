import java.util.*;
//Shoudl've used hash set
public class duplicateProblem {
	public static void main(String[] args){
		ArrayList<String> a = new ArrayList<>(Arrays.asList("the", "turtle"));
		anagramSolver("jemas", "masje");
	}


	public static void solution(ArrayList a){
		//a.add(a.get(a.size()-1)); //adds the last value to the end of the array
		String hold = "";
		String skipWord = "";
		for(int i = 0; i < a.size()-1; i++){
			a.add(a.get(i));
			a.remove(i);
			System.out.println("Doubled " + i);
		}
		System.out.println(Arrays.toString(a.toArray()));
	}
	public static void solved(ArrayList s){
		int size = s.size()-1;
		for(int i = 0; i <= size; i++){
			if(i % 2 == 0){
				s.add(s.get(0));
				s.remove(0);
			} else {
				s.add(s.get(0));
				s.add(s.get(0));
				s.remove(0);
			}
		}
		System.out.println(Arrays.toString(s.toArray()));

		/*
		considered appeneding as I found new words or maybe a method that calculated the number of extra array slots I would need depending on the length of the array. 
		I thought about different cases like an array with only two words or maybe one word. I didn't want it to break.
		I came to the conclusion that I could create a new order as went through the array, while at the same time removing the "old" words. For example 
		0 1 2 3 became  0 1 2 3 0 11 2 33. Once you have that you can just remove all of the "old "objects until you reach your set index (in this case 
		the original size of the list). The case of actually duplicating "every other word" just meant alternating between even and odd values of i. Since I'm removing as I go,
		I had to account for the left shifting by just always getting the list index at zero.    
		*/
	}
	
	public static boolean anagramSolver(String word1, String word2) 
	{
	    int[] wordArray1 = characterParser(word1);
	    int[] wordArray2 = characterParser(word2); 
	 
	    for (int i = 0; i < 26; i++)
	    {
	        if (wordArray1[i] != wordArray2[i]) 
	        {
	        	return false;   
	        }
	    }
	    return true;
	}
	 
	private static int[] characterParser (String s) 
	{ 
	    int[] alphabet = new int[26];
	 
	    for (int i = 0; i < alphabet.length; i++)
	    {
	        alphabet[i] = 0;
	    }
	 
	    for (char c : s.toCharArray()) {
	        char d = c;
	        System.out.println(d + " char");
	        alphabet[d - 'a'] = alphabet[d - 'a'] + 1; 
	        System.out.println(alphabet[d - 'a'] + " is now " + alphabet[d - 'a'] + 1);
	    }
	 
	    System.out.println(Arrays.toString(alphabet));
	    return alphabet;
	}

}
