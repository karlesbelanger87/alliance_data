package com.example.karles.alliancedata;

/**
 * Created by Mart on 2018-02-10.
 */

public class AllianceDataCode {

    void calculateMatrices(int[][] matrix){
        validateInput(matrix);
        validateFormat();
        computedValue();
        resultingArray();
    }
    boolean validateFormat(){
        return false;
    }
    int computedValue(){
        int computedResult = 0;
        return computedResult;
    }

    int[] resultingArray(){
        int[] resultArray = {0,0};
        return resultArray;
    }
    String validateInput(int[][] matrix){
        if(matrix[0].length == 0)
            return "Invalid Input";
        else
            return "Valid Input";
    }
}
