import java.util.Scanner;

public class Third {
	public static void main(String[] args) {
		int numbers[] = new int[5];
		int count = 0;
		int secondPositive = -1;
		int minPosition = 0;

		Scanner in = new Scanner(System.in);
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = in.nextInt();
		}
		
		in.close();
		
		int min = numbers[0];
		
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] > 0) {
				count++;
				if(count == 2) {
					secondPositive = i;
				}
			}
			
			if(numbers[i] < min) {
				min = numbers[i];
				minPosition = i;
			}
		}
		
		if(secondPositive != -1) {
			System.out.println("\nPosition of second positive number in the array = " + (secondPositive + 1));
		} else {
			System.out.println("\nSequence of numbers has no two positive numbers");
		}
		
		System.out.println("\nMinimun number is " + min + " and its position in the array = " + (minPosition + 1));

	}
}
