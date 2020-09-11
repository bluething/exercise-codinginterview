package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* The problem https://open.kattis.com/problems/pot
* */
public class Pot {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfLine = Integer.valueOf(bufferedReader.readLine());
        String input;
        int originalTask = 0;
        for(int i = 1; i <= numberOfLine; i++) {
            input = bufferedReader.readLine();
            int pow = Integer.parseInt(input.substring(input.length()-1));
            int number = Integer.parseInt(input.substring(0, input.length()-1));
            originalTask += Math.pow(number, pow);
        }
        System.out.println(originalTask);
        bufferedReader.close();
    }
}
