package ru.job4j.ood.ocp;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Probe {
    public static void main(String[] args) {
        short s = 1500;
        char c = (char) s;
        double d = c;
        System.out.println("Вывод в консоль значения после расширения: " + d);

        Set<String> set = new TreeSet<>();
        set.add("5.2");
        set.add("1");
        set.add("4.3");
        set.add("5.1.0.12");
        System.out.println(set);
        for (String el: set) {
            if (el.startsWith("5")) {
                System.out.println(el);
            }
        }
        String str = "1.";
        StringBuilder sb = new StringBuilder();
        if (str.contains(".")) {
            char[] chars = str.toCharArray();
            for (char ch: chars) {
                if (ch == '.') {
                    sb.append('-');
                }
            }
        }
        String pref = sb.toString();

        System.out.print(pref);
        System.out.println(str);
    }
}

