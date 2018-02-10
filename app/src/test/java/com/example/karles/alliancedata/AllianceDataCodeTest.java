package com.example.karles.alliancedata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Mart on 2018-02-10.
 */
public class AllianceDataCodeTest {

    AllianceDataCode allianceDataCode;

    AllianceDataCode spyAllianceDataCode;

    @Before
    public void initialize() {
        //Add initializer if needed
        allianceDataCode = new AllianceDataCode();
        spyAllianceDataCode = spy(allianceDataCode);
    }

    @Test
    public void calculateMatrices_6X5MatrixNormalFlow_path() throws Exception {
        int[][] inputMatrix = new int[][]{
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 8, 6, 4}};

        boolean path = true;
        int computedValue = 16;
        int[] outputArray = new int[]{1, 2, 3, 4, 4, 5};


        spyAllianceDataCode.calculateMatrices(inputMatrix);

        doReturn(path).when(spyAllianceDataCode).validateFormat();
        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();

        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }

    @Test
    public void calculateMatrices_6X5MatrixNormalFlow2_path() throws Exception {
        int[][] inputMatrix = new int[][]{
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 1, 2, 3}};

        boolean path = true;
        int computedValue = 11;
        int[] outputArray = new int[]{1, 2, 1, 5, 4, 5};

        spyAllianceDataCode.calculateMatrices(inputMatrix);

        doReturn(path).when(spyAllianceDataCode).validateFormat();
        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();

        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }

    @Test
    public void calculateMatrices_5X3Matrix_noPath() throws Exception {
        int[][] inputMatrix = new int[][]{
                {19, 10, 19, 10, 19},
                {21, 23, 20, 19, 12},
                {20, 12, 20, 11, 10}};

        boolean path = false;
        int computedValue = 48;
        int[] outputArray = new int[]{1, 1, 1};


        spyAllianceDataCode.calculateMatrices(inputMatrix);

        doReturn(path).when(spyAllianceDataCode).validateFormat();
        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();

        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }

    @Test
    public void calculateMatrices_1X5Matrix_path() throws Exception {
        int[][] inputMatrix = new int[][]{
                {5, 8, 5, 3, 5}};

        boolean path = true;
        int computedValue = 26;
        int[] outputArray = new int[]{1, 1, 1, 1, 1};


        spyAllianceDataCode.calculateMatrices(inputMatrix);

        doReturn(path).when(spyAllianceDataCode).validateFormat();
        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();

        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }

    @Test
    public void calculateMatrices_5X1Matrix_path() throws Exception {
        int[][] inputMatrix = new int[][]{
                {5},
                {8},
                {5},
                {3},
                {5}};

        boolean path = true;
        int computedValue = 3;
        int[] outputArray = new int[]{4};


        spyAllianceDataCode.calculateMatrices(inputMatrix);

        doReturn(path).when(spyAllianceDataCode).validateFormat();
        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();

        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }

    @Test
    public void calculateMatrices_nonNumericInput_invalid() throws Exception {
//        String[][] inputMatrix = new String[][]{
//                {"5","4","H"},
//                {"8", "M", "7"},
//                {"5", "7", "5"}};
//
//        boolean path = false;
//        int computedValue = 3;
//        int[] outputArray = new int[]{};
//
//
//        spyAllianceDataCode.calculateMatrices(inputMatrix);
//
//        doReturn(path).when(spyAllianceDataCode).validateFormat();
//        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
//        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();
//
//        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }

    @Test
    public void calculateMatrices_noInput_Invalid() throws Exception {
        int[][] inputMatrix = new int[][]{
                {},
                {},
                {},
                {},
                {}};

        assertEquals(
                "Invalid Input",
                spyAllianceDataCode.validateInput(inputMatrix));
    }

    @Test
    public void calculateMatrices_StartingWithAbove50_noPath() throws Exception {
        int[][] inputMatrix = new int[][]{
                {69, 10, 19, 10, 19},
                {51, 23, 20, 19, 12},
                {60, 12, 20, 11, 10}};

        boolean path = false;
        int computedValue = 0;
        int[] outputArray = new int[]{};


        spyAllianceDataCode.calculateMatrices(inputMatrix);

        doReturn(path).when(spyAllianceDataCode).validateFormat();
        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();

        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }

    @Test
    public void calculateMatrices_StartingWithOneAbove50_path() throws Exception {
        int[][] inputMatrix = new int[][]{
                {69, 3, 3, 6},
                {6, 3, 7, 9},
                {5, 6, 8, 3}};

        boolean path = true;
        int computedValue = 14;
        int[] outputArray = new int[]{3, 2, 1, 3};


        spyAllianceDataCode.calculateMatrices(inputMatrix);

        doReturn(path).when(spyAllianceDataCode).validateFormat();
        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();

        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }

    @Test
    public void calculateMatrices_withNegativeValues_path() throws Exception {
        int[][] inputMatrix = new int[][]{
                {6, 3, -5, 9},
                {-5, 2, 4, 10},
                {3, -2, 6, 10},
                {6, -1, -2, 10}};

        boolean path = true;
        int computedValue = 0;
        int[] outputArray = new int[]{2, 3, 4, 1};


        spyAllianceDataCode.calculateMatrices(inputMatrix);

        doReturn(path).when(spyAllianceDataCode).validateFormat();
        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();

        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }

    @Test
    public void calculateMatrices_CompleteVsLowerIncomplete_path() throws Exception {
        int[][] inputMatrix = new int[][]{
                {51, 51},
                {0, 51},
                {51, 51},
                {5, 5}};

        boolean path = true;
        int computedValue = 10;
        int[] outputArray = new int[]{4,4};


        spyAllianceDataCode.calculateMatrices(inputMatrix);

        doReturn(path).when(spyAllianceDataCode).validateFormat();
        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();

        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }

    @Test
    public void calculateMatrices_LongerIncompleteVsShorterIncomplete_noPath() throws Exception {
        int[][] inputMatrix = new int[][]{
                {51, 51, 51},
                {0, 51, 51},
                {51, 51, 51},
                {5, 5, 51}};

        boolean path = false;
        int computedValue = 10;
        int[] outputArray = new int[]{4,4};


        spyAllianceDataCode.calculateMatrices(inputMatrix);

        doReturn(path).when(spyAllianceDataCode).validateFormat();
        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();

        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }

    @Test
    public void calculateMatrices_LargeNumberOfColumns_path() throws Exception {
        int[][] inputMatrix = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2}};

        boolean path = true;
        int computedValue = 20;
        int[] outputArray = new int[]{
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1};


        spyAllianceDataCode.calculateMatrices(inputMatrix);

        doReturn(path).when(spyAllianceDataCode).validateFormat();
        doReturn(computedValue).when(spyAllianceDataCode).computedValue();
        doReturn(outputArray).when(spyAllianceDataCode).resultingArray();

        verify(spyAllianceDataCode).calculateMatrices(inputMatrix);
    }
}