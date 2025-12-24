package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

/**
 * Игра "Простое ли число?".
 */
public final class Prime {
    /** Количество раундов. */
    private static final int ROUNDS_COUNT = 3;
    /** Максимальное число. */
    private static final int MAX_NUMBER = 100;

    /**
     * Запускает игру.
     */
    public static void startGame() {
        String rule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(rule, questionsAndAnswers);
    }

    /**
     * Генерирует вопросы и ответы для игры.
     * @return массив вопросов и ответов
     */
    private static String[][] generateQuestionsAndAnswers() {
        Random random = new Random();
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = random.nextInt(MAX_NUMBER) + 1;
            String question = Integer.toString(number);
            String answer = isPrime(number) ? "yes" : "no";

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        return questionsAndAnswers;
    }

    /**
     * Проверяет, является ли число простым.
     * @param number число для проверки
     * @return true если простое, false если составное
     */
    private static boolean isPrime(final int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /** Приватный конструктор. */
    private Prime() {
    }
}
