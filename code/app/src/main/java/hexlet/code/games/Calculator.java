package hexlet.code.games;

import java.util.Random;

/**
 * Игра "Калькулятор".
 */
public final class Calculator {
    /** Количество раундов. */
    private static final int ROUNDS_COUNT = 3;
    /** Максимальное число. */
    private static final int MAX_NUMBER = 20;

    /**
     * Возвращает правила игры.
     * @return правила
     */
    public static String getRules() {
        return "What is the result of the expression?";
    }

    /**
     * Генерирует вопросы и ответы для игры.
     * @return массив вопросов и ответов
     */
    public static String[][] getQuestionsAndAnswers() {
        Random random = new Random();
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int num1 = random.nextInt(MAX_NUMBER) + 1;
            int num2 = random.nextInt(MAX_NUMBER) + 1;
            char operator = generateRandomOperator(random);

            String question = num1 + " " + operator + " " + num2;
            String answer = Integer.toString(calculate(num1, num2, operator));

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        return questionsAndAnswers;
    }

    /**
     * Генерирует случайный оператор.
     * @param random генератор случайных чисел
     * @return оператор (+, - или *)
     */
    private static char generateRandomOperator(final Random random) {
        char[] operators = {'+', '-', '*'};
        return operators[random.nextInt(operators.length)];
    }

    /**
     * Вычисляет результат выражения.
     * @param a первое число
     * @param b второе число
     * @param operator оператор
     * @return результат вычисления
     */
    private static int calculate(final int a, final int b, final char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    /** Приватный конструктор. */
    private Calculator() {
    }
}
