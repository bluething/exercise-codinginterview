package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/faktor
public class Faktor {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bufferedReader.readLine().split("\\s+");
        int numOfArticle = Integer.parseInt(inputs[0]);
        int impactFactor = Integer.parseInt(inputs[1]);

        int belowImpactFactor = impactFactor - 1;
        int belowNumOfArticlePublished = numOfArticle * belowImpactFactor;
        int numOfArticlePublished = belowNumOfArticlePublished + 1;

        System.out.print(numOfArticlePublished);

        bufferedReader.close();
    }

}
