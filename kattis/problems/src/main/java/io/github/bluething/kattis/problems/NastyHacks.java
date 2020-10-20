package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* The problem https://open.kattis.com/problems/nastyhacks
* */
public class NastyHacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfCases = Integer.parseInt(bufferedReader.readLine());
        String testCase = "";
        String[] values = {};
        String[] results = new String[numOfCases];
        int netRevenueWithAdv = 0;
        for (int caze = 1; caze <= numOfCases; caze++) {
            testCase = bufferedReader.readLine();
            values = testCase.split("\\s+");
            netRevenueWithAdv = Integer.parseInt(values[1]) - Integer.parseInt(values[2]);
            if(Integer.parseInt(values[0]) > netRevenueWithAdv) {
                results[caze-1] = "do not advertise";
            } else if(Integer.parseInt(values[0]) < netRevenueWithAdv) {
                results[caze-1] = "advertise";
            } else {
                results[caze-1] = "does not matter";
            }
        }
        for (String result : results) {
            System.out.println(result);
        }

        bufferedReader.close();
    }
}
