package com.swzhou.codekata.karatechop;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: swzhou
 * Date: 4/15/12
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class StateMachineChop implements IChop{

    @Override
    public int find(int expectedNumber, List<Integer> sourceList) {
        StateMachine stateMachine = new StateMachine(expectedNumber, sourceList);
        stateMachine.run();
        State state = stateMachine.getCurrentState();
        return state.isFound()? state.getCurrentMiddleIndex() : -1;
    }
}

