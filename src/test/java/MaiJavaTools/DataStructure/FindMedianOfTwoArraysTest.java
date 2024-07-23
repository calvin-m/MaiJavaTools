package MaiJavaTools.DataStructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FindMedianOfTwoArraysTest {
    @Test
    public void test1() {

        int[] a1 = {1, 2};
        int[] a2 = {3, 4};

        double r = FindMedianOfTwoArrays.findMedianSortedArrays(a1, a2);

        assertTrue(r == 2.5);
    }

}
