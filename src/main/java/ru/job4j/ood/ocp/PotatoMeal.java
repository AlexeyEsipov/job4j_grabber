package ru.job4j.ood.ocp;

public class PotatoMeal implements IMeal {
    @Override
    public void make() {
        System.out.println("Чистим картошку");
        System.out.println("Ставим почищенную картошку на огонь");
        System.out.println("Сливаем остатки воды, разминаем варенный картофель в пюре");
        System.out.println("Посыпаем пюре специями и зеленью");
        System.out.println("Картофельное пюре готово");
    }
}
