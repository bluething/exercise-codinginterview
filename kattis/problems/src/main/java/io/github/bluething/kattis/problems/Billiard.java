package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/billiard
public class Billiard {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = new String[5];
        int a = 0;
        int b = 0;
        int s = 0;
        int m = 0;
        int n = 0;
        double horizontalDistance = 0.0;
        double verticalDistance = 0.0;
        double angle = 0.0;
        double velocity = 0.0;

        while (true) {
            input = bufferedReader.readLine().split("\\s+");

            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            s = Integer.parseInt(input[2]);
            m = Integer.parseInt(input[3]);
            n = Integer.parseInt(input[4]);

            if (a == 0) {
                break;
            }

            verticalDistance = n * b;
            horizontalDistance = m * a;
            angle = Math.toDegrees(Math.atan(verticalDistance / horizontalDistance));
            velocity = Math.sqrt((horizontalDistance * horizontalDistance) + (verticalDistance * verticalDistance)) / s;

            System.out.printf("%.2f %.2f%n", angle, velocity);

        }

        bufferedReader.close();
    }


    // clue
    // launched from the middle of the table. After s>0 seconds the ball returns to the point from which it was launched
    // means each horizontal bounce covered the distance b (vertical)
    // and each vertical bounce covered the distance a (horizontal)
    // remember tangen!
}
