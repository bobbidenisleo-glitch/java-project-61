package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

/**
 * Игра "Проверка на чётность".
 */
public final class Even {
    /** Количество раундов. */
    /** Максимальное число. */
    private static final int MAX_NUMBER = 100;

    /**
     * Запускает игру.
     */
    public static void startGame() {
        String rule = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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
