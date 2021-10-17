package io.github.bluething.leetcode.algorithm.binarysearch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FirstBadVersionTest {

    @Test
    public void case01() {
        Solution solution = Mockito.spy(new Solution());
        Mockito.when(solution.isBadVersion(4)).thenReturn(true);

        Assert.assertEquals(4, solution.firstBadVersion(5));
    }

    class VersionControl {
        boolean isBadVersion2(int version) {
            return true;
        }
    }
    class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int low = 1;
            int high = n;
            int mid = low + ((high - low) / 2);
            boolean isFailed = false;
            while (low <= high) {
                mid = low + ((high - low) / 2);
                isFailed = isBadVersion(mid);
                if (isFailed) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return low;
        }

        boolean isBadVersion(int version) {
            return super.isBadVersion2(version);
        }
    }
}
