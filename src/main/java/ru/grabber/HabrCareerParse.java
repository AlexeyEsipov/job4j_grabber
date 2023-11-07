package ru.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.grabber.utils.DateTimeParser;
import ru.grabber.utils.Parse;
import ru.grabber.utils.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse implements Parse {
    private static final String SOURCE_LINK = "https://career.habr.com";
    private static final String PAGE_LINK =
            String.format("%s/vacancies/java_developer?page=", SOURCE_LINK);
    private static final int PAGE = 5;

    private final DateTimeParser dateTimeParser;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    private String retrieveDescription(String link) {
        String rsl;
        try {
            Connection connection = Jsoup.connect(link);
            Document document = connection.get();
            Element description = document.select(".style-ugc").first();
            rsl = description.text();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return rsl;
    }

    private Post post(Element row) {
        Element titleElement = row.select(".vacancy-card__title").first();
        Element linkElement = titleElement.child(0);
        Element dateTitleElement = row.select(".vacancy-card__date").first();
        String linkToVacancy = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
        return new Post(titleElement.text(), linkToVacancy, retrieveDescription(linkToVacancy),
                dateTimeParser.parse(dateTitleElement.child(0).attr("datetime")));
    }

    @Override
    public List<Post> list(String link) {
        List<Post> postList = new ArrayList<>();
        for (int i = 1; i <= PAGE; i++) {
            try {
                Connection connection = Jsoup.connect(link + i);
                Document document = connection.get();
                Elements rows = document.select(".vacancy-card__inner");
                rows.forEach(row -> postList.add(post(row)));
            } catch (IOException e) {
                throw new IllegalArgumentException();
            }
        }
        return postList;
    }
}

