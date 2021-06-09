package ru.job4j.ood.isp.menu;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Удалить пункт меню ===";
    }

    @Override
    public boolean execute(Input input, Store supportItem) {
        String indexNumber = input.askStr("Введите номер пункта меню для удаления: ");
        while (!supportItem.numberExists(indexNumber)) {
            indexNumber = input.askStr("Такого номера нет, "
                    + "введите существующий номер для удаления пункта меню: ");
        }
        supportItem.deleteItem(indexNumber);
        return true;
    }
}

