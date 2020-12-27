package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/hangingout
public class HangingOutontheTerrace {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s+");
        int maxCapa = Integer.parseInt(input[0]);
        int numOfEvent = Integer.parseInt(input[1]);

        int numOfRejectedGroups = 0;
        int currentCapa = 0;
        String[] event = new String[2];
        for (int i = 1; i <= numOfEvent; i++) {
            event = bufferedReader.readLine().split("\\s+");
            if ("enter".equals(event[0])) {
                currentCapa += Integer.parseInt(event[1]);
            } else {
                currentCapa -= Integer.parseInt(event[1]);
            }
            if (currentCapa > maxCapa) {
                currentCapa -= Integer.parseInt(event[1]);
                numOfRejectedGroups++;
            }
        }

        System.out.println(numOfRejectedGroups);

        bufferedReader.close();
    }

}
