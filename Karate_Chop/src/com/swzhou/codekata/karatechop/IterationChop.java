package com.swzhou.codekata.karatechop;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: swzhou
 * Date: 4/15/12
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class IterationChop implements IChop {
    @Override
    public int find(int expectedNumber, List<Integer> sourceList) {
        int start = 0;
        int end = sourceList.size() - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            Integer middleValue = sourceList.get(middle);
            if (expectedNumber == middleValue) {
                return middle;
            } else if (expectedNumber < middleValue) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
