package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Two players are playing a game of Tower Breakers! Player 1 always moves first, and both players always play optimally.The rules of the game are as follows:
//
// 1. Initially there are n towers.
//2. Each tower is of height m.
//3. The players move in alternating turns.
//4. In each turn, a player can choose a tower of height x and reduce its height to y, where 1 <= y <= x and y evenly divides x.
//5. If the current player is unable to make a move, they lose the game.
//
//Given the values of n and m, determine which player will win. If the first player wins, return 1. Otherwise, return 2.
public class TowerBreakersTest {
    @Test
    public void case01() {
        Assertions.assertEquals(2, towerBreakers(2, 2));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(1, towerBreakers(1, 4));
    }

    // The key is:
    // 1. y evenly divided x, means x mod y == 0
    // 2. Both players always play optimally, means they will make a move which leave high of 1
    // Since p1 start 1st, he doesn't have any chance to win if number of tower is even.
    // p1 also can't win if the initial high of tower is 1
    private int towerBreakers(int n, int m) {
        return (m == 1|| n % 2 == 0) ? 2 : 1;
    }
}
