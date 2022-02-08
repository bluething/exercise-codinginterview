package week07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

// It is New Year's Day and people are in line for the Wonderland rollercoaster ride.
// Each person wears a sticker indicating their initial position in the queue from 1 to n.
// Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker. One person can bribe at most two others.
//
//Determine the minimum number of bribes that took place to get to a given queue order.
// Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.
public class NewYearChaosTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    public void tearDown() {
        System.setOut(originalOutput);
    }

    @Test
    public void case01() {
        minimumBribes(Arrays.asList(2, 1, 5, 3, 4));
        Assertions.assertEquals("3", output.toString());
    }

    @Test
    public void case02() {
        minimumBribes(Arrays.asList(2, 5, 1, 3, 4));
        Assertions.assertEquals("Too chaotic", output.toString());
    }

    @Test
    public void case03() {
        minimumBribes(Arrays.asList(1, 2, 5, 3, 4, 7, 8, 6));
        Assertions.assertEquals("4", output.toString());
    }

    @Test
    public void case04() {
        minimumBribes(Arrays.asList(5, 1, 2, 3, 7, 8, 6, 4));
        Assertions.assertEquals("Too chaotic", output.toString());
    }

    @Test
    public void case05() {
        minimumBribes(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));
        Assertions.assertEquals("7", output.toString());
    }

    // Check from last element if current element is wrong
    // Check the idx-1 and idx-2
    // If the right value at idx-1 swap
    // if the right value at idx-2 swap twice
    private void minimumBribes(List<Integer> q) {
        boolean isChaos = false;
        int currIdx = q.size() - 1;
        int counter = 0;
        int temp = 0;
        while (!isChaos && currIdx > 0) {
            int currValue = currIdx + 1;
            if (q.get(currIdx) != currValue) {
                if (q.get(currIdx - 1) == currValue) {
                    counter += 1;
                    temp = q.get(currIdx - 1);
                    q.set(currIdx - 1, q.get(currIdx));
                    q.set(currIdx, temp);
                } else if (q.get(currIdx - 2) == currValue) {
                    counter += 2;
                    temp = q.get(currIdx - 1);
                    q.set(currIdx - 1, q.get(currIdx));
                    q.set(currIdx, temp);
                    temp = q.get(currIdx - 2);
                    q.set(currIdx - 2, q.get(currIdx));
                    q.set(currIdx, temp);
                } else {
                    isChaos = true;
                }
            }

            currIdx--;
        }

        System.out.print(isChaos ? "Too chaotic" : counter);
    }
}
