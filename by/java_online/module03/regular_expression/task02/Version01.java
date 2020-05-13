/*
 * Дана строка, содержащая следующий текст (xml-документ).
 * Напишите анализатор, позволяющий последовательно возвращать
 * содержимое узлов xml-документа и его тип (открывающий тег,
 * закрывающий тег, содержимое тега, тег без тела).
 * Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
 */

package by.java_online.module03.regular_expression.task02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Version01 {
    public static void main(String[] args) {
        String document = "<notes>\n" +
                          "<note id=\"1\">\n" +
                          "<to>Вася</to>\n" +
                          "<from>Света</from>\n" +
                          "<heading>Напоминание</heading>\n" +
                          "<body>Позвони мне завтра!</body>\n" +
                          "</note>\n" +
                          "<note id=\"2\">\n" +
                          "<to>Петя</to>\n" +
                          "<from>Маша</from>\n" +
                          "<heading>Важное напоминание</heading>\n" +
                          "<body/>\n" +
                          "</note>\n" +
                          "</notes>";

        parseDocument(document);
    }

    private static void parseDocument(String document) {
        Pattern startTag = Pattern.compile("((<\\w*?>)|(<\\w*\\s\\w*=\"\\w*\">))");
        Pattern emptyElementTag = Pattern.compile("<\\w*/>");
        Pattern endTag = Pattern.compile("</\\w*?>");
        Pattern contents = Pattern.compile("[А-Я].*[[а-я]!]");

        String[] lines = document.split("\n");

        for (String line : lines) {
            Matcher startTagMatcher = startTag.matcher(line);
            Matcher emptyElementTagMatcher = emptyElementTag.matcher(line);
            Matcher endTagMatcher = endTag.matcher(line);
            Matcher contentsMatcher = contents.matcher(line);

            if (startTagMatcher.find()) {
                System.out.println(startTagMatcher.group() + " - start-tag");
            } else if (emptyElementTagMatcher.find()) {
                System.out.println(startTagMatcher.group() + " - empty-element tag");
            } else if (endTagMatcher.find()) {
                System.out.println(startTagMatcher.group() + " - end-tag");
            } else if (contentsMatcher.find()) {
                System.out.println(startTagMatcher.group() + " - contents");
            }
        }
    }
}

