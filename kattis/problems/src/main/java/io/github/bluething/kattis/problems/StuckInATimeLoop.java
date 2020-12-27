package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/timeloop
public class StuckInATimeLoop {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int countLoop = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= countLoop; i++) {
            System.out.println(i + " Abracadabra");
        }

        bufferedReader.close();
    }

}
