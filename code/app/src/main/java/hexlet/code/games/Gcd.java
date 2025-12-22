package hexlet.code.games;

import java.util.Random;

/**
 * Игра "Наибольший общий делитель (НОД)".
 */
public final class Gcd {
    /** Количество раундов. */
    private static final int ROUNDS_COUNT = 3;
    /** Максимальное число. */
    private static final int MAX_NUMBER = 100;

    /**
     * Возвращает правила игры.
     * @return правила
     */
    public static String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }

    /**
     * Генерирует вопросы и ответы для игры.
     * @return массив вопросов и ответов
     */
    public static String[][] getQuestionsAndAnswers() {
        Random random = new Random();
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int num1 = random.nextInt(MAX_NUMBER) + 1; // от 1 до 100
            int num2 = random.nextInt(MAX_NUMBER) + 1;
            
            int gcd = gcd(num1, num2);
            
            questionsAndAnswers[i][0] = num1 + " " + num2;
            questionsAndAnswers[i][1] = Integer.toString(gcd);
        }

        return questionsAndAnswers;
    }

    /**
     * Вычисляет наибольший общий делитель (НОД) по алгоритму Евклида.
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
