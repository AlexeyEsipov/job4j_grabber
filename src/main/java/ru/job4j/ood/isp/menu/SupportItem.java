package ru.job4j.ood.isp.menu;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiPredicate;

public class SupportItem implements Store {
    private final Map<String, Item<String>> mapMenu = new TreeMap<>();

    @Override
    public void init() {
    }

    @Override
    public void createNewItem(String number, String description) {
        mapMenu.put(number, new Item<>(number, description, System.out::println));

    }

    @Override
    public boolean numberExists(String number) {
        Set<String> keySet = mapMenu.keySet();
        return keySet.contains(number);
    }

    @Override
    public void deleteItem(String number) {
        mapMenu.remove(number);
    }

    @Override
    public void replaceDescription(String existNumber, String newDescription) {
        Item<String> item = mapMenu.get(existNumber);
        item.setDescription(newDescription);
        mapMenu.replace(existNumber, item);
    }

    @Override
    public void replaceNumber(String existNumber, String newNumber) {
        Item<String> item = mapMenu.get(existNumber);
        item.setIndexNumber(newNumber);
        item.chekPriority(newNumber);
        mapMenu.remove(existNumber);
        mapMenu.put(newNumber, item);
    }

    @Override
    public void printAllPoint() {
        print((s, n) -> true, null);
    }

    @Override
    public void printOnePoint(String pointMenu) {
        print((s, n) -> s.getIndexNumber().startsWith(n), pointMenu);
    }

    @Override
    public void printPriority(int priority) {
        print((s, n) -> s.getPriority() <= priority, null);
    }

    @Override
    public void printMenuTitle() {
        printPriority(0);
    }

    @Override
    public void performAction(String number) {
        mapMenu.get(number).itemAccept("Выполнение пункта " + number);
    }

    private void print(BiPredicate<Item<String>, String> predicate, String pointMenu) {
        Set<Map.Entry<String, Item<String>>> set = mapMenu.entrySet();
        for (Map.Entry<String, Item<String>> point : set) {
            Item<String> item = point.getValue();
            if (predicate.test(item, pointMenu)) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void close() throws Exception {
    }
}
