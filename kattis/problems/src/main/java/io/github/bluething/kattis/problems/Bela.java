package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// The problem https://open.kattis.com/problems/bela
public class Bela {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s+");

        Map<String, Integer> scoresDominant = new HashMap<>();
        scoresDominant.put("A", 11);
        scoresDominant.put("K", 4);
        scoresDominant.put("Q", 3);
        scoresDominant.put("J", 20);
        scoresDominant.put("T", 10);
        scoresDominant.put("9", 14);
        scoresDominant.put("8", 0);
        scoresDominant.put("7", 0);

        Map<String, Integer> scoresNotDominant = new HashMap<>();
        scoresNotDominant.put("A", 11);
        scoresNotDominant.put("K", 4);
        scoresNotDominant.put("Q", 3);
        scoresNotDominant.put("J", 2);
        scoresNotDominant.put("T", 10);
        scoresNotDominant.put("9", 0);
        scoresNotDominant.put("8", 0);
        scoresNotDominant.put("7", 0);

        int numOfHand = Integer.parseInt(input[0]);
        String dominantSuit = input[1];

        String cards = "";
        String suit = "";
        String currentCard = "";
        int scores = 0;
        for (int i = 1; i <= 4 * numOfHand; i++) {
            cards = bufferedReader.readLine();
            suit = cards.substring(1);
            currentCard = cards.substring(0, 1);


            if (dominantSuit.equalsIgnoreCase(suit)) {
                scores += scoresDominant.get(currentCard);
            } else {
                scores += scoresNotDominant.get(currentCard);
            }

        }

        System.out.println(scores);

        bufferedReader.close();
    }

}
