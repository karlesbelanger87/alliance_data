package com.example.karles.alliancedata;

/**
 * Created by Mart on 2018-02-16.
 */

public class AllianceDataCode {
    private int[][] pathMatrix;
    private int ROWS, COLS;
    private int[] path;
    private static final int MAX = 50;

    public ComputedPath calculateMatrices(int[][] inputMatrix) {
        ROWS = inputMatrix.length;
        COLS = inputMatrix[0].length;
        path = new int[COLS];
        pathMatrix = inputMatrix;
        ComputedPath result;
        int startPoint = findStartPoint();
        boolean isValid = true;
        if (startPoint >= 0) {
            path[0] = startPoint + 1;
            int pathSum = pathMatrix[startPoint][0];
            for (int cols = 1; cols < COLS; cols++) {
                startPoint = findNextMinimum(startPoint, cols);
                int tempSum = pathSum + pathMatrix[startPoint][cols];
                if (tempSum <= 50) {
                    pathSum = tempSum;
                    path[cols] = startPoint + 1;
                } else {
                    isValid = false;
                    break;
                }
            }
            result = new ComputedPath(path, pathSum, isValid);
        } else {
            result = new ComputedPath(null, 0, false);
        }
        return result;
    }

    private int findNextMinimum(int entry, int cols) {
        int index = 0;
        int topRightIndex = entry - 1 < 0 ? ROWS - 1 : entry - 1;
        int bottomRightIndex = entry + 1 == ROWS ? 0 : entry + 1;
        int topRight = pathMatrix[topRightIndex][cols];
        int right = pathMatrix[entry][cols];
        int bottomRight = pathMatrix[bottomRightIndex][cols];
        if ((topRight <= right) && (topRight <= bottomRight)) {
            index = topRightIndex;
        }
        if ((right < topRight) && (right < bottomRight)) {
            index = entry;
        }
        if ((bottomRight < topRight) && (bottomRight < right)) {
            index = bottomRightIndex;
        }
        return index;
    }

    private int findStartPoint() {
        int index = -1;
        if(pathMatrix.length ==0 ||
                pathMatrix[0].length ==0)
            return index;
        int min = MAX;

        for (int i = 0; i < ROWS; i++) {
            if (pathMatrix[i][0] < min) {
                min = pathMatrix[i][0];
                index = i;
            }
        }

        if (COLS > 1 && index != -1) {
            int topRightIndex = index - 1 < 0 ? ROWS - 1 : index - 1;
            int bottomRightIndex = index + 1 == ROWS ? 0 : index + 1;
            int topRight = pathMatrix[topRightIndex][1];
            int right = pathMatrix[index][1];
            int bottomRight = pathMatrix[bottomRightIndex][1];
            if (topRight >= MAX && right >= MAX && bottomRight >= MAX) {
                for (int i = 0; i < ROWS; i++) {
                    if (pathMatrix[i][0] > min && pathMatrix[i][0] < MAX) {
                        min = pathMatrix[i][0];
                        index = i;
                    }
                }
            }
        }
        return index;
    }
}
