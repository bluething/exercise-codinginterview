package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/r2
public class R2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] arguments = bufferedReader.readLine().split("\\s+");

        int r1 = Integer.parseInt(arguments[0]);
        int s = Integer.parseInt(arguments[1]);

        int r2 = 2*s - r1;

        System.out.println(r2);

        bufferedReader.close();
    }
}
