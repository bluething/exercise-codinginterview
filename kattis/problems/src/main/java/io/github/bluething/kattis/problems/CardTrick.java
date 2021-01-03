package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

// The problem https://open.kattis.com/problems/cardtrick2
public class CardTrick {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCase = Integer.parseInt(bufferedReader.readLine());

        List<Integer> deck = new LinkedList<>();
        int cards = 0;

        for (int i = 1; i <= numOfTestCase; i++) {
            cards = Integer.parseInt(bufferedReader.readLine());
            deck = new LinkedList<>();
            deck.add(cards);

            while (--cards > 0) {
                deck.add(cards);

                for (int j = 0; j < cards; j++) {
                    deck.add(deck.get(0));
                    deck.remove(0);
                }
            }

            for (int k = deck.size() - 1; k >= 0; k--) {
                System.out.print(deck.get(k) + " ");
            }
        }

        bufferedReader.close();
    }

}
