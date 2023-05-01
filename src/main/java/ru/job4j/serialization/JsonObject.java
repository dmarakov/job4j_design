package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonObject {
    public static void main(String[] args) {
        final Employee employee = new Employee(false, 30, "vpetrov",
                new String[]{"Tester", "Manager"}, new Department("QA"));

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(employee));

        final String employeeJson =
                "{"
                        + "\"isActive\" : true,"
                        + "\"age\" :30,"
                        + "\"login\" :\"aivanov\","
                        + "\"roles\" : "
                        + "[\"Developer\", \"Manager\"],"
                        + "\"department\":"
                        + "{"
                        + "\"departmentName\" :\"QA\""
                        + "}"
                        + "}";
        final Employee employeeMod = gson.fromJson(employeeJson, Employee.class);
        System.out.println(employeeMod);
    }
}