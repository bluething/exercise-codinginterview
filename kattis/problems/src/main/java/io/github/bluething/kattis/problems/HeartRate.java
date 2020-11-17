package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/heartrate
public class HeartRate {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCases = Integer.parseInt(bufferedReader.readLine());

        String inputCase = "";
        int b = 0;
        float p = 0.0f;
        float bpm = 0;
        float abpm = 0;
        for(int i = 1; i <= numOfTestCases; i++) {
            inputCase = bufferedReader.readLine();
            b = Integer.parseInt(inputCase.split("\\s+")[0]);
            p = Float.valueOf(inputCase.split("\\s+")[1]);

            bpm = 60*b / p;
            abpm = 60 / p;
            System.out.printf("%f %f %f%n", bpm-abpm, bpm, bpm+abpm);

        }

        bufferedReader.close();
    }

}
