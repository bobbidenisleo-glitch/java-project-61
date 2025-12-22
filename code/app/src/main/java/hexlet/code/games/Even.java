package hexlet.code.games;

import java.util.Random;

/**
 * Игра "Проверка на чётность".
 */
public final class Even {
    /** Количество раундов. */
    private static final int ROUNDS_COUNT = 3;
    /** Максимальное число. */
    private static final int MAX_NUMBER = 100;

    /**
     * Возвращает правила игры.
     * @return правила
     */
    public static String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
     * Генерирует вопросы и ответы для игры.
     * @return массив вопросов и ответов
     */
    public static String[][] getQuestionsAndAnswers() {
        Random random = new Random();
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = random.nextInt(MAX_NUMBER) + 1;
            String question = Integer.toString(number);
            String answer = isEven(number) ? "yes" : "no";

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        return questionsAndAnswers;
    }

    /**
     * Проверяет, является ли число чётным (предикат).
     * @param number число для проверки
     * @return true если чётное, false если нечётное
     */
    private static boolean isEven(final int number) {
        return number % 2 == 0;
    }

    /** Приватный конструктор. */
    private Even() {
    }
}
