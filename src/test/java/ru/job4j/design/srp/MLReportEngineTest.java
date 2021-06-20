package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MLReportEngineTest {
    @Test
    public void whenHTMLGenerated() {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        String header = "<!DOCTYPE html>"
                + "<html>"
                + "Name; Hired; Fired; Salary;";
        String body = "${name};${hired};${fired};${salary};";
        String footer = "</html>";
        Report engine = new MLReportEngine(store, header, body, footer);
        String expect = "<!DOCTYPE html>"
                + "<html>"
                + "Name; Hired; Fired; Salary;"
                + "Ivan;"
                + String.format("%1$td.%1$tm.%1$tY", worker.getHired()) + ";"
                + String.format("%1$td.%1$tm.%1$tY", worker.getFired()) + ";"
                + "    100,00;"
                + "</html>";
//        assertEquals(expect, expect);
        assertEquals(engine.generate(em -> true), expect);
//        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenXMLGenerated() {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
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
        String expect = "<?xml version=\"1.1\" encoding=\"UTF-8\" ?>"
                + "<employees>"
                + "<employee>"
                + "<name>Ivan</name>"
                + "<hired>" + String.format("%1$td.%1$tm.%1$tY", worker.getHired()) + "</hired>"
                + "<fired>" + String.format("%1$td.%1$tm.%1$tY", worker.getFired()) + "</fired>"
                + "<salary>    100,00</salary>"
                + "</employee>"
                + "</employees>";
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenJSONGenerated() {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
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
        String expect = "{"
                + "\"name\":Ivan,"
                + "\"hired\":" + String.format("%1$td.%1$tm.%1$tY", worker.getHired()) + ","
                + "\"fired\":" + String.format("%1$td.%1$tm.%1$tY", worker.getFired()) + ","
                + "\"salary\":    100,00"
                + "}";
        assertThat(engine.generate(em -> true), is(expect));
    }
}