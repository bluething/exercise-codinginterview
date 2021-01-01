package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/cold
public class ColdputerScience {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfTemp = Integer.parseInt(bufferedReader.readLine());
        String[] tempS = bufferedReader.readLine().split("\\s+");

        int temp = 0;
        int counter = 0;
        for (int i = 0; i < numOfTemp; i++) {
            temp = Integer.parseInt(tempS[i]);
            if(temp < 0) {
                counter++;
            }
        }

        System.out.println(counter);

        bufferedReader.close();
    }

}
