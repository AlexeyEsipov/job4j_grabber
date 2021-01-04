package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SqlRuParse {

    public static LocalDateTime dateConvert(String s) {
        LocalDate date = LocalDate.now();
        LocalTime lt = LocalTime.parse(s.substring(s.length() - 5));
        if (s.startsWith("вчера")) {
            return date.minusDays(1).atTime(lt);
        } else if (s.startsWith("сегодня")) {
            return date.atTime(lt);
        } else {
            StringBuilder sb = new StringBuilder(s);
            return LocalDateTime.parse(sb.insert(s.length() - 10, "."),
                    DateTimeFormatter.ofPattern("d MMM uu, HH:mm", new Locale("ru", "RU")));
        }
    }

    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();
        Element forumTable = doc.select("table").get(2);
        Elements rows = forumTable.select("tr");
        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");
            System.out.println(cols.get(1).child(0).attr("href"));
            System.out.println(cols.get(1).child(0).text());
            String s = cols.get(5).text();
            System.out.println(cols.get(5).text());
            LocalDateTime dateJava = dateConvert(s);
            System.out.println(dateJava);
        }
    }
}
