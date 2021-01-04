package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/fizzbuzz
public class FizzBuzz {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = bufferedReader.readLine().split("\\s+");

        int x = Integer.parseInt(testCase[0]);
        int y = Integer.parseInt(testCase[1]);
        int n = Integer.parseInt(testCase[2]);

        for (int i = 1; i <= n; i++) {
            if (i % x == 0 && i % y ==0) {
                System.out.println("FizzBuzz");
            } else if (i % x == 0) {
                System.out.println("Fizz");
            } else if (i % y ==0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

        bufferedReader.close();
    }

}
