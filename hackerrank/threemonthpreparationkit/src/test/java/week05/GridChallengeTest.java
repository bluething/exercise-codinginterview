package week05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GridChallengeTest {

    @Test
    public void case01() {
        Assertions.assertEquals("YES", gridChallenge(Arrays.asList("ebacd", "fghij", "olmkn", "trpqs", "xywuv")));
    }

    private String gridChallenge(List<String> grid) {
        char[] prevLine = grid.get(0).toCharArray();
        Arrays.sort(prevLine);

        boolean result = true;
        int i = 1;
        while (result && i < grid.size()){
            char[] currLine = grid.get(i).toCharArray();
            Arrays.sort(currLine);

            for (int j = 0; j < currLine.length; j++) {
                if (prevLine[j] > currLine[j]) {
                    result = false;
                    break;
                }
            }

            prevLine = currLine;
            i++;
        }

        return result ? "YES" : "NO";
    }
}
