package by.java_online.module03.regular_expression.task02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Version02 {
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
        String regEx = "((<.*?>)|([А-Я].*[[а-я]!]))";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(document);

        while (matcher.find()) {
            String part = matcher.group();

            if (part.charAt(0) == '<' && part.charAt(part.length() - 1) == '>') {

                if (part.charAt(1) == '/') {
                    System.out.println(part + " - end-tag");
                } else if (part.charAt(part.length() - 2) == '/') {
                    System.out.println(part + " - empty-element tag");
                } else {
                    System.out.println(part + " - start-tag");
                }

            } else {
                System.out.println(part + " - contents");
            }
        }
    }
}
