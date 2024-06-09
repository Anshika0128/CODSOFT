import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 7;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        boolean playAgain;

        do {
            int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attempts = 0;
            boolean correctGuess = false;
            System.out.println("Let's Play!");
            System.out.println("Guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND + ":");

            while (attempts < MAX_ATTEMPTS && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Correct! You've guessed the number.");
                    correctGuess = true;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!correctGuess) {
                System.out.println("You've used all your attempts. The correct number was " + targetNumber);
            }

            totalScore += (MAX_ATTEMPTS - attempts + 1);

            System.out.println("Your current score is: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing!");
        System.out.println("Your final score is: " + totalScore);
        sc.close();
    }
}
