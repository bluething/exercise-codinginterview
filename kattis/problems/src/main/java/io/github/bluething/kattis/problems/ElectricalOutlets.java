package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The problem https://open.kattis.com/problems/electricaloutlets
public class ElectricalOutlets {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfCase = Integer.parseInt(bufferedReader.readLine());

        int numOfPowerStrip = 0;
        String[] inputs = null;
        int[] numOfAppliances = new int[numOfCase];

        for (int i = 0; i < numOfCase; i++) {
            numOfAppliances[i] = 1;

            inputs = bufferedReader.readLine().split("\\s+");
            numOfPowerStrip = Integer.parseInt(inputs[0]);

            if (numOfPowerStrip > 0) {
                numOfAppliances[i] = 0;
                int j = 0;
                for (; j < numOfPowerStrip - 1; j++) {
                    numOfAppliances[i] += Integer.parseInt(inputs[j+1]) - 1;
                }
                numOfAppliances[i] += Integer.parseInt(inputs[j+1]);
            }

        }

        for (int numOfAppliance : numOfAppliances) {
            System.out.println(numOfAppliance);
        }
    }

    // clue
    // without any power strips, Roy can power one single appliance through the wall outlet
    // a power strip has to be powered itself to be of any use

}
