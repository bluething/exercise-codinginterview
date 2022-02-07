package week07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Bomberman lives in a rectangular grid. Each cell in the grid either contains a bomb or nothing at all.
//
// Each bomb can be planted in any cell of the grid but once planted, it will detonate after exactly 3 seconds.
//  Once a bomb detonates, it's destroyed — along with anything in its four neighboring cells.
//  This means that if a bomb detonates in cell i,j , any valid cells (i +- 1, j) and (i, j +- 1) are cleared.
//  If there is a bomb in a neighboring cell, the neighboring bomb is destroyed without detonating, so there's no chain reaction.
//
// Bomberman is immune to bombs, so he can move freely throughout the grid. Here's what he does:
//
// 1. Initially, Bomberman arbitrarily plants bombs in some cells, the initial state.
// 2. After one second, Bomberman does nothing.
// 3. After one more second, Bomberman plants bombs in all cells without bombs, thus filling the whole grid with bombs. No bombs detonate at this point.
// 4. After one more second, any bombs planted exactly three seconds ago will detonate. Here, Bomberman stands back and observes.
// 5. Bomberman then repeats steps 3 and 4 indefinitely.
// Note that during every second Bomberman plants bombs, the bombs are planted simultaneously (i.e., at the exact same moment), and any bombs planted at the same time will detonate at the same time.
//
//Given the initial configuration of the grid with the locations of Bomberman's first batch of planted bombs, determine the state of the grid after  seconds.
public class BombermanGameTest {

    @Test
    public void case01() {
        Assertions.assertEquals(Arrays.asList("OOO.OOO",
                "OO...OO",
                "OOO...O",
                "..OO.OO",
                "...OOOO",
                "...OOOO"), bomberMan(3, Arrays.asList(".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO.....")));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(Arrays.asList(".......",
                "...O.O.",
                "...OO..",
                "..OOOO.",
                "OOOOOOO",
                "OOOOOOO"), bomberMan(5, Arrays.asList(".......",
                "...O.O.",
                "....O..",
                "..O....",
                "OO...OO",
                "OO.O...")));
    }

    // For each odd n, bomberman will fill the grid with 0
    // Bomberman will fill the grid with 0 every time the bom detonated
    // The tricky part is we need to know when we need to invert the grid (detonate the bomb)
    // The key is every 3s after planted the bomb will explode
    private List<String> bomberMan(int n, List<String> grid) {
        if (n == 1 || n == 0) {
            return grid;
        }

        if (n % 2 == 0) {
            return fillWithZero(grid.size(), grid.get(0).length());
        }

        List<String> invertedGrid = invertTheGrid(grid);

        if (n % 4 == 3) {
            return invertedGrid;
        }

        return invertTheGrid(invertedGrid);
    }

    private List<String> fillWithZero(int r, int c) {
        List<String> zeroGrid = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < c; i++) {
            sb.append((char) 79);
        }

        for (int i = 0; i < r; i++) {
            zeroGrid.add(sb.toString());
        }

        return zeroGrid;
    }

    private List<String> invertTheGrid(List<String> grid) {
        List<String> invertedGrid = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.get(i).length(); j++) {
                if (hasNoAdjZero(grid, i, j)) {
                    sb.append((char) 79);
                } else {
                    sb.append('.');
                }
            }
            invertedGrid.add(sb.toString());
        }

        return invertedGrid;
    }

    private boolean hasNoAdjZero(List<String> grid, int r, int c) {
        return !isZero(grid, r, c) &&
                !isZero(grid, r-1, c) &&
                !isZero(grid, r, c-1) &&
                !isZero(grid, r, c+1) &&
                !isZero(grid, r+1, c);
    }
    private boolean isZero(List<String> grid, int r, int c) {
        return isValidPoint(grid, r, c)
                && grid.get(r).charAt(c) == (char) 79;
    }
    private boolean isValidPoint(List<String> grid, int r, int c) {
        return r >= 0 && c >= 0 && r < grid.size() && c < grid.get(0).length();
    }
}
