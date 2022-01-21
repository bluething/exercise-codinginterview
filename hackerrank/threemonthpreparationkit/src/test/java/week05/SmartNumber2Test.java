package week05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmartNumber2Test {

    @Test
    public void case01() {
        Assertions.assertTrue(isSmartNumber(1));
    }

    @Test
    public void case02() {
        Assertions.assertFalse(isSmartNumber(2));
    }

    @Test
    public void case03() {
        Assertions.assertFalse(isSmartNumber(7));
    }

    @Test
    public void case04() {
        Assertions.assertTrue(isSmartNumber(169));
    }

    private boolean isSmartNumber(int num) {
        int val = (int) Math.sqrt(num);
        if(num == val * val)
            return true;
        return false;
    }
}
