package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

/**
 * Игра "Калькулятор".
 */
public final class Calculator {
    private static final int MAX_NUMBER = 100;
    private static final String[] OPERATIONS = {"+", "-", "*"};

    /**
     * Запускает игру.
     */
    public static void startGame() {
        String rule = "What is the result of the expression?";
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
            String operation = OPERATIONS[random.nextInt(OPERATIONS.length)];

            String question = a + " " + operation + " " + b;
            String answer = Integer.toString(calculate(a, b, operation));

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        return questionsAndAnswers;
    }

    /**
     * Вычисляет результат операции.
     * @param a первое число
     * @param b второе число
     * @param operation операция (+, -, *)
     * @return результат вычисления
     */
    private static int calculate(final int a, final int b, final String operation) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }

    private Calculator() {
    }
}
