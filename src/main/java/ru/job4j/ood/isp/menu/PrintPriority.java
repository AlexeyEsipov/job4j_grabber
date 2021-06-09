package ru.job4j.ood.isp.menu;

public class PrintPriority implements UserAction {
    private final Output out;

    public PrintPriority(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Показать пункты меню с подпунктами ===";
    }

    @Override
    public boolean execute(Input input, Store supportItem) {
        int level = input.askInt("Введите глубину подпункта: ");
        supportItem.printPriority(level);
        return true;
    }
}