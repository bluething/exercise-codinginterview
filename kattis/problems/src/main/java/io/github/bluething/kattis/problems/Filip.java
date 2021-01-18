package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Filip {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s+");

        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);

        int reversedNum1 = reverseNumber(num1);
        int reversedNum2 = reverseNumber(num2);

        System.out.println(reversedNum1 > reversedNum2 ? reversedNum1 : reversedNum2);

        bufferedReader.close();
    }

    private static int reverseNumber(int number) {
        int reversedNumber = 0;

        while (number > 0) {
            reversedNumber = (reversedNumber * 10) + (number % 10);
            number /= 10;
        }

        return reversedNumber;
    }

}
