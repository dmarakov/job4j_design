package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportProgrammerTest {

    @Test
    public void whenOldGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        String delimiter = ",";
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportProgrammer(store, parser, delimiter);
        StringBuilder expect = new StringBuilder()
                .append("Name,Hired,Fired,Salary,")
                .append(System.lineSeparator())
                .append(worker.getName()).append(",")
                .append(parser.parse(worker.getHired())).append(",")
                .append(parser.parse(worker.getFired())).append(",")
                .append(worker.getSalary()).append(",")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}