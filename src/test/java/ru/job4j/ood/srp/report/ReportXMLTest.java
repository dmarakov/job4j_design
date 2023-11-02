package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class ReportXmlTest {
    @Test
    public void whenReportXmlGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String nowFormattedDate = simpleDateFormat.format(now.getTime());
        System.out.println(nowFormattedDate);
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Sasha", now, now, 200);
        store.add(worker);
        store.add(worker1);
        Report reportXml = new ReportXML(store);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<employees><employees>" +
                "<name>Ivan</name><hired>" + nowFormattedDate + "</hired><fired>" +
                nowFormattedDate + "</fired><salary>100.0</salary></employees>" +
                "<employees><name>Sasha</name><hired>" + nowFormattedDate +
                "</hired><fired>" + nowFormattedDate + "</fired><salary>200.0</salary></employees>" +
                "</employees>";
        Assertions.assertEquals(expect, reportXml.generate(em -> true).replaceAll("\\s*<\\s*", "<").replaceAll("\\s*>\\s*", ">"));
    }
}