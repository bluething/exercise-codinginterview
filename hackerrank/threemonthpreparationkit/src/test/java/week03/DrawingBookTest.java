package week03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// A teacher asks the class to open their books to a page number.
// A student can either start turning pages from the front of the book or from the back of the book.
// They always turn pages one at a time. When they open the book, page 1 is always on the right side.
//
// When they flip page 1, they see pages 2 and 3.
// Each page except the last page will always be printed on both sides. The last page may only be printed on the front, given the length of the book.
// If the book is n pages long, and a student wants to turn to page , what is the minimum number of pages to turn? They can start at the beginning or the end of the book.
//
//Given n and p, find and print the minimum number of pages that must be turned in order to arrive at page p.
public class DrawingBookTest {

    @Test
    public void case01() {
        Assertions.assertEquals(1, pageCount(5, 3));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(0, pageCount(5, 4));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(1, pageCount(6, 2));
    }

    // Remember, we can flip from front or back
    // If p less than equal half of pages then we need to flip p divide by 2 (from front)
    // Then if we need to flip from back, check if the page requested even or odd
    private int pageCount(int n, int p) {
        int numOfPages = 0;
        if (p <= n/2) {
            numOfPages = p / 2;
        } else if (p % 2 == 0) {
            numOfPages = (n - p) / 2;
        } else {
            numOfPages = (n - p + 1) / 2;
        }

        return numOfPages;
    }
}
