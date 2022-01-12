package week03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ZigZagSequenceTest {
    @Test
    public void case01() {
        int[] input = new int[]{2, 3, 5, 1, 4};
        findZigZagSequence(input, 5);
        Assertions.assertArrayEquals(new int[]{1, 2, 5, 4, 3}, input);
    }

    @Test
    public void case02() {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        findZigZagSequence(input, 7);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 7, 6, 5, 4}, input);
    }

    private void findZigZagSequence(int [] a, int n) {
        Arrays.sort(a);
        int mid = n / 2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while (st <= ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
    }
}
