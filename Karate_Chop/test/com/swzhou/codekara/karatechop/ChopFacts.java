package com.swzhou.codekara.karatechop;

import com.swzhou.codekata.karatechop.IterationChop;
import com.swzhou.codekata.karatechop.RecursionChop;
import com.swzhou.codekata.karatechop.IChop;
import com.swzhou.codekata.karatechop.StateMachineChop;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: twer
 * Date: 4/14/12
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChopFacts {

    private IChop chop;

    @Before
    public void setUp() {
        //chop = new RecursionChop();
        //chop = new IterationChop();
        chop = new StateMachineChop();
    }

    @Test
    public void should_not_find_in_empty_array() {
        verifySearchResult(3, new ArrayList<Integer>(), -1);
    }

    @Test
    public void should_not_find_non_existence_element() {
        verifySearchResult(3, Arrays.asList(1), -1);
    }

    @Test
    public void should_find_exact_element_in_single_element_array() {
        verifySearchResult(1, Arrays.asList(1), 0);
    }

    @Test
    public void should_find_index_of_exact_element_in_3_elements_array() {
        verifySearchResult(1, Arrays.asList(1, 3, 5), 0);
        verifySearchResult(3, Arrays.asList(1, 3, 5), 1);
        verifySearchResult(5, Arrays.asList(1, 3, 5), 2);
    }

    @Test
    public void should_not_find_non_existence_element_in_3_elements_array() {
        verifySearchResult(0, Arrays.asList(1, 3, 5), -1);
        verifySearchResult(2, Arrays.asList(1, 3, 5), -1);
        verifySearchResult(4, Arrays.asList(1, 3, 5), -1);
        verifySearchResult(6, Arrays.asList(1, 3, 5), -1);
    }

    @Test
    public void should_find_index_of_exact_element_in_4_elements_array() {
        verifySearchResult(1, Arrays.asList(1, 3, 5, 7), 0);
        verifySearchResult(3, Arrays.asList(1, 3, 5, 7), 1);
        verifySearchResult(5, Arrays.asList(1, 3, 5, 7), 2);
        verifySearchResult(7, Arrays.asList(1, 3, 5, 7), 3);
    }

    @Test
    public void should_not_find_non_existence_element_in_4_elements_array() {
        verifySearchResult(0, Arrays.asList(1, 3, 5, 7), -1);
        verifySearchResult(2, Arrays.asList(1, 3, 5, 7), -1);
        verifySearchResult(4, Arrays.asList(1, 3, 5, 7), -1);
        verifySearchResult(6, Arrays.asList(1, 3, 5, 7), -1);
        verifySearchResult(8, Arrays.asList(1, 3, 5, 7), -1);
    }

    private void verifySearchResult(int number, List<Integer> list, int result) {
        int expectNumber = givenExpectNumber(number);
        List<Integer> sourceList = givenSourceList(list);
        assertThat(chop.find(expectNumber, sourceList), equalTo(result));
    }

    private List<Integer> givenSourceList(List<Integer> sourceList) {
        return sourceList;
    }

    private int givenExpectNumber(int number) {
        return number;
    }

}
