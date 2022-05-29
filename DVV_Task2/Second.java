import java.util.Scanner;

public class Second {
	public static void main(String[] args) {
		Boolean isSum = false;
		int sum = 0;
		int prod = 1;
		int numbers[] = new int[10];
		
		Scanner in = new Scanner(System.in);
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = in.nextInt();
		}
		
		in.close();
		
		for(int i = 0; i < 5; i++) {
			if(numbers[i] > 0) {
				isSum = true;
			} else {
				isSum = false;
				break;
			}
		}
		
		if(isSum) {
			for(int i = 0; i < 5; i++) {
				sum += numbers[i];
			}
			
			System.out.println("\nThe sum of first 5 elements = " + sum);
		} else {
			for(int i = 5; i < 10; i++) {
				prod *= numbers[i];
			}
			
			System.out.println("\nThe product of last 5 elements = " + prod);
		}
	}
	
	
}
