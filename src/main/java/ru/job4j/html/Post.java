package ru.job4j.html;

import java.time.LocalDate;

public class Post {
    private String url;
    private String text;
    private LocalDate data;

    public Post(String url, String text, LocalDate data) {
        this.url = url;
        this.text = text;
        this.data = data;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
