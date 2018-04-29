package com.muric.app;

import com.muric.solution.division.api.LongDivision;
import com.muric.solution.division.impl.LongDivisionOriginal;
import com.muric.solution.division.impl.LongDivisionSolution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongDivisionApp {
    private static final Logger log = LoggerFactory.getLogger(LongDivisionApp.class);
    private static final LongDivisionApp app = new LongDivisionApp();

    public static void main(String[] args){
        log.info("Start");
        LongDivision solution = new LongDivisionOriginal();
        log.info("Original  3/28 = " + solution.divide(3, 28));
        log.info("Original 13/34 = " + solution.divide(13, 34));
        solution = new LongDivisionSolution();
        log.info("Solution  3/28 = " + solution.divide(3, 28));
        log.info("Solution 13/34 = " + solution.divide(13, 34));
        log.info("End");
    }
}
