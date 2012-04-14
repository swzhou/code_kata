package com.swzhou.codekata.karatechop;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: twer
 * Date: 4/14/12
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecursionChop implements IChop {
    @Override
    public int find(int expectedNumber, List<Integer> sourceList) {
        if (sourceList.size() == 0)
            return -1;
        return find(expectedNumber, sourceList, 0, sourceList.size() - 1);
    }

    private int find(int expectedNumber, List<Integer> sourceList, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        Integer middleValue = sourceList.get(middle);
        if (expectedNumber == middleValue) {
            return middle;
        }
        boolean greaterThanMiddleValue = expectedNumber > middleValue;
        start = greaterThanMiddleValue ? middle + 1 : start;
        end = greaterThanMiddleValue ? end : middle - 1;
        return find(expectedNumber, sourceList, start, end);
    }
}
