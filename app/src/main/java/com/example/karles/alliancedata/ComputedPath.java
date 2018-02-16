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

    ComputedPath(int[] path, int pathSum, boolean isValid) {
        this.pathSum = pathSum;
        this.path = path;
        this.isValid = isValid;
    }

    int getPathSum() {
        return pathSum;
    }
    boolean isValid() {
        return isValid;
    }
    int[] getPath(){
        return this.path;
    }
}
