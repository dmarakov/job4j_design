package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

class ReportJsonTest {
    @Test
    public void whenReportJsonGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Sasha", now, now, 200);
        store.add(worker);
        store.add(worker1);
        ReportDateTimeParser parser = new ReportDateTimeParser();
        Report reportJson = new ReportJSON(store);

        String expect = String.format("""
                        [
                          {
                            "name": "Ivan",
                            "hired": "%s",
                            "fired": "%s",
                            "salary": 100.0
                          },
                          {
                            "name": "Sasha",
                            "hired": "%s",
                            "fired": "%s",
                            "salary": 200.0
                          }
                        ]""",
                parser.parse(worker.getHired()), parser.parse(worker.getFired()),
                parser.parse(worker1.getHired()), parser.parse(worker1.getFired())
        );
        Assertions.assertEquals(expect, reportJson.generate(em -> true));
    }
}