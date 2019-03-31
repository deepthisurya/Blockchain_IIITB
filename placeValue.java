package com.company;
import java.lang.Math;

public class placeValue{

    public static void main(String[] args){
   // write your code here
        int tenThousands;
        int thousands;
        int hundreds;
        int tens;
        int ones;
        int number = 23456;
        //Ten thousands place
        int tenThousandPlace = (int)Math.pow(10,4);
        tenThousands = number / tenThousandPlace;
        int temp = number%(tenThousandPlace*tenThousands);
        System.out.println(tenThousands);
        number = temp;

        //thousands place
        int thousandsPlace = (int)Math.pow(10,3);
        thousands = number / thousandsPlace;
        temp = number%(thousandsPlace*thousands);
        System.out.println(thousands);
        number = temp;

        //hundreds place
        int hundredsPlace = (int)Math.pow(10,2);
        hundreds = number / hundredsPlace;
        temp = number%(hundredsPlace*hundreds);
        System.out.println(hundreds);
        number = temp;

        // tens place
        int tensPlace = (int)Math.pow(10,1);
        tens = number / tensPlace;
        temp = number%(tensPlace*tens);
        System.out.println(tens);
        number = temp;

        //ones place
        ones =number;
        System.out.println(ones);
        }
    }
