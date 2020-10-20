package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
* The problem https://open.kattis.com/problems/nodup
* */
public class NoDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String phrase = bufferedReader.readLine();
        String[] words = phrase.split("\\s+");
        Set<String> uniqueWords = new HashSet<>();
        boolean repeated = false;
        for (String word : words) {
            if(!uniqueWords.add(word)) {
                repeated = true;
                break;
            }
        }
        if(repeated) {
            System.out.print("no");
        } else {
            System.out.print("yes");
        }
    }
}
