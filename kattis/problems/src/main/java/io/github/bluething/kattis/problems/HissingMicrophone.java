package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/hissingmicrophone
public class HissingMicrophone {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();

        char[] words = word.toCharArray();
        boolean isHissing = false;
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i] == 's' && words[i + 1] == 's') {
                isHissing = true;
            }
        }
        if (isHissing) {
            System.out.println("hiss");
        } else {
            System.out.println("no hiss");
        }

        bufferedReader.close();
    }

}
