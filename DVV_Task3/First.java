import java.util.Scanner;

public class First {
	public static void main(String[] args) {
		String sentence;
		String[] words;
		int lettersCount = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("\nEnter sentence of five words: ");
		
		while(true) {
			sentence = in.nextLine();
			words = sentence.split(" ");
			if(words.length == 5) {
				break;
			} else if (words.length < 5){
				System.out.println("\nSentence has no 5 words, try again.\n");
			} else {
				System.out.println("\nSentence has more than 5 words, try again.\n");
			}
		}
		
		in.close();

		int max = 0;
		String longest = "";
		
		for (String word : words) {
			if (word.length() > max) {
				max = word.length();
				longest = word;
			}
			
			lettersCount += word.length();
		}
		
		System.out.println("\n Longest word in the sentence is " + longest + ", its have " + longest.length() + " letters");
		System.out.println("\n Number of letters in the sentence = " + lettersCount);
		System.out.println("\n Second word in reverse = " + new StringBuilder(words[1]).reverse().toString());
	}
}
