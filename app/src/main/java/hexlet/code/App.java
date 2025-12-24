package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;

public final class App {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                Cli.greet();
                break;
            case "2":
                Even.startGame();
                break;
            case "3":
                Calculator.startGame();
                break;
            case "4":
                Gcd.startGame();
                break;
            case "5":
                Progression.startGame();
                break;
            case "6":
                Prime.startGame();
                break;
            case "0":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Unknown game number: " + choice);
        }

        scanner.close();
    }

    private App() {
    }
}
