/*
 * В строке найти количество чисел.
 */

package by.java_online.module03.string_as_array.task04;

public class Task04 {
    public static void main(String[] args) {
        String line = "2a 22b c222d";

        int number = getNumberOfDigits(line);

        System.out.println("String '" + line + "' contains " +
                           number + " numbers.");
    }

    private static int getNumberOfDigits(String phrase) {
        char[] array = phrase.toCharArray();
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 48 & array[i] <= 57) {
                if ((i > 0 && (array[i - 1] < 48 | array[i - 1] > 57)) | (i == 0)) {
                    counter++;
                }
            }
        }

        return counter;
    }
}

