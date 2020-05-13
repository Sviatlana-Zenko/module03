/*
 *Из заданной строки получить новую,
 * повторив каждый символ дважды.
 */

package by.java_online.module03.string_as_object.task06;

public class Task06 {
    public static void main(String[] args) {
        String line = "At first only included capital letters and numbers.";

        String newLine = repeatSymbol(line);

        System.out.println("Original string:\n" + line +
                           "\nNew string:\n" + newLine);
    }

    private static String repeatSymbol(String line) {
        StringBuilder modifiedLine = new StringBuilder(line);
        int i = 0;

        while (i < modifiedLine.length()) {
            modifiedLine.insert(i, modifiedLine.charAt(i));
            i += 2;
        }

        return modifiedLine.toString();
    }
}
