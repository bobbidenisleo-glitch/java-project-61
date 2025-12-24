package hexlet.code;

import java.util.Scanner;

/**
 * Класс для взаимодействия с пользователем.
 * Содержит только логику приветствия.
 */
public final class Cli {
    /**
     * Приветствует пользователя и запрашивает имя.
     * @return имя пользователя
     */
    public static String greet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    /** Приватный конструктор. */
    private Cli() {
    }
}
