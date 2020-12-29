package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// The problem https://open.kattis.com/problems/parking2
public class Parking2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfCase = Integer.parseInt(bufferedReader.readLine());

        int numOfStore = 0;
        String[] parkingSlots = null;
        List<Integer> parkingPos = null;
        for (int i = 1; i <= numOfCase; i++) {
            numOfStore = Integer.parseInt(bufferedReader.readLine());
            parkingSlots = bufferedReader.readLine().split("\\s+");
            parkingPos = new ArrayList<>();

            for (String parkingSlot : parkingSlots) {
                parkingPos.add(Integer.parseInt(parkingSlot));
            }

            Collections.sort(parkingPos);

            int minDistance = 0;
            for (int j = 0; j < numOfStore - 1; j++) {
                minDistance += parkingPos.get(j+1) - parkingPos.get(j);
            }
            System.out.println(minDistance * 2);
        }

        bufferedReader.close();
    }

    // clue
    // does not want to pay for more than one parking though.
    // does not mind carrying all the bags around.

}
