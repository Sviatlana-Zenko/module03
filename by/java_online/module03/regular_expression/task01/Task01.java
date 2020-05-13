/*
 * Создать приложение, разбирающее текст (текст хранится в строке) и
 * позволяющее выполнять с текстом три различных операции:
 * отсортировать абзацы по количеству предложений;
 * в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений
 * заданного символа, а в случае равенства – по алфавиту.
 */

package by.java_online.module03.regular_expression.task01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task01 {
    public static void main(String[] args) {
        String text = "Make Harry get it. Hurry up, boy. " +
                      "Who'd be writing to you?\n" +
                      "No, we'll ignore it. If they don't get an answer... " +
                      "Yes, that's best... We won't do anything...\n" +
                      "I'm not having one in the house, Petunia! " +
                      "Didn't we swear when we took him in we'd stamp out " +
                      "that dangerous nonsense?\n";

        System.out.println("Choose your operation:\n" +
                           "- enter 1 to sort paragraphs;\n" +
                           "- enter 2 to sort words;\n" +
                           "- enter 3 to sort lexemes.");

        int choice = enterNumber();

        while (choice < 1 | choice > 3) {
            System.out.println("Wrong input. Try again.");
            choice = enterNumber();
        }

        switch (choice) {
            case 1:
                sortParagraph(text);
                break;
            case 2:
                sortWord(text);
                break;
            case 3:
                sortLexeme(text);
                break;
        }
    }

    private static void sortParagraph(String text) {

        // В абзаце должно быть как минимум 1 предложение
        int minNumberOfSentences = 1;
        int maxNumberOfSentences = 1;

        /*
         * Формируем массив (в качестве элемента будет выступать абзац).
         * Далее считаем количество предложений в каждом абзаце и
         * находим их максимальное число.
         */

        String[] paragraphArray = createParagraphArray(text);

        for (String paragraph : paragraphArray) {
            int sentenceCounter;
            sentenceCounter = createSentenceArray(paragraph).length;

            if(sentenceCounter > maxNumberOfSentences) {
                maxNumberOfSentences = sentenceCounter;
            }
        }

        // Сортируем абзацы в массиве в зависимости от количества предложений
        StringBuilder sortedText = new StringBuilder();

        while(minNumberOfSentences <= maxNumberOfSentences) {
            for (String paragraph : paragraphArray) {
                int sentenceCounter;
                sentenceCounter = createSentenceArray(paragraph).length;

                if (sentenceCounter == minNumberOfSentences) {
                    sortedText.append(paragraph);
                    sortedText.append("\n");
                }
            }
            minNumberOfSentences++;
        }

        System.out.println(sortedText.toString());
    }

    private static void sortWord(String text) {

        /*
         * Формируем массив (в качестве элемента будет выступать
         * предложение). Потом сортируем слова по длине.
         */

        String[] sentenceArray = createSentenceArray(text);

        for (String sentence : sentenceArray) {
            String[] wordArray = createWordArray(sentence);

            for(int i = wordArray.length - 1; i > 0; i--) {
                for(int j = 0; j < i; j++) {
                    if(wordArray[j].length() > wordArray[j + 1].length()) {
                        swap(wordArray, j);
                    }
                }
            }

            for (String word : wordArray) {
                System.out.print(word + " ");
            }

            System.out.println();
        }
    }

    private static void sortLexeme(String text) {

        // Вводим букву, количество повторений которой будем считать
        System.out.println("Enter a character (from a to z) to sort lexemes:");
        String choice = enterLexeme();

        // Формируем массив из предложений
        String[] sentenceArray = createSentenceArray(text);

        for (String sentence : sentenceArray) {

            // Формируем массив из слов и сортируем их в алфавитном порядке
            String[] wordArray = createWordArray(sentence);
            Arrays.sort(wordArray, String::compareToIgnoreCase);
            //Arrays.sort(wordArray, (o1, o2) -> o1.compareToIgnoreCase(o2));

            for(int i = wordArray.length - 1; i > 0; i--) {
                for(int j = 0; j < i; j++) {
                    int counter1;
                    int counter2;

                    counter1 = findNumberOfRepetitions(wordArray, j, choice);
                    counter2 = findNumberOfRepetitions(wordArray, j + 1, choice);

                    if(counter1 < counter2) {
                        swap(wordArray, j);
                    }
                }
            }

            for (String word : wordArray) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }

    private static String[] createParagraphArray(String text) {
        Pattern paragraphPattern = Pattern.compile("\\n");

        return paragraphPattern.split(text);
    }

    private static String[] createSentenceArray(String paragraph) {
        Pattern sentencePattern = Pattern.compile("[!?.]{1,3}[\\s\\n]");

        return sentencePattern.split(paragraph);
    }

    private static String[] createWordArray(String sentence) {
        sentence = replacePunctuationMark(sentence);
        Pattern pattern = Pattern.compile("\\s+");

        return pattern.split(sentence);
    }

    private static String replacePunctuationMark(String sentence) {

        // Ищем знаки препинания в предложении и заменяем их на пробелы
        Pattern pattern = Pattern.compile("[\\W&&[^']]");
        Matcher matcher = pattern.matcher(sentence);

        return matcher.replaceAll(" ");
    }

    private static void swap(String[] wordArray, int index) {
        String tempValue = wordArray[index];
        wordArray[index] = wordArray[index + 1];
        wordArray[index + 1] = tempValue;
    }

    private static int findNumberOfRepetitions(String[] wordArray, int index, String input) {
        int counter = 0;

        for(int k = 0; k < wordArray[index].length(); k++) {
            if((wordArray[index].charAt(k) == input.charAt(0)) |
                    (wordArray[index].charAt(k) + 32 == input.charAt(0)) |
                        (wordArray[index].charAt(k) - 32 == input.charAt(0))) {

                counter += 1;
            }
        }

        return counter;
    }

    public static int enterNumber() {

        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int number;

        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.println("Wrong input. Try again.");
        }
        number = input.nextInt();

        return number;
    }

    public static String enterLexeme() {

        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        String lexeme = "";
        boolean isCorrectLexeme;

        isCorrectLexeme = false;

        while (!isCorrectLexeme) {
            lexeme = input.nextLine();

            if (lexeme.length() == 1) {
                if ((lexeme.charAt(0) >= 65 && lexeme.charAt(0) <= 90) |
                        (lexeme.charAt(0) >= 97 && lexeme.charAt(0) <= 122)) {

                    isCorrectLexeme = true;
                }
            } else {
                System.out.println("Wrong input. Try again.");
            }
        }

        return lexeme;
    }
}