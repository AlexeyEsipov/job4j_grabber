package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;
import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HRReportEngineTest {
    @Test
    public void whenHRReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerIvan = new Employee("Ivan", now, now, 100);
        Employee workerAlex = new Employee("Alex", now, now, 200);

        store.add(workerIvan);
        store.add(workerAlex);
        Report engine = new HRReportEngine(store,
                Comparator.comparingDouble(Employee::getSalary).reversed());
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(workerAlex.getName()).append(";")
                .append(workerAlex.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(workerIvan.getName()).append(";")
                .append(workerIvan.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}