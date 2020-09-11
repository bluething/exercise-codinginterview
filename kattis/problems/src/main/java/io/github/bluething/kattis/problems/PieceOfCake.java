package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* The problem https://open.kattis.com/problems/pieceofcake2
* The clue "the biggest piece of cake should go to Greg since it is his birthday"
* So the given h & v doesn't mean the slice is smaller
* We need to compare n-h with h, which one is bigger
* */
public class PieceOfCake {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] inputs = input.split("\\s+");
        int n = Integer.parseInt(inputs[0]);
        int h = Integer.parseInt(inputs[1]);
        int v = Integer.parseInt(inputs[2]);
        int biggestArea = Integer.max(n-h, h) * Integer.max(n-v, v);
        int biggestVolume = biggestArea * 4;
        System.out.print(biggestVolume);
    }
}
