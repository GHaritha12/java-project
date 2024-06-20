import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Random Password Generator!");

        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUppercase = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLowercase = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean useNumbers = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean useSpecial = scanner.nextLine().trim().equalsIgnoreCase("y");

        String password = generatePassword(length, useUppercase, useLowercase, useNumbers, useSpecial);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    private static String generatePassword(int length, boolean useUppercase, boolean useLowercase, boolean useNumbers, boolean useSpecial) {
        StringBuilder characterPool = new StringBuilder();

        if (useUppercase) {
            characterPool.append(UPPERCASE);
        }
        if (useLowercase) {
            characterPool.append(LOWERCASE);
        }
        if (useNumbers) {
            characterPool.append(NUMBERS);
        }
        if (useSpecial) {
            characterPool.append(SPECIAL);
        }

        if (characterPool.length() == 0) {
            return "Error: No character sets selected!";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}
