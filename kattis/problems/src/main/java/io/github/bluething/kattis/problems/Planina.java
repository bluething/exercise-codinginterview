package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* The problem https://open.kattis.com/problems/planina
*   Just find the pattern
* */
public class Planina {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int iteration = Integer.parseInt(bufferedReader.readLine());
        int numOfPoint = (int) (Math.pow(Math.pow(2, iteration) + 1, 2));
        System.out.println(numOfPoint);
        bufferedReader.close();
    }
}
