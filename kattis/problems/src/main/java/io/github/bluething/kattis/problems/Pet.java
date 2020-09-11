package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* The problem https://open.kattis.com/problems/pet
* */
public class Pet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int maxScore = 0;
        int idx = 0;
        String input;
        String[] scores = new String[4];
        int score = 0;
        for (int i = 1; i <= 5; i++) {
            input = bufferedReader.readLine();
            score = 0;
            scores = input.split("\\s+");
            for (String scoreString : scores) {
                score += Integer.parseInt(scoreString);
            }
            if(maxScore < (score)) {
                maxScore = score;
                idx = i;
            }
        }
        System.out.printf("%d %d", idx, maxScore);
        bufferedReader.close();
    }
}
