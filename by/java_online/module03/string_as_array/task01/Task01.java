/*
 * Дан массив названий переменных в camelCase.
 * Преобразовать названия в snake_case.
 */

package by.java_online.module03.string_as_array.task01;

public class Task01 {
    public static void main(String[] args) {
        String camelCase = "firstSum, secondSum, totalValue, arrayLength";

        String snakeCase = new String(turnIntoSnakeCase(camelCase));

        System.out.println("Original string:\n" + camelCase +
                           "\nNew string:\n" + snakeCase);
    }

    private static char[] turnIntoSnakeCase (String camelCase) {

        // Создаем массив символов snake_case на основе camelCase
        char[] camelCaseArray = camelCase.toCharArray();
        char[] snakeCaseArray = new char[calculateNewLength(camelCaseArray)];

        int i = 0;
        int x = 0;

        while (i < snakeCaseArray.length) {
            if (camelCaseArray[i - x] >= 65 && camelCaseArray[i - x] <= 90) {
                x++;
                snakeCaseArray[i] = 95;
                i++;
                snakeCaseArray[i] = (char) (camelCaseArray[i - x] + 32);
            } else {
                snakeCaseArray[i] = camelCaseArray[i - x];
            }
            i++;
        }

        return snakeCaseArray;
    }

    private static int calculateNewLength (char[] array) {

        /*
         * Длина массива символов snake_case будет больше длины
         * массива camelCase, т.к. перед каждой большой буквой
         * добавится нижнее подчеркивание. К длине camelCase
         * прибавим количество заглавных букв.
         */

        int counter = 0;

        for (char character : array) {
            if (character >= 65 && character <= 90) {
                counter += 1;
            }
        }

        return array.length + counter;
    }
}
