import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int highScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Choose a difficulty level:");
        System.out.println("1. Easy (1-50, 10 attempts)");
        System.out.println("2. Medium (1-100, 7 attempts)");
        System.out.println("3. Hard (1-200, 5 attempts)");

        System.out.print("Enter your choice (1, 2, or 3): ");
        int choice = scanner.nextInt();
        int range = 100;
        int maxAttempts = 7;

        switch (choice) {
            case 1:
                range = 50;
                maxAttempts = 10;
                break;
            case 2:
                range = 100;
                maxAttempts = 7;
                break;
            case 3:
                range = 200;
                maxAttempts = 5;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Medium difficulty.");
        }

        int totalRounds = 0;
        int totalAttempts = 0;

        while (true) {
            totalRounds++;
            int targetNumber = random.nextInt(range) + 1;
            int attemptsLeft = maxAttempts;
            int attemptsMade = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + totalRounds + " - I have selected a number between 1 and " + range + ". Try to guess it!");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.println("Attempts left: " + attemptsLeft);
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < 1 || userGuess > range) {
                    System.out.println("Please enter a number between 1 and " + range + ".");
                    continue;
                }

                attemptsMade++;
                totalAttempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    int score = attemptsLeft * 10; // Score calculation: more attempts left = higher score
                    System.out.println("Your score for this round: " + score);
                    if (score > highScore) {
                        highScore = score;
                        System.out.println("New high score: " + highScore);
                    }
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you ran out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (playAgain.equals("no")) {
                break;
            }
        }

        // Display game statistics
        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total attempts made: " + totalAttempts);
        System.out.println("Average attempts per round: " + (totalAttempts / (double) totalRounds));
        System.out.println("Your highest score: " + highScore);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
