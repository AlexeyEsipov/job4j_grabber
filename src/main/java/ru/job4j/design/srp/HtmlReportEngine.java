package ru.job4j.design.srp;

import java.util.function.Predicate;

public class HtmlReportEngine implements Report {
    final private Store store;

    public HtmlReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>")
            .append(System.lineSeparator())
            .append("<html>")
            .append(System.lineSeparator())
            .append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</html>");
        return text.toString();
    }
}
