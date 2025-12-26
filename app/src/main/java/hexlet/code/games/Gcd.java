package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

/**
 * Игра "Наибольший общий делитель (НОД)".
 */
public final class Gcd {
    /** Количество раундов. */
    /** Максимальное число. */
    private static final int MAX_NUMBER = 100;

    /**
     * Запускает игру.
     */
    public static void startGame() {
        String rule = "Find the greatest common divisor of given numbers.";
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(rule, questionsAndAnswers);
    }

    /**
     * Генерирует вопросы и ответы для игры.
     * @return массив вопросов и ответов
     */
    private static String[][] generateQuestionsAndAnswers() {
        Random random = new Random();
        String[][] questionsAndAnswers = new String[Engine.ROUNDS][2];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int a = random.nextInt(MAX_NUMBER) + 1;
            int b = random.nextInt(MAX_NUMBER) + 1;

            String question = a + " " + b;
            String answer = Integer.toString(gcd(a, b));

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        return questionsAndAnswers;
    }

    /**
     * Вычисляет НОД двух чисел (алгоритм Евклида).
     * @param a первое число
     * @param b второе число
     * @return НОД(a, b)
     */
    private static int gcd(final int a, final int b) {
        int x = a;
        int y = b;
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    /** Приватный конструктор. */
    private Gcd() {
    }
}
