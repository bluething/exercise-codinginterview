package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/grassseed
public class GrassSeedInc {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        float cost = Float.parseFloat(bufferedReader.readLine());
        int numOfLawn = Integer.parseInt(bufferedReader.readLine());

        float width = 0.0f;
        float length = 0.0f;
        float totalCost = 0.0f;
        String[] size = new String[2];
        for (int i = 1; i <= numOfLawn; i++) {
            size = bufferedReader.readLine().split("\\s+");

            width = Float.parseFloat(size[0]);
            length = Float.parseFloat(size[1]);

            totalCost += width * length * cost;

        }

        System.out.printf("%.8f", totalCost);

        bufferedReader.close();
    }

}
