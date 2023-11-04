package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
        Report reportJson = new ReportJSON(store);
        String expect = "[\n"
                + "  {\n"
                + "    \"name\": \"Ivan\",\n"
                + "    \"hired\": {\n"
                + "      \"year\": " + now.get(Calendar.YEAR) + ",\n"
                + "      \"month\": " + now.get(Calendar.MONTH) + ",\n"
                + "      \"dayOfMonth\": " + now.get(Calendar.DAY_OF_MONTH) + ",\n"
                + "      \"hourOfDay\": " + now.get(Calendar.HOUR_OF_DAY) + ",\n"
                + "      \"minute\": " + now.get(Calendar.MINUTE) + ",\n"
                + "      \"second\": " + now.get(Calendar.SECOND) + "\n"
                + "    },\n"
                + "    \"fired\": {\n"
                + "      \"year\": " + now.get(Calendar.YEAR) + ",\n"
                + "      \"month\": " + now.get(Calendar.MONTH) + ",\n"
                + "      \"dayOfMonth\": " + now.get(Calendar.DAY_OF_MONTH) + ",\n"
                + "      \"hourOfDay\": " + now.get(Calendar.HOUR_OF_DAY) + ",\n"
                + "      \"minute\": " + now.get(Calendar.MINUTE) + ",\n"
                + "      \"second\": " + now.get(Calendar.SECOND) + "\n"
                + "    },\n"
                + "    \"salary\": 100.0\n"
                + "  },\n"
                + "  {\n"
                + "    \"name\": \"Sasha\",\n"
                + "    \"hired\": {\n"
                + "      \"year\": " + now.get(Calendar.YEAR) + ",\n"
                + "      \"month\": " + now.get(Calendar.MONTH) + ",\n"
                + "      \"dayOfMonth\": " + now.get(Calendar.DAY_OF_MONTH) + ",\n"
                + "      \"hourOfDay\": " + now.get(Calendar.HOUR_OF_DAY) + ",\n"
                + "      \"minute\": " + now.get(Calendar.MINUTE) + ",\n"
                + "      \"second\": " + now.get(Calendar.SECOND) + "\n"
                + "    },\n"
                + "    \"fired\": {\n"
                + "      \"year\": " + now.get(Calendar.YEAR) + ",\n"
                + "      \"month\": " + now.get(Calendar.MONTH) + ",\n"
                + "      \"dayOfMonth\": " + now.get(Calendar.DAY_OF_MONTH) + ",\n"
                + "      \"hourOfDay\": " + now.get(Calendar.HOUR_OF_DAY) + ",\n"
                + "      \"minute\": " + now.get(Calendar.MINUTE) + ",\n"
                + "      \"second\": " + now.get(Calendar.SECOND) + "\n"
                + "    },\n"
                + "    \"salary\": 200.0\n"
                + "  }\n"
                + "]";
        Assertions.assertEquals(expect, reportJson.generate(em -> true));
    }
}