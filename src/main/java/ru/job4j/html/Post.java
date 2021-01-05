package ru.job4j.html;

import java.time.LocalDate;

public class Post {
    private int id;
    private String url;
    private String name;
    private String text;
    private LocalDate created;

    public Post(String url, String name, String text, LocalDate date) {
        this.url = url;
        this.name = name;
        this.text = text;
        this.created = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return created;
    }

    public void setCreatedDate(LocalDate date) {
        this.created = date;
    }
}
