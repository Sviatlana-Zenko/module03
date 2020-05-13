/*
 * Вводится строка слов, разделенных пробелами. Найти самое длинное
 * слово и вывести его на экран. Случай, когда самых длинных слов
 * может быть несколько, не обрабатывать.
 */

package by.java_online.module03.string_as_object.task08;

public class Task08 {
    public static void main(String[] args) {
        String line = "cat parrot dog fish";

        String longestWord = getLongestWord(line);

        System.out.println("The longest word is '" + longestWord + "'.");
    }

    private static String getLongestWord(String line) {
        String[] words = line.split(" ");
        int index = 0;
        int maxLength = words[index].length();

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > maxLength) {
                maxLength = words[i].length();
                index = i;
            }
        }

        return words[index];
    }
}
