/*
 * Дан текст (строка). Найдите наибольшее количество
 * подряд идущих пробелов в нем.
 */

package by.java_online.module03.string_as_object.task01;

public class Task01 {
    public static void main(String[] args) {
        String line = "At first only included capital letters and    numbers.";

        int maxNumberOfSpaces = getNumberOfSpaces(line);

        System.out.println("Maximum number of spaces is " + maxNumberOfSpaces);
    }

    private static int getNumberOfSpaces(String line) {
        int counter = 0;
        int x = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                x++;

                if (x > counter) {
                    counter = x;
                }

            } else {
                x = 0;
            }
        }

        return counter;
    }
}
