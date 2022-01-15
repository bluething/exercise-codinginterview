package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// You are choreographing a circus show with various animals.
// For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).
//
//The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
//The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
public class NumberLineJumpsTest {

    @Test
    public void case01() {
        Assertions.assertEquals("YES", kangaroo(2, 1, 1, 2));
    }

    @Test
    public void case02() {
        Assertions.assertEquals("NO", kangaroo(21,6 ,47, 3));
    }

    private String kangaroo(int x1, int v1, int x2, int v2) {
        String possibility = "NO";
        if ((x1 < x2) && (v1 > v2)) {
            if ((x2 - x1) % (v1 - v2) == 0) {
                possibility = "YES";
            }
        } else if ((x1 > x2) && (v1 < v2)) {
            if ((x1 - x2) % (v2 - v1) == 0) {
                possibility = "YES";
            }
        }

        return possibility;
    }
}
