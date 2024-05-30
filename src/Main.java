import java.util.Random;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Random random = new Random(); 
		int randomNumber;
		boolean run;
		String userInput;

		

		System.out.println("Welcome to Coin Toss Simulator");

		run = true; 
		while (run) {
			
			randomNumber = random.nextInt(2);
			
			if (randomNumber == 1) {
				System.out.println("You got tails");
			}
			else {
				System.out.println("You got heads");

			}
			
			System.out.println("Another Toss? y or n");
			userInput = scnr.nextLine();
			
			if (userInput.equals("n")) {
				run = false;
			}
			
			
		}
		
		
		
		
		
		
		
		
		
	}

}
