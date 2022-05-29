import java.util.Scanner;

public class Second {
	public static void main(String[] args) {
		String sentence;
		Scanner in = new Scanner(System.in);
		
		System.out.println("\nEnter a sentence that contains the words between more than one space: ");
		
		sentence = in.nextLine();
		
		in.close();
		
		System.out.println("\nResult:\n" + sentence.replaceAll("\\s+"," "));
	} 
}
