package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenMaxIsFirst() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = (x, y) -> (x < y) ? -1 : ((x.equals(y)) ? 0 : 1);
        List<Integer> integerList = List.of(5, 1, 3);
        Integer expected = 5;
        assertEquals(expected, maxMin.max(integerList, comparator));
    }

    @Test
    public void whenMaxIsLast() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = (x, y) -> (x < y) ? -1 : ((x.equals(y)) ? 0 : 1);
        List<Integer> integerList = List.of(1, 3, 5);
        Integer expected = 5;
        assertEquals(expected, maxMin.max(integerList, comparator));
    }

    @Test
    public void whenNoMax() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = (x, y) -> (x < y) ? -1 : ((x.equals(y)) ? 0 : 1);
        List<Integer> integerList = List.of(5, 5, 5);
        Integer expected = 5;
        assertEquals(expected, maxMin.max(integerList, comparator));
    }

    @Test
    public void whenMinIsFirst() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = (x, y) -> (x < y) ? -1 : ((x.equals(y)) ? 0 : 1);
        List<Integer> integerList = List.of(1, 4, 3);
        Integer expected = 1;
        assertEquals(expected, maxMin.min(integerList, comparator));
    }

    @Test
    public void whenMinIsLast() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = (x, y) -> (x < y) ? -1 : ((x.equals(y)) ? 0 : 1);
        List<Integer> integerList = List.of(5, 4, 1);
        Integer expected = 1;
        assertEquals(expected, maxMin.min(integerList, comparator));
    }

    @Test
    public void whenNoMin() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = (x, y) -> (x < y) ? -1 : ((x.equals(y)) ? 0 : 1);
        List<Integer> integerList = List.of(1, 1, 1);
        Integer expected = 1;
        assertEquals(expected, maxMin.min(integerList, comparator));
    }
}