package ru.job4j.ood.isp.menu;

public interface UserAction {
    String name();

    boolean execute(Input input, Store menu);
}
