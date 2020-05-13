/*
 * Подсчитать, сколько раз среди символов заданной
 * строки встречается буква “а”.
 */

package by.java_online.module03.string_as_object.task05;

public class Task05 {
    public static void main(String[] args) {
        String line = "At first only included capital letters and numbers.";
        char letter = 'a';

        int numberOfRepetitions = getNumberOfRepetitions(line, letter);

        System.out.println("'" + letter + "' is repeated " +
                           numberOfRepetitions + " times");
    }

    private static int getNumberOfRepetitions(String line, char letter) {
        int counter = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == letter) {
                counter += 1;
            }
        }

        return counter;
    }
}
