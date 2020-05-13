/*
 *  Проверить, является ли заданное слово палиндромом.
 */

package by.java_online.module03.string_as_object.task03;

public class Task03 {
    public static void main(String[] args) {
        String word = "Level";

        checkWord(word);
    }

    private static void checkWord(String word) {
        if (word.toLowerCase().equals(reverseWord(word))) {
            System.out.println("The word '" + word + "' is a palindrome.");
        } else {
            System.out.println("The word '" + word + "' is not a palindrome.");
        }
    }

    private static String reverseWord(String word) {
        StringBuilder builder = new StringBuilder(word.toLowerCase());
        builder.reverse();

        return builder.toString();
    }
}
