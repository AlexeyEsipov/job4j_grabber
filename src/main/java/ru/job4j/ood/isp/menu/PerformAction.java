package ru.job4j.ood.isp.menu;

public class PerformAction implements UserAction {
    private final Output out;

    public PerformAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Выполнить действие, предусмотренное пунктом меню ===";
    }

    @Override
    public boolean execute(Input input, Store supportItem) {
        String point = input.askStr("Введите номер пункта меню для выполнения: ");
        while (!supportItem.numberExists(point)) {
            point = input.askStr("Такого номера нет, "
                    + "введите существующий номер пункта меню: ");
        }
        supportItem.performAction(point);
    return true;
    }
}
