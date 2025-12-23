package hexlet.code;

import java.util.Scanner;

/**
 * Универсальный движок для запуска игр.
 * Содержит общую логику общения с пользователем.
 */
public final class Engine {
    /** Количество раундов для победы. */
    private static final int ROUNDS_TO_WIN = 3;

    /**
     * Запускает игру.
     * @param rules правила игры
     * @param questionsAndAnswers массив вопросов и ответов
     */
    public static void run(final String rules, final String[][] questionsAndAnswers) {
        Scanner scanner = new Scanner(System.in);

        // Приветствие
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        // Правила конкретной игры
        System.out.println(rules);

        // Основной цикл игры
        for (int i = 0; i < ROUNDS_TO_WIN; i++) {
            String question = questionsAndAnswers[i][0];
            String correctAnswer = questionsAndAnswers[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim();

            // Проверяем ответ
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. "
                    + "Correct answer was '" + correctAnswer + "'");
                System.out.println("Let's try again, " + name + "!");
                scanner.close();
                return;
            }
        }

        // Победа
        System.out.println("Congratulations, " + name + "!");
        scanner.close();
    }

    /** Приватный конструктор. */
    private Engine() {
    }
}
