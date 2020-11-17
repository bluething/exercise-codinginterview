package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/twostones
public class TakeTwoStones {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfStones = Integer.parseInt(bufferedReader.readLine());
        int numOfRemainingStones = numOfStones % 2;

        if (numOfRemainingStones == 1) {
            System.out.println("Alice");
        } else {
            System.out.println("Bob");
        }

        bufferedReader.close();
    }

}
