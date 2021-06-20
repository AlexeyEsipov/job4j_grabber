package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MLReportEngineTest {
    @Test
    public void whenHTMLGenerated() {
//        Store store = new MemStore();
//        Calendar now = Calendar.getInstance();
//        Employee worker = new Employee("Ivan", now, now, 100.00);
//        store.add(worker);
//        String header = "<!DOCTYPE html>"
//                + "<html>"
//                + "Name; Hired; Fired; Salary;";
//        String body = "${name};${hired};${fired};${salary};";
//        String footer = "</html>";
//        Report engine = new MLReportEngine(store, header, body, footer);
//        StringBuilder expect = new StringBuilder()
//        .append("<!DOCTYPE html>")
//                .append("<html>")
//                .append("Name; Hired; Fired; Salary;")
//                .append("Ivan;")
//                .append(String.format("%1$td.%1$tm.%1$tY", worker.getHired()))
//                .append(";")
//                .append(String.format("%1$td.%1$tm.%1$tY", worker.getFired()))
//                .append(";")
//                .append("    100,00;")
//                .append("</html>");
//        assertThat(engine.generate(em -> true), is(expect.toString()));
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100.00);
        store.add(worker);
        String header = "<!DOCTYPE html>"
                + "<html>"
                + "Name; Hired; Fired; Salary;";
        String body = "${name};${hired};${fired};${salary};";
        String footer = "</html>";
        Report engine = new MLReportEngine(store, header, body, footer);
        String actual = engine.generate(em -> true);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>")
                .append("<html>")
                .append("Name; Hired; Fired; Salary;")
                .append("Ivan;")
                .append(String.format("%1$td.%1$tm.%1$tY", worker.getHired()))
                .append(";")
                .append(String.format("%1$td.%1$tm.%1$tY", worker.getFired()))
                .append(";")
                .append("    100,00;")
                .append("</html>");
        String stringExpect = expect.toString();
        assertThat(actual, is(stringExpect));
    }

    @Test
    public void whenXMLGenerated() {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100.00);
        store.add(worker);
        String header = "<?xml version=\"1.1\" encoding=\"UTF-8\" ?>"
                + "<employees>";
        String body = "<employee>"
                + "<name>${name}</name>"
                + "<hired>${hired}</hired>"
                + "<fired>${fired}</fired>"
                + "<salary>${salary}</salary>"
                + "</employee>";
        String footer = "</employees>";
        Report engine = new MLReportEngine(store, header, body, footer);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.1\" encoding=\"UTF-8\" ?>")
                .append("<employees>")
                .append("<employee>")
                .append("<name>Ivan</name>")
                .append("<hired>")
                .append(String.format("%1$td.%1$tm.%1$tY", worker.getHired()))
                .append("</hired>")
                .append("<fired>")
                .append(String.format("%1$td.%1$tm.%1$tY", worker.getFired()))
                .append("</fired>")
                .append("<salary>    100,00</salary>")
                .append("</employee>")
                .append("</employees>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenJSONGenerated() {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100.00);
        store.add(worker);
        String header = "";
        String body = "{"
                + "\"name\":${name},"
                + "\"hired\":${hired},"
                + "\"fired\":${fired},"
                + "\"salary\":${salary}"
                + "}";
        String footer = "";
        Report engine = new MLReportEngine(store, header, body, footer);
        StringBuilder expect = new StringBuilder()
                .append("{\"name\":Ivan,")
                .append("\"hired\":")
                .append(String.format("%1$td.%1$tm.%1$tY", worker.getHired()))
                .append(",\"fired\":")
                .append(String.format("%1$td.%1$tm.%1$tY", worker.getFired()))
                .append(",\"salary\":    100,00}");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}