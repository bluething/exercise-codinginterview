package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/patuljci
public class Patuljci {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarvesHat = new int[9];
        int totalDwarvesHatNumber = 0;
        for (int i = 0; i < 9; i++) {
            dwarvesHat[i] = Integer.parseInt(bufferedReader.readLine());
            totalDwarvesHatNumber += dwarvesHat[i];
        }

        int difference = totalDwarvesHatNumber - 100;

        for (int i = 0; i < dwarvesHat.length-1; i++) {
            for (int j = i+1; j < dwarvesHat.length; j++) {
                if (dwarvesHat[i] + dwarvesHat[j] == difference) {
                    dwarvesHat[i] = 0;
                    dwarvesHat[j] = 0;
                    j = dwarvesHat.length;
                    i = dwarvesHat.length;
                }
            }
        }

        for (int i = 0; i < dwarvesHat.length; i++) {
            if (dwarvesHat[i] != 0) {
                System.out.println(dwarvesHat[i]);
            }
        }

        bufferedReader.close();
    }

    // clue
    // All of the numbers will be distinct.
    // 9 lines of input. Each contains an integer between 1 and 99 (inclusive)
    // the sum of numbers on the hats of her seven dwarves was exactly 100
    // pick seven of nine numbers that add to 100
    // 100 - sum of 9 dwarves, find 2 dwarves that the sum equal to difference
}
