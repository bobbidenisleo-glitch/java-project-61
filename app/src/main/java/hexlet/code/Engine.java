package hexlet.code;

import java.util.Scanner;

/**
 * Универсальный движок для запуска игр.
 * Содержит общую логику общения с пользователем.
 */
public final class Engine {
    /** Количество раундов для победы. */
public static final int ROUNDS = 3;
    /**
     * Запускает игру.
     * @param rules правила игры
     * @param questionsAndAnswers массив вопросов и ответов
     */
    public static void run(final String rules, final String[][] questionsAndAnswers) {
        Scanner scanner = new Scanner(System.in);

        String name = Cli.greet();

        // Правила конкретной игры
        System.out.println(rules);

        // Основной цикл игры
            for (String[] round : questionsAndAnswers) {
            String question = round[0];
            String correctAnswer = round[1];
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
                return;
            }
        }

        // Победа
        System.out.println("Congratulations, " + name + "!");
    }

    /** Приватный конструктор. */
    private Engine() {
    }
}

