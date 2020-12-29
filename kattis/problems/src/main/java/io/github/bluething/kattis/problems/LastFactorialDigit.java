package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/lastfactorialdigit
public class LastFactorialDigit {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfCase = Integer.parseInt(bufferedReader.readLine());

        int n = 0;
        int lastFactorialDigit = 0;
        for (int i = 1; i <= numOfCase; i++) {
            n = Integer.parseInt(bufferedReader.readLine());
            lastFactorialDigit = factorial(n) % 10;
            System.out.println(lastFactorialDigit);
        }

        bufferedReader.close();
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
