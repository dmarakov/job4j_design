package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportHRTest {

    @Test
    public void whenOldGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Alexander", now, now, 200);
        Employee worker3 = new Employee("Stas", now, now, 350);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        store.add(worker3);
        store.add(worker2);
        Report hr = new ReportHR(store, parser);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary ")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary()).append(" ")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary()).append(" ")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(" ")
                .append(worker3.getSalary()).append(" ")
                .append(System.lineSeparator());
        assertThat(hr.generate(em -> true)).isEqualTo(expect.toString());
    }
}