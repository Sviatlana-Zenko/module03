/*
 * Вводится строка. Требуется удалить из нее повторяющиеся символы
 * и все пробелы. Например, если было введено "abc cde def",
 * то должно быть выведено "abcdef".
 */

package by.java_online.module03.string_as_object.task07;

public class Task07 {
    public static void main(String[] args) {
        String line = "At first only included capital letters and numbers";

        String newLine = deleteSymbols(line);

        System.out.println("Original string:\n" + line +
                           "\nNew string:\n" + newLine);
    }

    private static String deleteSymbols(String line) {
        StringBuilder modifiedLine = new StringBuilder(line.toLowerCase());

        for (int i = modifiedLine.length() - 1; i > 0; i--) {
            int j = i - 1;

            while (j >= 0) {
                if ((modifiedLine.charAt(i) == ' ') |
                        (modifiedLine.charAt(i) == modifiedLine.charAt(j))) {

                    modifiedLine.delete(i, i + 1);
                    break;
                }
                j--;
            }
        }

        return modifiedLine.toString();
    }
}
