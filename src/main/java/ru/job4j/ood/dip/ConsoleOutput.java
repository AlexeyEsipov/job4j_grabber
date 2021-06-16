package ru.job4j.ood.dip;

import ru.job4j.ood.isp.menu.Output;

public class ConsoleOutput implements Output {

    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}