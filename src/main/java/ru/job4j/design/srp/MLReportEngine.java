package ru.job4j.design.srp;

import java.util.function.Predicate;

public class MLReportEngine implements Report {
    private Store store;
    private String metaHeader;
    private String body;
    private String footer;

    public MLReportEngine(Store store, String metaHeaderTemplate,
                          String bodyTemplate, String footerTemplate) {
        this.store = store;
        this.metaHeader = metaHeaderTemplate;
        this.body = bodyTemplate;
        this.footer = footerTemplate;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append(metaHeader);
        for (Employee employee : store.findBy(filter)) {
            if (body.contains("${name}")) {
                body = body.replace("${name}", employee.getName());
            }
            if (body.contains("${salary}")) {
                body = body.replace("${salary}",
                        String.format("%10.2f", employee.getSalary()));
            }
            if (body.contains("${hired}")) {
                body = body.replace("${hired}",
                        String.format("%1$td.%1$tm.%1$tY", employee.getHired()));
            }
            if (body.contains("${fired}")) {
                body = body.replace("${fired}",
                        String.format("%1$td.%1$tm.%1$tY", employee.getFired()));
            }
            text.append(body);
        }
        text.append(footer);
        return text.toString();
    }
}
