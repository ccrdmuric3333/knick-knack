package com.muric.elimination;

import com.muric.com.muric.elimination.Elimination;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class EliminationTest {
    private int[] empty = new int[0];
    private int[] ordered = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] random = {-5, 7, 19, 11, -3, 55, 6, -88, 4, 7};
    private int[] result489 = {4, 8, 9};
    private int[] result16 = {1, 6};
    private int[] resultRandom1 = {-5, 19, 11, 6};
    private int[] resultRandom2 = {-5, -3, 55};

    @DataProvider(name = "negative")
    Object[][] negativeData(){
        return new Object[][]{
            {empty, 1, null},       // error on empty array
            {ordered, -3, null},    // error on negative Nth element
        };
    }

    @DataProvider(name = "elimination")
    Object[][] data(){
        return new Object[][]{
            {ordered, 3, result489},
            {ordered, 12, ordered}, // nothing will be eliminated
            {ordered, 2, result16},
            {random, 4, resultRandom1},
            {random, 3, resultRandom2}
        };
    }

    @Test(dataProvider = "negative", expectedExceptions = IllegalArgumentException.class)
    public void negativeTest(int[] original, int nth, int[] expected){
        Elimination.eliminateEveryNelement(original, nth);
    }

    @Test(dataProvider = "elimination")
    public void elimination(int[] original, int nth, int[] expected){
        int[] actual = Elimination.eliminateEveryNelement(original, nth);

        Assert.assertTrue(Arrays.equals(actual, expected), "\nExpected: " + Arrays.toString(expected) + "\n" +
                                                                    "Actual:   " + Arrays.toString(actual) + "\n");
    }
}
