package ru.job4j.ood.isp.menu;

public class CreateNewItem implements UserAction {
    private final Output out;

    public CreateNewItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Создать новый пункт меню ===";
    }

    @Override
    public boolean execute(Input input, Store supportItem) {
        out.println("Внимание! Корневой номер пункта вводите без точки, например, 1 или 2а");
        out.println("номер подпункта вводите с точкой, например, 1.1 или 1.а или 1.1.2");
        String indexNumber = input.askStr("Введите номер нового пункта меню: ");
        while (supportItem.numberExists(indexNumber)) {
            indexNumber = input.askStr("Такой номер занят, "
                    + "введите свободный номер для нового пункта меню: ");
        }
        String description = input.askStr("Введите описание этого пункта: ");
        supportItem.createNewItem(indexNumber, description);
        return true;
    }
}
