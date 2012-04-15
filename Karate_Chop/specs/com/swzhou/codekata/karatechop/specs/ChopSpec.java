package com.swzhou.codekata.karatechop.specs;

import com.swzhou.codekata.karatechop.State;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

/**
 * Created by IntelliJ IDEA.
 * User: swzhou
 * Date: 4/15/12
 * Time: 9:48 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(ConcordionRunner.class)
public class ChopSpec {

    public State calculateCurrentState(int searchValue, int currentStartIndex, int currentEndIndex, int currentMiddleValue) {
        int currentMiddleIndex = (currentStartIndex + currentEndIndex) / 2;
        if(searchValue == currentMiddleValue) {
            return new State(currentMiddleIndex, currentMiddleIndex, currentMiddleIndex, true);
        }
        int nextStartIndex = searchValue > currentMiddleValue? currentMiddleIndex + 1 : currentStartIndex;
        int nextEndIndex = searchValue > currentMiddleValue? currentEndIndex : currentMiddleIndex - 1;
        return new State(currentMiddleIndex, nextStartIndex, nextEndIndex, false);
    }
}
