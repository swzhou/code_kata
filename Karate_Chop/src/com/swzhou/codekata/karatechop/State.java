package com.swzhou.codekata.karatechop;

/**
 * Created by IntelliJ IDEA.
 * User: swzhou
 * Date: 4/15/12
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class State {
    private int currentMiddleIndex;
    private int nextStartIndex;
    private int nextEndIndex;
    private boolean found;

    public State(int currentMiddleIndex, int nextStartIndex, int nextEndIndex, boolean found) {
        this.currentMiddleIndex = currentMiddleIndex;
        this.nextStartIndex = nextStartIndex;
        this.nextEndIndex = nextEndIndex;
        this.found = found;
    }

    public int getCurrentMiddleIndex() {
        return currentMiddleIndex;
    }

    public int getNextStartIndex() {
        return nextStartIndex;
    }

    public int getNextEndIndex() {
        return nextEndIndex;
    }

    public boolean isFound() {
        return found;
    }

    public boolean isStop() {
        return found || nextStartIndex > nextEndIndex;
    }
}
