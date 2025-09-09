import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int score = 0;
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

        while (playAgain) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            boolean hasGuessedCorrectly = false;

            System.out.println("\n🔁 New Round Started!");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + " - Enter your guess: ");
                int userGuess;

                // Validate input
                if (!scanner.hasNextInt()) {
                    System.out.println("⚠️ Please enter a valid number.");
                    scanner.next(); // clear invalid input
                    attempt--; // don’t count invalid input as an attempt
                    continue;
                }

                userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("🎉 Correct! You've guessed the number in " + attempt + " attempts.");
                    score++;
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("📉 Too low! Try a higher number.");
                } else {
                    System.out.println("📈 Too high! Try a lower number.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("❌ You've used all attempts. The number was: " + targetNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            scanner.nextLine(); // consume leftover newline
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("\n🏁 Game Over!");
        System.out.println("⭐ Your Total Score (Rounds Won): " + score);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

