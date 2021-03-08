package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DesignHashMapTest {

    @Test
    public void successWhenInputIsRight() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        Assert.assertEquals(1, myHashMap.get(1));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        Assert.assertEquals(-1, myHashMap.get(3));
    }

    @Test
    public void successWhenInputIsRightThree() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        myHashMap.put(2, 1);
        Assert.assertEquals(1, myHashMap.get(2));
    }
    @Test
    public void successWhenInputIsRightFour() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        myHashMap.remove(2);
        Assert.assertEquals(-1, myHashMap.get(2));
    }


    class MyHashMap {
        int[] values;

        /** Initialize your data structure here. */
        public MyHashMap() {
            values = new int[1000001];
            Arrays.fill(values, -1);
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            values[key] = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            return values[key];
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            values[key] = -1;
        }
    }

    // The key is:
    // 1. All keys and values will be in the range of [0, 1000000] -> We can use an array, index as a key.
    // 2. Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    // -> -1 as default value
    // Prepare the array with length 1000000 + 1
    // Fill with -1, as default value
    // This solution only work if the key is an integer
    // More general solution is we convert the key into integer, but beware of collision.
}
