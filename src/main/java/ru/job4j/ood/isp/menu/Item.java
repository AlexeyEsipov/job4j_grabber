package ru.job4j.ood.isp.menu;

import java.util.function.Consumer;

public class Item<T> {
    private String indexNumber;
    private String pref;
    private String description;
    private int priority;
    private Consumer<T> consumer;

    public Item(String indexNumber, String description, Consumer<T> consumer) {
        this.indexNumber = indexNumber;
        this.description = description;
        this.consumer = consumer;
        StringBuilder sb = new StringBuilder();
        int priority = 0;
        if (indexNumber.contains(".")) {
            char[] chars = indexNumber.toCharArray();
            for (char ch: chars) {
                if (ch == '.') {
                    ++priority;
                    sb.append('-');
                    sb.append('-');
                }
            }
        }
        this.priority = priority;
        this.pref = sb.toString();
    }

    public Item() {
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void itemAccept(T t) {
        consumer.accept(t);
    }

    public String getPref() {
        return pref;
    }

    public int getPriority() {
        return priority;
    }

    public void chekPriority(String indexNumber) {
        StringBuilder sb = new StringBuilder();
        int pr = 0;
        if (indexNumber.contains(".")) {
            char[] chars = indexNumber.toCharArray();
            for (char ch: chars) {
                if (ch == '.') {
                    ++pr;
                    sb.append('-');
                    sb.append('-');
                }
            }
        }
        this.priority = pr;
        this.pref = sb.toString();
    }

    @Override
    public String toString() {
        return  pref + indexNumber + " " + description;
    }
}

