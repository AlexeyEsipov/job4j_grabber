package ru.job4j.grabber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SqlRuParse implements Parse {
    private static final Map<String, String> SM = new HashMap<>();
    private static int id = -1;

    static {
        SM.put("янв", "янв.");
        SM.put("фев", "февр.");
        SM.put("мар", "мар.");
        SM.put("апр", "апр.");
        SM.put("май", "мая");
        SM.put("июн", "июн.");
        SM.put("июл", "июл.");
        SM.put("авг", "авг.");
        SM.put("сен", "сент.");
        SM.put("окт", "окт.");
        SM.put("ноя", "нояб.");
        SM.put("дек", "дек.");
    }

    private LocalDate dateConvert(String s) {
        LocalDate date = LocalDate.now();
        if (s.startsWith("вчера")) {
            return date.minusDays(1);
        } else if (s.startsWith("сегодня")) {
            return date;
        } else {
            StringBuilder sb = new StringBuilder(s);
            var start = s.length() - 6;
            var end = s.length() - 3;
            var month = s.substring(start, end);
            return LocalDate.parse(sb.replace(start, end, SM.get(month)),
                    DateTimeFormatter.ofPattern("d MMM uu", new Locale("ru", "RU")));
        }
    }

    @Override
    public List<Post> list(String url)  {
        List<Post> postList = new ArrayList<>();
        try {
            for (int j = 1; j <= 5; j++) {
                Document doc = Jsoup.connect(url).get();
                Element forumTable = doc.select("table").get(2);
                Elements rows = forumTable.select("tr");
                for (int i = 4; i < rows.size(); i++) {
                    Element row = rows.get(i);
                    Elements columns = row.select("td");
                    String link = columns.get(1).child(0).attr("href");
                    System.out.println(link);
                    postList.add(detail(link));
                }
                StringBuilder stringBuilder = new StringBuilder(url);
                url = stringBuilder.replace(url.length() - 1, url.length(),
                        String.valueOf(j + 1)).toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postList;
    }

    @Override
    public Post detail(String link) {
        String header = "";
        String body = "";
        String date = "1 янв 00";
        String datS = "1 янв 00           1";
        try {
            Document  doc = Jsoup.connect(link).get();
            header = doc.select("title").get(0).ownText();

            Elements el1 = doc.select("#content-wrapper-forum > table:nth-child(4) "
                    + "> tbody > tr:nth-child(2) > td:nth-child(2)");
            int sel1 = el1.size();

            Elements el2 = doc.select("#content-wrapper-forum > table:nth-child(3) "
                    + "> tbody > tr:nth-child(2) > td:nth-child(2)");
            int sel2 = el2.size();

            if (sel1 == 1) {
                body = el1.get(0).ownText();
                datS = doc.select("#content-wrapper-forum > table:nth-child(4)"
                        + " > tbody > tr:nth-child(3) > td").get(0).ownText();
            } else if (sel2 == 1) {
                body = el2.get(0).ownText();
                datS = doc.select("#content-wrapper-forum > table:nth-child(3)"
                        + " > tbody > tr:nth-child(3) > td").get(0).ownText();
            }
            date = new StringBuilder(datS)
                    .delete(datS.length() - 12, datS.length()).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Post(++id, link, header, body, dateConvert(date));
    }
}
