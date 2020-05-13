/*
 * В строке найти количество цифр.
 */

package by.java_online.module03.string_as_array.task03;

public class Task03 {
    public static void main(String[] args) {
        String line = "348 books, 14 flowers, 1 cat";

        int numberOfDigits = calculateNumberOfDigits(line);

        System.out.println("String '" + line + "' contains " +
                            numberOfDigits + " digits.");
    }

    private static int calculateNumberOfDigits(String phrase) {
        char[] array = phrase.toCharArray();
        int counter = 0;

        for (char character : array) {
            if (character >= 48 & character <= 57) {
                counter++;
            }
        }

        return counter;
    }
}
