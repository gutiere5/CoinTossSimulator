import java.util.Random;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Random random = new Random(); 
		String userInput;
		int randomNumber;
		int headsCount = 0;
		int tailsCount = 0;
		boolean run;

		System.out.println("Welcome to Coin Toss Simulator");

		run = true; 
		while (run) {
			randomNumber = random.nextInt(2);

			if (randomNumber == 1) {
				System.out.println("You got tails");
				tailsCount++;
			}
			else {
				System.out.println("You got heads");
				headsCount++;
			}

			System.out.println("Another Toss? y or n");
			userInput = scnr.nextLine();

			if (userInput.equals("n")) {
				run = false;
			}




		}





		// Displays Statitics
		System.out.println("Statistics:");
		System.out.println("Heads: " + headsCount);
		System.out.println("Tails: " + tailsCount);



	}

}
