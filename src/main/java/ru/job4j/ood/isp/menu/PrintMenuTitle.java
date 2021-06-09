package ru.job4j.ood.isp.menu;

public class PrintMenuTitle implements UserAction {
    private final Output out;

    public PrintMenuTitle(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Показать только оглавление меню ===";
    }

    @Override
    public boolean execute(Input input, Store supportItem) {
        supportItem.printPriority(0);
        return true;
    }
}
