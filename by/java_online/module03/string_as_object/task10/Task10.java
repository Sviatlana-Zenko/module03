/*
 * Строка X состоит из нескольких предложений, каждое из которых
 * кончается точкой, восклицательным или вопросительным знаком.
 * Определить количество предложений в строке X.
 */

package by.java_online.module03.string_as_object.task10;

public class Task10 {
    public static void main(String[] args) {
        String text = "Cat and dog. Cat, dog? Dog and cat!";

        int numberOfSentences = getNumberOfSentences(text);

        System.out.println("Number of sentences is " + numberOfSentences);
    }

    private static int getNumberOfSentences (String text) {
        int counter = 0;

        for (int i = 0; i <text.length(); i++) {
            if (text.charAt(i) == '!' | text.charAt(i) == '?' | text.charAt(i) == '.') {
                counter++;
            }
        }

        return counter;
    }
}
