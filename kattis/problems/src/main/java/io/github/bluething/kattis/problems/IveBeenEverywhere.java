package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
* The problem https://open.kattis.com/problems/everywhere
* */
public class IveBeenEverywhere {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        int numOfTrips = 0;
        Set<String> uniqueCites = null;
        int[] results = new int[testCases];
        for (int caze = 1; caze <= testCases; caze++) {
            numOfTrips = Integer.parseInt(bufferedReader.readLine());
            uniqueCites = new HashSet<>();
            for (int trip = 1; trip <= numOfTrips; trip++) {
                uniqueCites.add(bufferedReader.readLine());
            }
            results[caze-1] = uniqueCites.size();
        }
        for (int result : results) {
            System.out.println(result);
        }

        bufferedReader.close();
    }
}
