package com.muric.division;

import com.muric.solution.division.api.LongDivision;
import com.muric.solution.division.impl.LongDivisionOriginal;
import com.muric.solution.division.impl.LongDivisionSolution;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongDivisionTest {
    private LongDivision victim;

    private void setVictim(boolean original){
        if(original){
            victim = new LongDivisionOriginal();
        } else {
            victim = new LongDivisionSolution();
        }
    }

    @DataProvider(name = "divisions")
    public Object[][] createDivisionCases() {
        return new Object[][]{
                {12, 3, "4"},
                {1, 2, "0.5"},
                {5, 4, "1.25"},
                {1, 3, "0.(3)"},
                {3, 28, "0.10(714285)"},
                {0, 5, "0"},
                {10, 1, "10"},
                {13, 13, "1"}
        };
    }

    @Test(dataProvider = "divisions")
    public void testDivisionsOriginal(int nominator, int denominator, String result) {
        setVictim(true);
        Assert.assertEquals(victim.divide(nominator, denominator), result);
    }

    @Test(dataProvider = "divisions")
    public void testDivisionsSolution(int nominator, int denominator, String result) {
        setVictim(false);
        Assert.assertEquals(victim.divide(nominator, denominator), result);
    }
}