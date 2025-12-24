package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

/**
 * Игра "Арифметическая прогрессия".
 */
public final class Progression {
    /** Количество раундов. */
    private static final int ROUNDS_COUNT = 3;
    /** Минимальная длина прогрессии. */
    private static final int MIN_LENGTH = 5;
    /** Максимальная длина прогрессии. */
    private static final int MAX_LENGTH = 10;
    /** Максимальный начальный элемент. */
    private static final int MAX_START = 20;
    /** Максимальный шаг прогрессии. */
    private static final int MAX_STEP = 10;

    /**
     * Запускает игру.
     */
    public static void startGame() {
        String rule = "What number is missing in the progression?";
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
            int length = MIN_LENGTH + random.nextInt(MAX_LENGTH - MIN_LENGTH + 1);
            int start = random.nextInt(MAX_START) + 1;
            int step = random.nextInt(MAX_STEP) + 1;
            int hiddenIndex = random.nextInt(length);

            // СОЗДАЁМ ПРОГРЕССИЮ КАК МАССИВ СТРОК (четвёртое замечание)
            String[] progression = generateProgression(start, step, length);
            String answer = progression[hiddenIndex];
            progression[hiddenIndex] = "..";

            String question = String.join(" ", progression);

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        return questionsAndAnswers;
    }

    /**
     * Генерирует арифметическую прогрессию как массив строк.
     * @param start начальный элемент
     * @param step шаг прогрессии
     * @param length длина прогрессии
     * @return массив строк, представляющих прогрессию
     */
    private static String[] generateProgression(final int start, final int step, final int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = Integer.toString(start + i * step);
        }
        return progression;
    }

    /** Приватный конструктор. */
    private Progression() {
    }
}
