/*
 * Замените в строке все вхождения 'word' на 'letter'.
 */

package by.java_online.module03.string_as_array.task02;

public class Task02 {
    public static void main(String[] args) {
        String line = "We use words every day, words are powerful.";
        String word = "word";
        String newWord = "letter";

        String newLine = new String(replaceWord(line, word, newWord));

        System.out.println("Original string:\n" + line + "\nNew string:\n" + newLine);
    }

    private static char[] replaceWord(String line, String word1, String word2) {

        // Из заданных строк формируем массивы символов
        char[] originalLine = line.toCharArray();
        char[] wordToSearch = word1.toCharArray();
        char[] wordToReplace = word2.toCharArray();

        // Создаем новый массив, в котором будут заменены слова
        int arrayLength = calculateLength(originalLine, wordToSearch, wordToReplace);
        char[] modifiedLine = new char[arrayLength];

        int k = 0;
        int l = 0;

        while (k < originalLine.length) {
            if (compareWord(originalLine, wordToSearch, k)) {
                int m = 0;

                while (m < wordToReplace.length) {
                    modifiedLine[l] = wordToReplace[m];
                    m++;
                    l++;
                }

                k += wordToSearch.length;
            } else {
                modifiedLine[l] = originalLine[k];
                l++;
                k++;
            }
        }

        return modifiedLine;
    }

    private static int calculateLength(char[] originalLine, char[] wordToSearch,
                                       char[] wordToReplace) {

        int length = originalLine.length;

        for (int i = 0; i < originalLine.length - 3; i++) {
            if (compareWord(originalLine, wordToSearch, i)) {
                length += (wordToReplace.length - wordToSearch.length);
            }
        }

        return length;
    }

    private static boolean compareWord(char[] originalLine,
                                       char[] wordToSearch, int index) {

        boolean isEqual = true;
        int j = 0;

        while (j < wordToSearch.length) {
            if (originalLine[index + j] != wordToSearch[j]) {
                isEqual = false;
                break;
            }
            j++;
        }

        return isEqual;
    }
}
