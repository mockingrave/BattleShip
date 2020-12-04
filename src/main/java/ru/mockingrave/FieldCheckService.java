package ru.mockingrave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Сервис для проверки правильности расстановки кораблей.
 */
public class FieldCheckService {
    /**
     * Массив входной сетки данных.
     */
    private String[][] fieldArray;
    /**
     * Список кораблей.
     */
    private List<Integer> shipList;
    /**
     * Размерность сетки.
     */
    private int n;

    /**
     * Конструктор.
     *
     * @param fieldArray входной массив данных.
     * @param n размерность сетки.
     */
    public FieldCheckService(String[][] fieldArray, int n) {
        shipList = new ArrayList<>();
        this.fieldArray = fieldArray;
        this.n = n;
    }

    /**
     * Проверка на соблюдение всех аспектов расстановки кораблей.
     *
     * @return корректна ли сетка с учетом всех аспектов.
     */
    public boolean validFieldChecker() {

            return  xMarkProcessing() &
                    1 == Collections.frequency(shipList, 4) &
                    2 == Collections.frequency(shipList, 3) &
                    3 == Collections.frequency(shipList, 2) &
                    4 == Collections.frequency(shipList, 1) &
                    shipList.size() == 10;
    }

    /**
     * Проверка дистанции между кораблями и их нумерации
     *
     * @return соблюдена ли дистанция.
     */
    public boolean xMarkProcessing() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (fieldArray[i][j].equals("X")) {

                    if (!(checkWarningZone(i - 1, j - 1) &
                          checkWarningZone(i + 1, j - 1) &
                          checkWarningZone(i + 1, j + 1) &
                          checkWarningZone(i - 1, j + 1)))
                    {
                        return false;
                    }

                    if (!shipNumerate(i - 1, j, i, j) &
                        !shipNumerate(i, j - 1, i, j))
                    {
                        fieldArray[i][j] = Integer.toString(shipList.size());
                        shipList.add(1);
                    }
                }
            }
        }
        return true;
    }

    /**
     * Пустая ли клетка.
     *
     * @param i строка.
     * @param j столбец.
     * @return пустая ли клетка.
     */
    public boolean checkWarningZone(int i, int j) {
        try {
            if (!fieldArray[i][j].equals("X")) {
                fieldArray[i][j] = "W"; // W = warning zone
                return true;
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException exception) {
            return true;
        }
    }

    /**
     * Если клетка является продолжением уже найденного корабля - нумеровать её так же.
     *
     * @param iPrev значение строки, где уже возможно находится корабль.
     * @param jPrev значение столбца, где уже возможно находится корабль.
     * @param iCurrent текущее значение строки.
     * @param jCurrent текущее значение столбца.
     * @return является ли продолжением корабля.
     */
    public boolean shipNumerate(int iPrev, int jPrev, int iCurrent, int jCurrent) {

        try {
            String xPrev = fieldArray[iPrev][jPrev];
            if (!xPrev.equals(".") && !xPrev.equals("W")) { //Not empty & not "W"arning
                fieldArray[iCurrent][jCurrent] = xPrev;

                int index = Integer.parseInt(xPrev);
                shipList.set(index, shipList.get(index) + 1);

                return true;
            } else
                return false;

        } catch (ArrayIndexOutOfBoundsException exception) {
            return false;
        }
    }
}
