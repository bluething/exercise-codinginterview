package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/upprodun
public class Arrangement {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        int remainingPopulation = m % n;
        int basePopulation = (m - remainingPopulation ) / n;

        for (int i = 1; i <= remainingPopulation; i++) {
            for (int j = 1; j <= (basePopulation + 1); j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for (int i = 1; i <= n - remainingPopulation; i++) {
            for (int j = 1; j <= (basePopulation); j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        bufferedReader.readLine();
    }

    // clue
    // as evenly as possible
    // order does not matter

}
