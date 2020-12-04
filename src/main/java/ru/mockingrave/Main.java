package ru.mockingrave;

import java.util.Scanner;

/**
 * Класс для запуска программы.
 */
public class Main {
    /**
     * Точка входа в программу.
     *
     * @param args массив строк.
     */
    public static void main(String[] args) {
        // Размер поля.
        int fieldSize = 10;

        // Сервис для проверки правильности расстановки кораблей.
        FieldCheckService checkService = new FieldCheckService(input(fieldSize), fieldSize);

        if (checkService.validFieldChecker()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    /**
     * Ввод данных
     *
     * @param n размер поля.
     * @return двумерный массив введенных данных.
     */
    private static String[][] input(int n) {

        String[][] fieldArray = new String[n][n];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                fieldArray[i][j] = String.valueOf(string.charAt(j));
            }
        }
        scanner.close();
        return fieldArray;
    }
}
