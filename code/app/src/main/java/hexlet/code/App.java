package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime; // ДОБАВЛЕНО
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
        System.out.println("6 - Prime"); // ДОБАВЛЕНО
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                Cli.greet();
                break;
            case "2":
                Engine.run(Even.getRules(), Even.getQuestionsAndAnswers());
                break;
            case "3":
                Engine.run(Calculator.getRules(), Calculator.getQuestionsAndAnswers());
                break;
            case "4":
                Engine.run(Gcd.getRules(), Gcd.getQuestionsAndAnswers());
                break;
            case "5":
                Engine.run(Progression.getRules(), Progression.getQuestionsAndAnswers());
                break;
            case "6": // ДОБАВЛЕНО
                Engine.run(Prime.getRules(), Prime.getQuestionsAndAnswers());
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
