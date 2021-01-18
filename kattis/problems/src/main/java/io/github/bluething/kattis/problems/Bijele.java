package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bijele {

    private static final int NUM_OF_KING = 1;
    private static final int NUM_OF_QUEEN = 1;
    private static final int NUM_OF_ROOKS = 2;
    private static final int NUM_OF_BISHOPS = 2;
    private static final int NUM_OF_KNIGHTS = 2;
    private static final int NUM_OF_PAWNS = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bufferedReader.readLine().split("\\s+");

        int king = Integer.parseInt(inputs[0]);
        int queen = Integer.parseInt(inputs[1]);
        int rooks = Integer.parseInt(inputs[2]);
        int bishops = Integer.parseInt(inputs[3]);
        int knights = Integer.parseInt(inputs[4]);
        int pawns = Integer.parseInt(inputs[5]);

        System.out.printf("%d %d %d %d %d %d",
                NUM_OF_KING - king,
                NUM_OF_QUEEN - queen,
                NUM_OF_ROOKS - rooks,
                NUM_OF_BISHOPS - bishops,
                NUM_OF_KNIGHTS - knights,
                NUM_OF_PAWNS - pawns);

        bufferedReader.close();
    }

}
