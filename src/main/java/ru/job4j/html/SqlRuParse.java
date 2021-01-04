package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SqlRuParse {
    private static final Map<String, String> SM = new HashMap<>();

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

    private LocalDateTime dateConvert(String s) {
        LocalDate date = LocalDate.now();
        LocalTime lt = LocalTime.parse(s.substring(s.length() - 5));
        if (s.startsWith("вчера")) {
            return date.minusDays(1).atTime(lt);
        } else if (s.startsWith("сегодня")) {
            return date.atTime(lt);
        } else {
            StringBuilder sb = new StringBuilder(s);
            var start = s.length() - 13;
            var end = s.length() - 10;
            var month = s.substring(start, end);
            return LocalDateTime.parse(sb.replace(start, end, SM.get(month)),
                    DateTimeFormatter.ofPattern("d MMM uu, HH:mm", new Locale("ru", "RU")));
        }
    }

    public void parse(String url, int pages) throws IOException {
        for (int j = 1; j <= pages; j++) {
            System.out.println("______________" + j + "__страница_____________________");
            Document doc = Jsoup.connect(url).get();
            Element forumTable = doc.select("table").get(2);
            Elements rows = forumTable.select("tr");
            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements columns = row.select("td");
                System.out.println(columns.get(1).child(0).attr("href"));
                System.out.println(columns.get(1).child(0).text());
                String s = columns.get(5).text();
                System.out.println(s);
                LocalDateTime dateJava = dateConvert(s);
                System.out.println(dateJava);
            }
            StringBuilder stringBuilder = new StringBuilder(url);
            url = stringBuilder.replace(url.length() - 1, url.length(),
                    String.valueOf(j + 1)).toString();
        }
    }

    public static void main(String[] args) throws Exception {
        SqlRuParse sqlRuParse = new SqlRuParse();
        String url = "https://www.sql.ru/forum/job-offers/1"; // последняя цифра - номер страницы
        int pages = 5;
        sqlRuParse.parse(url, pages);
    }
}
