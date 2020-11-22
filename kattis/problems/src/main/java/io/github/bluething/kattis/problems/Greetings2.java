package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/greetings2
public class Greetings2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String greeting = bufferedReader.readLine();

        int numOfeChar = greeting.length() - 2;

        StringBuilder greetingResponse = new StringBuilder("h");
        for (int i = 1; i <= numOfeChar*2; i++) {
            greetingResponse.append("e");
        }
        greetingResponse.append("y");

        System.out.println(greetingResponse.toString());


        bufferedReader.close();
    }

}
