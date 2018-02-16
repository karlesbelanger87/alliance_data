package com.example.karles.alliancedata;

import java.util.Arrays;

/**
 * Created by Mart on 2018-02-16.
 */

public class ComputedPath {
    private int pathSum;
    private int[] path;
    private boolean isValid;
    private int errorCode;

    public ComputedPath() {

    }

    public ComputedPath(int[] path, int pathSum, boolean isValid) {
        this.pathSum = pathSum;
        this.path = path;
        this.isValid = isValid;
    }

    public int getPathSum() {
        return pathSum;
    }
    public boolean isValid() {
        return isValid;
    }
    public int[] getNewPath(){
        return this.path;
    }
    public int[] getPath() {
        if (path != null) {
            int j = 0;
            for (int i = 0; i < path.length; i++) {
                if (path[i] != 0) {
                    path[j++] = path[i];
                }
            }
            int[] newArray = new int[j];
            System.arraycopy(path, 0, newArray, 0, j);
            return newArray;
        } else {
            return new int[0];
        }
    }

//    public int getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(int errorCode) {
//        this.errorCode = errorCode;
//    }
}
