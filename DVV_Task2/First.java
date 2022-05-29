import java.util.Scanner;

public class First {
	public static void main(String[] args) {
		int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		String monthName[] = {"January", "February", "March", "April", 
							  "May", "June", "July", "August", 
							  "September", "October", "November", "December"};
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of month (1-12): ");
		int monthNumber;
		
		while(true) {
			monthNumber = in.nextInt();
			
			if(monthNumber > 0 && monthNumber <= 12) {
				break;
			}
		}
		
		in.close();
		
		System.out.println("\nThe amount of days in " + monthName[monthNumber - 1] + " is " + monthDays[monthNumber - 1]);
	}
}
