package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/tarifa
public class Tarifa {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int fairUsage = Integer.parseInt(bufferedReader.readLine());
        int numOfMonth = Integer.parseInt(bufferedReader.readLine());

        int sumOfRemainingUsage = 0;
        for (int i = 1; i <= numOfMonth; i++) {
            sumOfRemainingUsage += fairUsage - Integer.parseInt(bufferedReader.readLine());
        }

        sumOfRemainingUsage = sumOfRemainingUsage < 0 ? 0 : sumOfRemainingUsage;

        int maxSpentQuota = fairUsage + sumOfRemainingUsage;

        System.out.println(maxSpentQuota);

        bufferedReader.close();
    }

}
