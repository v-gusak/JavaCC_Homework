import java.util.ArrayList;
import java.util.Scanner;

public class Fourth {
	public static void main(String[] args) {
		int number;
		int product = 1;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		
		while (true) {
			number = in.nextInt();
			
			if(number < 0) {
				break;
			}
			
			numbers.add(number);
		}
		
		in.close();
		

		for (int n : numbers) {
			if (n % 2 == 0) {
				product *= n;
			}
		}
		
		if(product != 1) {
			System.out.println("\nThe product of all entered even numbers = " + product);
		} else {
			System.out.println("\nSequence of entered numbers has no even members");
		}
	}
}
