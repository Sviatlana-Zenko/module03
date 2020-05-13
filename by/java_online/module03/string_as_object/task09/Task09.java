/*
 * Посчитать количество строчных (маленьких) и прописных (больших) букв
 * во введенной строке. Учитывать только английские буквы.
 */

package by.java_online.module03.string_as_object.task09;

public class Task09 {
    public static void main(String[] args) {
        String line = "Cow Корова Dog Собака Bird Птица";

        int uppercase = getNumberOfLetters(line, 'A', 'Z');
        int lowercase = getNumberOfLetters(line, 'a', 'z');

        System.out.println("Number of uppercase letters is " + uppercase +
                           "\nNumber of lowercase letters is " + lowercase);
    }

    private static int getNumberOfLetters(String line, char first, char last) {
        int counter = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= first && line.charAt(i) <= last) {
                counter += 1;
            }
        }

        return counter;
    }
}
