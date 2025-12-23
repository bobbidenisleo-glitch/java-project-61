package hexlet.code.games;

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
     * Возвращает правила игры.
     * @return правила
     */
    public static String getRules() {
        return "What number is missing in the progression?";
    }

    /**
     * Генерирует вопросы и ответы для игры.
     * @return массив вопросов и ответов
     */
    public static String[][] getQuestionsAndAnswers() {
        Random random = new Random();
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            // Генерируем параметры прогрессии
            int length = MIN_LENGTH + random.nextInt(MAX_LENGTH - MIN_LENGTH + 1);
            int start = random.nextInt(MAX_START) + 1; // от 1 до 20
            int step = random.nextInt(MAX_STEP) + 1;   // от 1 до 10
            int hiddenIndex = random.nextInt(length);  // позиция скрытого элемента

            // Создаём прогрессию
            int[] progression = generateProgression(start, step, length);
            
            // Формируем вопрос со скрытым элементом
            String question = buildQuestion(progression, hiddenIndex);
            String answer = Integer.toString(progression[hiddenIndex]);

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        return questionsAndAnswers;
    }

    /**
     * Генерирует арифметическую прогрессию.
     * @param start первый элемент
     * @param step шаг прогрессии
     * @param length длина прогрессии
     * @return массив с прогрессией
     */
    private static int[] generateProgression(final int start, final int step, final int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        return progression;
    }

    /**
     * Строит строку вопроса со скрытым элементом.
     * @param progression массив прогрессии
     * @param hiddenIndex индекс скрытого элемента
     * @return строка вопроса
     */
    private static String buildQuestion(final int[] progression, final int hiddenIndex) {
        StringBuilder question = new StringBuilder();
        
        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                question.append("..");
            } else {
                question.append(progression[i]);
            }
            
            // Добавляем пробел, кроме последнего элемента
            if (i < progression.length - 1) {
                question.append(" ");
            }
        }
        
        return question.toString();
    }

    /** Приватный конструктор. */
    private Progression() {
    }
}
