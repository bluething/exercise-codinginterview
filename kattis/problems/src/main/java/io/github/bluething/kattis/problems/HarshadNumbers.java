package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/harshadnumbers
public class HarshadNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String numInString = bufferedReader.readLine();
        int num = Integer.parseInt(numInString);

        while (!checkHarshed(num)) {
            num++;
        }

        System.out.println(num);

        bufferedReader.close();
    }

    private static boolean checkHarshed(int number) {
        int sumOfDigit = 0;
        int remaining = number;
        while (remaining > 9) {
            sumOfDigit += remaining % 10;
            remaining = remaining / 10;
        }

        sumOfDigit += remaining;

        return number % sumOfDigit == 0;
    }

}
