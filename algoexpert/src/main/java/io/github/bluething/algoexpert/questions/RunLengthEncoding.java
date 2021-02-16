package io.github.bluething.algoexpert.questions;

public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
        System.out.println(runLengthEncoding("122333"));
        System.out.println(runLengthEncoding("........______=========AAAA   AAABBBB   BBB"));
        System.out.println(runLengthEncoding("aA"));
    }

    public static String runLengthEncoding(String string) {
        char lastChar = (char) 0;
        char currChar = (char) 0;
        int counter = 1;
        StringBuilder encodedString = new StringBuilder("");
        for (int i = 1; i < string.length(); i++) {
            lastChar = string.charAt(i - 1);
            currChar = string.charAt(i);
            if (currChar != lastChar || counter == 9) {
                encodedString.append(String.valueOf(counter)).append(String.valueOf(lastChar));
                counter = 0;
            }
            counter++;
        }
        encodedString.append(String.valueOf(counter)).append(string.charAt(string.length() -  1));

        return encodedString.toString();
    }
}
