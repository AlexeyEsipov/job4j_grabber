package ru.job4j.ood.isp.menu;

public class ReplaceNumber implements UserAction {
    private final Output out;

    public ReplaceNumber(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Заменить номер существующего пункта меню ===";
    }

    @Override
    public boolean execute(Input input, Store supportItem) {
        String oldNumber = input.askStr("Введите номер пункта меню: ");
        while (!supportItem.numberExists(oldNumber)) {
            oldNumber = input.askStr("Такого номера нет, "
                    + "введите корректный номер пункта меню: ");
        }
        String newNumber = input.askStr("Введите новый номер для этого пункта: ");
        while (supportItem.numberExists(newNumber)) {
            newNumber = input.askStr("Такой номер занят, "
                    + "введите свободный номер для нового пункта меню: ");
        }
        supportItem.replaceNumber(oldNumber, newNumber);
        return true;
    }
}
