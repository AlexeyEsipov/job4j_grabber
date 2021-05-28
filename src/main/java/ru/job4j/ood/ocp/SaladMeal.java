package ru.job4j.ood.ocp;

public class SaladMeal implements IMeal {
    @Override
    public void make() {
        System.out.println("Нарезаем помидоры и огурцы");
        System.out.println("Посыпаем зеленью, солью и специями");
        System.out.println("Поливаем подсолнечным маслом");
        System.out.println("Салат готов");
    }
}
