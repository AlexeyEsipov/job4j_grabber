package ru.job4j.ood.isp.menu;

import java.util.List;
import java.util.Set;

public interface Store extends AutoCloseable {
    void init();

    void createNewItem(String number, String description);

    boolean numberExists(String number);

    void deleteItem(String number);

    void replaceDescription(String existNumber, String newDescription);

    void replaceNumber(String existNumber, String newNumber);

    void printAllPoint();

    void printOnePoint(String pointMenu);

    void printPriority(int priority);

    void printMenuTitle();

    void performAction(String number);
}
