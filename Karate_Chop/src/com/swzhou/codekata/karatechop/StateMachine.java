package com.swzhou.codekata.karatechop;

import java.util.List;

public class StateMachine {
    private int expectValue;
    private List<Integer> sourceList;
    private State currentState;

    public StateMachine(int expectValue, List<Integer> sourceList) {
        this.sourceList = sourceList;
        this.expectValue = expectValue;
        initializeState();
    }

    private void initializeState() {
        currentState = (sourceList.size() == 0)
                ? new State(-1, 0, -1, false)
                : new State(-1, 0, sourceList.size() - 1, false);
    }

    public State getCurrentState() {
        return currentState;
    }

    public void run() {
        while (!currentState.isStop()) {
            int currentStartIndex = currentState.getNextStartIndex();
            int currentEndIndex = currentState.getNextEndIndex();
            int currentMiddleIndex = (currentStartIndex + currentEndIndex) / 2;
            int currentMiddleValue = sourceList.get(currentMiddleIndex);
            currentState = (currentMiddleValue == expectValue)
                    ? new State(currentMiddleIndex, currentMiddleIndex, currentMiddleIndex, true)
                    : buildNextState(currentStartIndex, currentEndIndex, currentMiddleIndex, currentMiddleValue);
        }
    }

    private State buildNextState(int currentStartIndex, int currentEndIndex, int currentMiddleIndex, int currentMiddleValue) {
        int nextStartIndex = currentMiddleValue > expectValue ? currentStartIndex : currentMiddleIndex + 1;
        int nextEndIndex = currentMiddleValue > expectValue ? currentMiddleIndex - 1 : currentEndIndex;
        return new State(currentMiddleIndex, nextStartIndex, nextEndIndex, false);
    }
}
