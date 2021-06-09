package ru.job4j.ood.isp.menu;

public class PrintAllPoint implements UserAction {
    private final Output out;

    public PrintAllPoint(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Показать все пункты меню ===";
    }

    @Override
    public boolean execute(Input input, Store supportItem) {
        supportItem.printAllPoint();
        return true;
    }
}
