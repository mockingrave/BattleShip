package ru.mockingrave;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки класса FieldCheckService.
 */
public class FieldCheckServiceTest {
    /**
     * Объект сервиса FieldCheckService.
     */
    private FieldCheckService fieldCheckService;
    /**
     * Массив для теста.
     */
    private String[][] testArray;

    /**
     * Инициализация объекта.
     */
    @BeforeEach
    public void init() {
        testArray = new String[][]{
                {"X", "X", "X", "X", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", "X", ".", ".", ".", ".", "."},
                {"X", "X", "X", ".", ".", "X", "X", "X", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "X", "X"},
                {".", ".", ".", "X", "X", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "X", "X"},
                {".", ".", ".", "X", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", "X", ".", ".", "X", "."},
                {".", "X", ".", ".", ".", ".", ".", ".", ".", "."}
        };
        fieldCheckService = new FieldCheckService(testArray, 10);
    }

    /**
     * Тест метода для проверки пустая ли клетка.
     */
    @Test
    public void testCheckWarningZone() {
        Assertions.assertTrue(fieldCheckService.checkWarningZone(0, 9));
        Assertions.assertTrue(fieldCheckService.checkWarningZone(1, 1));

        Assertions.assertFalse(fieldCheckService.checkWarningZone(0, 0));
        Assertions.assertFalse(fieldCheckService.checkWarningZone(2, 2));
    }

    /**
     * Тест проверки дистанции между кораблями и их нумерации
     */
    @Test
    public void testXMarkProcessing() {
        //изначально корабли расставлены неправильно
        Assertions.assertFalse(fieldCheckService.xMarkProcessing());
        //исправили расстановку кораблей
        testArray[1][4] = ".";
        Assertions.assertTrue(fieldCheckService.xMarkProcessing());
    }

    /**
     * Тест проверки на соблюдение всех аспектов расстановки кораблей
     */
    @Test
    public void testValidFieldChecker() {
        //исправили расстановку кораблей
        testArray[1][4] = ".";
        //fieldCheckService.setFieldArray(testArray);
        //изначально количество кораблей верное
        Assertions.assertTrue(fieldCheckService.validFieldChecker());
        //изменим количество кораблей
        testArray[5][0] = "X";
        testArray[6][0] = "X";
        Assertions.assertFalse(fieldCheckService.validFieldChecker());
        //уберем 2-палубный корбль и добавим 5-палубный корабль
        testArray[5][0] = ".";
        testArray[6][0] = ".";
        testArray[0][4] = "X";
        Assertions.assertFalse(fieldCheckService.validFieldChecker());
    }
}
