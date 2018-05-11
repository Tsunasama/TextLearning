/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : CompareUtil.java
 *  Date : 18-5-11 下午3:00
 */

package com.tsuna.textLearning.engine.util;

public class CompareUtil {
    public static int getMaxIndex(double[] array) {
        if (array.length < 1)
            throw new IllegalArgumentException("Argument 'array' should have at least one element.");
        int maxIndex = 0;
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
}
