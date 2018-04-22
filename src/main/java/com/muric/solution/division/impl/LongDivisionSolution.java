package com.muric.solution.division.impl;

import com.muric.solution.division.api.LongDivision;

import java.util.ArrayList;
import java.util.List;

public class LongDivisionSolution implements LongDivision {
    public String divide(int nominator, int denominator) {
        StringBuilder buf = new StringBuilder();

        if(nominator == 0){
            return "0";
        } else if (denominator == 1) {
            return Integer.toString(nominator);
        }

        int remainder = nominator % denominator;
        int whole = nominator / denominator;

        if(remainder == 0){
            return Integer.toString(whole);
        }

        List<Character> remainderChar = new ArrayList<Character>();
        List<Integer> remainders = new ArrayList<Integer>();
        boolean keepGoing = true;
        int indexOfRepeater = Integer.MAX_VALUE;

        while(keepGoing = remainder != 0){
            if(remainders.contains(remainder)){
                indexOfRepeater = remainders.indexOf(remainder);
                break;
            }

            int temp = remainder * 10 / denominator;

            remainderChar.add(Integer.toString(temp).toCharArray()[0]);
            remainders.add(remainder);
            remainder = remainder * 10 % denominator;
        }

        buf.append(Integer.toString(whole) + ".");
        for(int ii=0; ii<remainderChar.size(); ii++){
            if(keepGoing && ii == indexOfRepeater){
                buf.append("(");
            }
            buf.append(remainderChar.get(ii));
        }
        if(keepGoing){
            buf.append(")");
        }
        return buf.toString();
    }
}
