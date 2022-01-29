package week06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Watson gives Sherlock an array of integers.
// His challenge is to find an element of the array such that the sum of all elements to the left is equal to the sum of all elements to the right.
public class SherlockAndArrayTest {

    @Test
    public void case01() {
        Assertions.assertEquals("NO", balancedSums(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals("YES", balancedSums(Arrays.asList(1, 2, 3, 3)));
    }

    @Test
    public void case03() {
        Assertions.assertEquals("NO", balancedSums(Arrays.asList(75, 426, 445, 272, 81, 447, 129, 497, 202, 275,
                325, 482, 284, 417, 156, 432, 402, 228, 37, 357, 239, 418, 211, 179, 6, 340, 68, 368, 16, 440, 263, 93,
                449, 491, 310, 355, 68, 431, 80, 257, 218, 434, 328, 176, 355, 221, 80, 422, 45, 11, 67, 467, 174, 191,
                4, 335, 34, 465, 480, 221, 395, 1, 152, 325, 231, 302, 153, 396, 22, 489, 399, 107, 466, 432, 2, 468,
                333, 475, 292, 84, 10, 194, 328, 354, 212, 409, 480, 143, 121, 451, 492, 420, 197, 107, 425, 167, 217,
                438, 200, 486, 104, 483, 120, 306, 381, 358, 59, 53, 2, 54, 462, 325, 435, 279, 464, 327, 49, 332, 95,
                200, 220, 158, 139, 492, 130, 467, 489, 458, 81, 100, 466, 473, 429, 275, 81, 270, 455, 218, 128, 307,
                335, 398, 52, 30, 311, 69, 148, 384, 454, 413, 114, 315, 186, 334, 382, 392, 326, 8, 53, 462, 457, 350,
                231, 61, 185, 88, 305, 480, 64, 390, 52, 247, 443, 240, 93, 469, 370, 16, 443, 7, 25, 299, 412, 163, 199,
                71, 476, 455, 217, 90, 343, 427, 220, 342, 84, 239, 496, 375, 101, 258, 449, 377, 40, 428, 238, 455, 17,
                153, 433, 268, 457, 307, 456, 378, 477, 368, 499, 382, 41, 326, 264, 269, 401, 98, 198, 263, 15, 413, 495,
                23, 71, 206, 357, 404, 310, 410, 344, 111, 484, 410, 59, 262, 394, 449, 107, 46, 237, 487, 479, 306, 185,
                291, 42, 42, 134, 94, 251, 89, 398, 229, 212, 464, 297, 323, 220, 297, 280, 417, 338, 176, 183, 465, 240,
                41, 55, 3, 316, 256, 13, 111, 474, 431, 24, 109, 176, 304, 151, 199, 376, 325, 393, 439, 237, 374, 323,
                346, 319, 154, 157, 314, 343, 386, 197, 100, 356, 209, 379, 479, 461, 14, 123, 244, 400, 94, 447, 20, 152,
                463, 174, 329, 484, 430, 322, 165, 146, 385, 191, 353, 105, 110, 453, 356, 243, 194, 354, 297, 75, 331, 474,
                220, 337, 195, 345, 154, 173, 306, 365, 24, 452, 231, 329, 353, 331, 192, 27, 413, 81, 438, 63, 358, 358,
                266, 301, 95, 374, 307, 51, 368, 478, 309, 304, 7, 308, 492, 499, 150, 206, 399, 322, 198, 15, 381, 267,
                282, 237, 119, 111, 426, 444, 288, 326, 444, 202, 388, 444, 155, 21, 489, 446, 131, 116, 445, 154, 434, 22,
                350, 183, 42, 226, 241, 486, 101, 161, 32, 461, 68, 403, 276, 258, 272, 266, 259, 224, 336, 241, 54, 18, 325,
                395, 449, 425, 56, 350, 378, 211, 83, 184, 290, 59, 445, 345, 268, 322, 1, 55, 272, 285, 175, 312, 165, 321,
                420, 196, 16, 357, 149, 448, 307, 35, 91, 284, 82, 268, 398, 174, 341, 439, 93, 217, 3, 334, 268, 471, 465,
                121, 83, 103, 366, 149, 232, 276, 488, 238, 64, 236, 273, 70, 122, 274, 132, 60, 455, 248, 380, 61, 389,
                454, 320, 34, 233)));
    }

    @Test
    public void case04() {
        Assertions.assertEquals("YES", balancedSums(Arrays.asList(1, 1, 4, 1, 1)));
    }

    @Test
    public void case05() {
        Assertions.assertEquals("YES", balancedSums(Arrays.asList(2, 0, 0, 0)));
    }

    @Test
    public void case06() {
        Assertions.assertEquals("YES", balancedSums(Arrays.asList(0, 0, 2, 0)));
    }

    private String balancedSums(List<Integer> arr) {
        String balanceResult = "NO";

        long rightSum = 0;
        for (int i = 1; i < arr.size(); i++) {
            rightSum += arr.get(i);
        }

        long leftSum = 0;
        if (leftSum == rightSum) {
            balanceResult = "YES";
        } else {
            for (int i = 1; i < arr.size() - 1; i++) {
                leftSum += arr.get(i -1);
                rightSum -= + arr.get(i);
                if (rightSum == leftSum) {
                    balanceResult = "YES";
                    break;
                }
            }
        }

        return balanceResult;
    }
}
