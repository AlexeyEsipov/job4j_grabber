package ru.job4j.ood.ocp;

public class MyClass {
    public static void main(String[] args) {
        MyButton button = new MyButton();
        button.reg(
                () -> System.out.println("Нажата кнопка")
        );
        for (int i = 0; i < 5; i++) {
            button.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

    }
}

interface IClick {
    void onClick();
}

class MyButton {
    private IClick ic = null;

    public void reg(IClick ic) {
        this.ic = ic;
    }

    public void click() {
        if (this.ic != null) {
            this.ic.onClick();
        }
    }
}