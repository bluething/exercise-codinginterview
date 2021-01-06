package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/dicecup
public class DiceCup {

    public static void main(String[] main) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numberString = bufferedReader.readLine().split("\\s+");

        int n = Integer.parseInt(numberString[0]);
        int m = Integer.parseInt(numberString[1]);

        for (int i = Integer.min(n, m) + 1; i <= Integer.max(n, m) + 1; i++) {
            System.out.println(i);
        }

        bufferedReader.close();
    }

}
