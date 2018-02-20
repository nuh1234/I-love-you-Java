import java.util.Scanner;

public class Anagram {
	//basically I made a histogram
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 2 Strings and I will know if they are anagrams");
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		System.out.println(str1 + " " + str2);
		System.out.println();
		System.out.println(solution(str1, str2));		
	}
	//what kind of string? UniCode, Ascii?
	public static Boolean solution(String str1, String str2){
		if((str1.length() != str2.length()) || (str1.isEmpty() && str2.isEmpty())){
			System.out.println("Not entered");
			return false;
		}
		int[] word1 = new int[255]; // assuming I'm dealing with ascii. num of total ascii 
		int[] word2 = new int[255];

		for(int i = 0; i < str1.length(); i++ ){
			int tempNum = (int)str1.charAt(i); //getting the char value as an int
			word1[tempNum] += 1; //count the occurrence of that char
			int tempNum2 = (int)str2.charAt(i);
			word2[tempNum2] += 1;
		}
		//compare arrays
		for(int i = 0; i < word1.length; i++){
			if(word1[i] != word2[i]){
				return false;
			} else if(word1.length - 1 == i){
				return true;
			}
		}
		return false;
	}
}
