package ru.job4j.ood.isp.menu;

public class PrintOnePoint implements UserAction {
    private final Output out;

    public PrintOnePoint(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Показать отдельный пункт меню с подпунктами ===";
    }

    @Override
    public boolean execute(Input input, Store supportItem) {
        String point = input.askStr("Введите номер пункта: ");
        while (!supportItem.numberExists(point)) {
            point = input.askStr("Такого номера нет, "
                    + "введите существующий номер меню: ");
        }
        supportItem.printOnePoint(point);
        return true;
    }
}
