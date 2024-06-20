import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter your choice (Rock, Paper, Scissors). Type 'exit' to quit the game.");

        while (true) {
            System.out.print("Your choice: ");
            String userChoice = scanner.nextLine();

            if (userChoice.equalsIgnoreCase("exit")) {
                break;
            }

            if (!userChoice.equalsIgnoreCase("Rock") && !userChoice.equalsIgnoreCase("Paper") && !userChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid choice, please try again.");
                continue;
            }

            int computerIndex = random.nextInt(3);
            String computerChoice = choices[computerIndex];

            System.out.println("Computer's choice: " + computerChoice);

            if (userChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It's a tie!");
            } else if (userChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors") ||
                       userChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock") ||
                       userChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper")) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}
