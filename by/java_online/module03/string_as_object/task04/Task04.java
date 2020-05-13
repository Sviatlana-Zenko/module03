/*
 * С помощью функции копирования и операции конкатенации составить
 * из частей слова “информатика” слово “торт”.
 */

package by.java_online.module03.string_as_object.task04;

public class Task04 {
    public static void main(String[] args) {
        String word1 = "информатика";
        String word2 = createNewWord(word1);

        System.out.println("Original word:\n" + word1 +
                           "\nNew word:\n" + word2);
    }

    private static String createNewWord(String word1) {
        String newWord = new String();
        char[] array = word1.toCharArray();

        newWord = newWord.concat(String.copyValueOf(array, 7, 1).
                          concat(String.copyValueOf(array, 3, 2).
                          concat(String.copyValueOf(array, 7, 1))));

        return newWord;
    }
}
