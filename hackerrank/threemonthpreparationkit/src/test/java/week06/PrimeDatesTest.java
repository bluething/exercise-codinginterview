package week06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Given two dates each in the format dd-mm-yyyy, you have to find the number of lucky dates between them (inclusive). To see if a date is lucky,
//
// Firstly, sequentially concatenate the date, month and year, into a new integer x erasing the leading zeroes.
// Now if x is divisible by either 4 or 7, then we call the date a lucky date.
// For example, let's take the date "02-08-2024". After concatenating the day, month and year, we get x = 2082024. As  is divisible by 4 so the date "02-08-2024" is called a lucky date.
// Print a single integer the number of lucky dates between 1 and 2 in a single line.
public class PrimeDatesTest {

    private int month[];

    @BeforeEach
    public void setupEach() {
        month = new int[15];
    }

    @Test
    public void case01() {
        Assertions.assertEquals(5, findPrimeDates(2, 8, 2025, 4, 9, 2025));
    }

    private int findPrimeDates(int d1, int m1, int y1, int d2, int m2, int y2) {
        storeMonth();

        int result = 0;

        while(true) {
            int x = d1;
            x = x * 100 + m1;
            x = x * 10000 + y1;
            if(x % 4 == 0 || x % 7 == 0) {
                result = result + 1;
            }
            if(d1 == d2 && m1 == m2 && y1 == y2) {
                break;
            }
            updateLeapYear(y1);
            d1 = d1 + 1;
            if(d1 > month[m1]) {
                m1 = m1 + 1;
                d1 = 1;
                if(m1 > 12) {
                    y1 =  y1 + 1;
                    m1 = 1;
                }
            }
        }
        return result;
    }
    private void storeMonth() {
        month[1] = 31;
        month[2] = 28;
        month[3] = 31;
        month[4] = 30;
        month[5] = 31;
        month[6] = 30;
        month[7] = 31;
        month[8] = 31;
        month[9] = 30;
        month[10] = 31;
        month[11] = 30;
        month[12] = 31;
    }

    private void updateLeapYear(int year) {
        if(year % 400 == 0) {
            month[2] = 29;
        } else if(year % 100 == 0) {
            month[2] = 28;
        } else if(year % 4 == 0) {
            month[2] = 29;
        } else {
            month[2] = 28;
        }
    }
}
