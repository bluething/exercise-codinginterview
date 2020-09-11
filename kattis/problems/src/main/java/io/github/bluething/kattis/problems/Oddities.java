package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* The problem https://open.kattis.com/problems/oddities
* Even is if number module 2 is 0
* */
public class Oddities {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfTest = Integer.parseInt(bufferedReader.readLine());
        int input;
        for (int i = 1; i <= numOfTest; i++) {
            input = Integer.parseInt(bufferedReader.readLine());
            if(input % 2 == 0) {
                System.out.printf("%d is even\n", input);
            } else {
                System.out.printf("%d is odd\n", input);
            }
        }
        bufferedReader.close();
    }
}
