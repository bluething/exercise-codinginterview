package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QualityAdjustedLifeYear {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfLine = Integer.valueOf(bufferedReader.readLine());
        float qaly = 0;
        String[] input = null;
        for(int i = 1; i <= numberOfLine; i++) {
            input = bufferedReader.readLine().split("\\s+");
            qaly += Float.valueOf(input[0]) * Float.valueOf(input[1]);
        }
        System.out.print(qaly);
    }
}
