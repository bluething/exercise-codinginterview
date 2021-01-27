package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/vauvau
public class Vauvau {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] dogBehaviour = bufferedReader.readLine().split("\\s+");
        String[] heroesArrivals = bufferedReader.readLine().split("\\s+");

        Integer dogABark = Integer.parseInt(dogBehaviour[0]);
        Integer dogACalm = Integer.parseInt(dogBehaviour[1]);
        Integer dogACycle = dogABark + dogACalm;
        Integer dogBBark = Integer.parseInt(dogBehaviour[2]);
        Integer dogBCalm = Integer.parseInt(dogBehaviour[3]);
        Integer dogBCycle = dogBBark + dogBCalm;

        Integer heroesArrival = Integer.valueOf(0);

        int numOfDogs = 0;
        for (int i = 0; i < heroesArrivals.length; i++) {
            numOfDogs = 0;
            heroesArrival = Integer.parseInt(heroesArrivals[i]);
            if (heroesArrival % dogACycle > 0 && heroesArrival % dogACycle <= dogABark) {
                numOfDogs++;
            }
            if (heroesArrival % dogBCycle > 0 && heroesArrival % dogBCycle <= dogBBark) {
                numOfDogs++;
            }
            if (numOfDogs == 2) {
                System.out.println("both");
            } else if (numOfDogs == 1) {
                System.out.println("one");
            } else {
                System.out.println("none");
            }
        }

        bufferedReader.close();
    }

}
