package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolvingForCarrots {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] inputs = input.split("\\s+");
        for (int i = 1; i <= Integer.valueOf(inputs[0]); i++) {
            bufferedReader.readLine();
        }
        System.out.print(Integer.valueOf(inputs[1]));
    }
}
