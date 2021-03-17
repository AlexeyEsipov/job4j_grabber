package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findElem(value, comparator, -1);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findElem(value, comparator, 1);
    }

    private  <T> T findElem(List<T> value, Comparator<T> comparator, int maxOrMin) {
        T result = value.get(0);
        for (T elem : value) {
            if (comparator.compare(result, elem) * maxOrMin > 0) {
                result = elem;
            }
        }
        return result;
    }
}
