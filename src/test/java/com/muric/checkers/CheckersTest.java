package com.muric.checkers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckersTest {
    private Checkers checkers = new Checkers();

    @DataProvider(name = "checkers")
    Object[][] checkersData() {
        String[] boardWith2 = {
            "..X...",
            "......",
            "....X.",
            ".X....",
            "..X.X.",
            "...O.."};
        String[] boardWith4 = {
            "..X.......",
            "..........",
            "....X.....",
            ".X........",
            "..X.X.....",
            "....X.....",
            "..X.X.....",
            "..X.......",
            "..X.X.....",
            "...O......"};
        String[] boardWith0_1 = {
            "..X.......",
            "...O......",
            "....X.....",
            ".X........",
            "..X.X.....",
            "....X.....",
            "..X.X.....",
            "..X.......",
            "..X.X.....",
            ".........."};
        String[] boardWith0_2 = {
            "..X.......",
            "...X......",
            "....X.....",
            ".X........",
            "..X.X....X",
            "....X...O.",
            "..X.X.....",
            "..X.......",
            "..X.X.....",
            ".........."};

        return new Object[][]{
            {boardWith2, 2},
            {boardWith4, 4},
            {boardWith0_1, 0},
            {boardWith0_2, 0}
        };
    }

    @Test(dataProvider = "checkers")
    public void testCheckers(String[] board, int expectedResult){
        Assert.assertEquals(checkers.solution(board), expectedResult);
    }
}
