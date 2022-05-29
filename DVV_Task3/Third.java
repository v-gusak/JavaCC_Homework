import java.util.Scanner;

public class Third {
	public static void main(String[] args) {
		String parts[];
		String regEx = "^[-]?[$]\\d{1,3}(\\d{3})*\\.\\d{2}$";
		
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		in.close();
		
		parts = text.split(" ");
		
		System.out.println("\nCurrency occurrences:");
		for (String part : parts) {
			if(part.matches(regEx)) {
				System.out.println(part);
			}
		}
	}
}
