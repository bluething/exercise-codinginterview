package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* The problem https://open.kattis.com/problems/zamka
* Clue is "The numbers N and M will always exist"
* */
public class Zamka {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(bufferedReader.readLine());
        int d = Integer.parseInt(bufferedReader.readLine());
        int x = Integer.parseInt(bufferedReader.readLine());
        int n = 0, m = 0;
        while (true) {
            n = getDigitSum(l);
            if(n == x) {
                break;
            }
            l++;
        }
        while (true) {
            m = getDigitSum(d);
            if(m == x) {
                break;
            }
            d--;
        }
        System.out.println(l);
        System.out.println(d);
        bufferedReader.close();
    }

    static int getDigitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n/10;
        }
        return sum;
    }
}
