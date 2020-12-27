package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/autori
public class Autori {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        StringBuilder output = new StringBuilder();
        output.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if('-' == input.charAt(i)) {
                output.append(input.charAt(++i));
            }
        }

        System.out.println(output.toString());

        bufferedReader.close();
    }

    // clue:
    // The first character will always be an uppercase letter.
    // Hyphens will always be followed by an uppercase letter.

}
