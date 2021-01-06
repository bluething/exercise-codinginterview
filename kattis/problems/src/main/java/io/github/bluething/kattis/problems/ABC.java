package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// The problem https://open.kattis.com/problems/abc
public class ABC {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numberInString = bufferedReader.readLine().split("\\s+");
        char[] orders = bufferedReader.readLine().toCharArray();

        int[] numbers = new int[3];
        numbers[0] = Integer.parseInt(numberInString[0]);
        numbers[1] = Integer.parseInt(numberInString[1]);
        numbers[2] = Integer.parseInt(numberInString[2]);
        Arrays.sort(numbers);


        for (char order : orders) {
            if ('A' == order) {
                System.out.print(numbers[0] + " ");
            } else if ('B' == order) {
                System.out.print(numbers[1] + " ");
            } else {
                System.out.print(numbers[2] + " ");
            }
        }

        bufferedReader.close();
    }

}
