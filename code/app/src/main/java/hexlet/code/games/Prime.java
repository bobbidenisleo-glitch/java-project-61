package hexlet.code.games;

import java.util.Random;

/**
 * Игра "Простое ли число?".
 */
public final class Prime {
    /** Количество раундов. */
    private static final int ROUNDS_COUNT = 3;
    /** Максимальное число. */
    private static final int MAX_NUMBER = 100;
    /** Минимальное число (простые числа начинаются с 2). */
    private static final int MIN_NUMBER = 2;

    /**
     * Возвращает правила игры.
     * @return правила
     */
    public static String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    /**
     * Генерирует вопросы и ответы для игры.
     * @return массив вопросов и ответов
     */
    public static String[][] getQuestionsAndAnswers() {
        Random random = new Random();
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = MIN_NUMBER + random.nextInt(MAX_NUMBER - MIN_NUMBER + 1);
            
            boolean isPrime = isPrime(number);
            String answer = isPrime ? "yes" : "no";

            questionsAndAnswers[i][0] = Integer.toString(number);
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
        
        // Проверяем делители от 2 до квадратного корня из number
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false; // Нашли делитель - число составное
            }
        }
        
        return true; // Делителей не найдено - число простое
    }

    /** Приватный конструктор. */
    private Prime() {
    }
}
