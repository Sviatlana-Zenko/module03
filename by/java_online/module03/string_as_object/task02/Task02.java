/*
 * В строке вставить после каждого символа 'a' символ 'b'.
 */

package by.java_online.module03.string_as_object.task02;

public class Task02 {
    public static void main(String[] args) {
        String line = "We can modify XML file in Java using DOM parser.";

        String modifiedLine = line.replaceAll("a", "ab");

        System.out.println("Original string:\n" + line +
                           "\nNew string:\n" + modifiedLine);
    }
}
