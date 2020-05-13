/*
 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов
 * заменить на одиночные пробелы. Крайние пробелы в строке удалить.
 */

package by.java_online.module03.string_as_array.task05;

public class Task05 {
    public static void main(String[] args) {
        String line = "aaa  a a    a   a  aaa  ";

        String newLine = new String(removeDuplicates(line));

        System.out.println("Original string:\n'" + line + "'" +
                           "\nNew string:\n'" + newLine + "'\n");
    }

    private static char[] removeDuplicates(String phrase) {
        char[] array = phrase.toCharArray();
        char[] newArray = new char[calculateArrayLength(phrase)];

        int j = 0;
        int k = 0;

        while (k < newArray.length) {
            if (array[j] != 32) {
                newArray[k] = array[j];
                k++;
            } else if (array[j] == 32 && j > 0 && array[j - 1] != 32) {
                newArray[k] = 32;
                k++;
            }
            j++;
        }

        return newArray;
    }

    private static int calculateArrayLength(String phrase) {
        char[] array = phrase.toCharArray();
        int wordCounter = 0;
        int characterCounter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 32) {
                if ((i < array.length - 1 && array[i + 1] == 32) |
                        (i == array.length - 1)) {
                    wordCounter++;
                }
            }
        }

        for (char character : array) {
            if (character != 32) {
                characterCounter++;
            }
        }

        return characterCounter + (wordCounter - 1);
    }
}
