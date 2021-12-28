package week01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Given a time in -hour AM/PM format, convert it to military (24-hour) time.
//
//Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
//- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
public class TimeConversionTest {

    @Test
    public void case01() {
        Assertions.assertEquals("19:05:45", timeConversion("07:05:45PM"));
    }

    @Test
    public void case02() {
        Assertions.assertEquals("00:00:00", timeConversion("12:00:00AM"));
    }

    @Test
    public void case03() {
        Assertions.assertEquals("04:59:59", timeConversion("04:59:59AM"));
    }

    private String timeConversion(String s) {
        int hour = Integer.valueOf(s.substring(0, 2));
        int minute = Integer.valueOf(s.substring(3, 5));
        int second = Integer.valueOf(s.substring(6, 8));
        boolean isAM = s.substring(8).equals("AM") ?  true : false;

        if (isAM) {
            hour = hour % 12;
        } else {
            hour = (hour % 12) + 12;
        }

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
