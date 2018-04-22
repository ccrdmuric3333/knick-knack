package com.muric.solution.division.impl;

import com.muric.solution.division.api.LongDivision;

import java.math.BigDecimal;

public class LongDivisionOriginal implements LongDivision {
    public String divide(int nominator, int denominator){
        StringBuilder buf = new StringBuilder();

        if(nominator == 0) {
            buf.append("0");
        } else  if(denominator == 1){
            buf.append(Integer.toString(nominator));
        } else if(nominator == denominator){
            buf.append("1");
        } else if(nominator % denominator == 0){
            buf.append(Integer.toString(nominator / denominator));
        } else {
            BigDecimal bigA = new BigDecimal(nominator);
            BigDecimal result = bigA.divide(new BigDecimal(denominator), 9, BigDecimal.ROUND_UP);
            String resultString = result.toString();
            String precision = getPrecisionString(resultString.substring(resultString.indexOf(".") + 1));

            buf.append(resultString.substring(0, resultString.indexOf(".") + 1) + precision);
        }

        return buf.toString();
    }

    private String getPrecisionString (String last9){
        char[] digit = last9.toCharArray();
        StringBuilder buf1 = new StringBuilder();
        StringBuilder buf2 = new StringBuilder();
        boolean skipZeros = true;

        for(int ii=digit.length-2; ii >=0; ii--){
            if(digit[ii] == '0') {
                if (skipZeros) {
                    continue;
                }
            }
            if (ii > 1){
                skipZeros = false;
                buf1.append(digit[ii]);
            } else {
                skipZeros = false;
                buf2.append(digit[ii]);
            }
        }

        String one = buf1.reverse().toString();
        String two = buf2.reverse().toString();

//        System.out.println("Buf1 " + one);
//        System.out.println("Buf2 " + two);

        if(buf1.length() == 0) {
            return two;
        } else if (isTheSameDigit(one, two)){
            return "(" + two.substring(0,1) + ")";
        } else {
            return two + "(" + one + ")";
        }
    }

    private boolean isTheSameDigit(String one, String two){
        boolean result = true;
        char[] first = one.toCharArray();
        char[] second = two.toCharArray();
        char digit = first[0];

        for(int ii=0; ii<first.length && result; ii++){
            if(first[ii] == digit){
                continue;
            } else {
                result = false;
            }
        }

        for(int ii=0; ii<second.length && result; ii++){
            if(second[ii] == digit){
                continue;
            } else {
                result = false;
            }
        }
        return result;
    }
}
