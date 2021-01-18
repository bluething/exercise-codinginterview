package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/cetvrta
public class Cetvrta {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] point1 = bufferedReader.readLine().split("\\s+");
        String[] point2 = bufferedReader.readLine().split("\\s+");
        String[] point3 = bufferedReader.readLine().split("\\s+");

        int x1 = Integer.parseInt(point1[0]);
        int y1 = Integer.parseInt(point1[1]);
        int x2 = Integer.parseInt(point2[0]);
        int y2 = Integer.parseInt(point2[1]);
        int x3 = Integer.parseInt(point3[0]);
        int y3 = Integer.parseInt(point3[1]);

        int x4 = 0;
        int y4 = 0;

        if (x1 == x2) {
            x4 = x3;
            if (y3 == y1) {
                y4 = y2;
            } else {
                y4 = y1;
            }
        } else if (x1 == x3) {
            x4 = x2;
            if (y2 == y1) {
                y4 = y3;
            } else {
                y4 = y1;
            }
        } else {
            x4 = x1;
            if (y2 == y1) {
                y4 = y3;
            } else {
                y4 = y2;
            }
        }

        System.out.printf("%d %d", x4, y4);

        bufferedReader.close();
    }

}
