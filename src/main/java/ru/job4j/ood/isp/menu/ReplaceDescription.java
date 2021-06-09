package ru.job4j.ood.isp.menu;

public class ReplaceDescription implements UserAction {
    private final Output out;

    public ReplaceDescription(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Заменить описание существующего пункта меню ===";
    }

    @Override
    public boolean execute(Input input, Store supportItem) {
        String indexNumber = input.askStr("Введите номер пункта меню: ");
        while (!supportItem.numberExists(indexNumber)) {
            indexNumber = input.askStr("Такого номера нет, "
                    + "введите существующий номер пункта меню: ");
        }
        String description = input.askStr("Введите новое описание этого пункта: ");
        supportItem.replaceDescription(indexNumber, description);
        return true;
    }
}
