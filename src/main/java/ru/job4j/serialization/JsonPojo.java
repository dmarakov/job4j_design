package ru.job4j.serialization;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonPojo {
    public static void main(String[] args) {
        final Employee employee = new Employee(false, 30, "vpetrov",
                new String[]{"Tester", "Manager"}, new Department("QA"));
        JSONObject jsonDepartment = new JSONObject("{\"departmentName\" :\"Developers\"}");
        List<String> list = new ArrayList<>();
        list.add("Dev");
        list.add("Manager");
        JSONArray jsonRoles = new JSONArray(list);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isActive", employee.isActive());
        jsonObject.put("age", employee.getAge());
        jsonObject.put("login", employee.getLogin());
        jsonObject.put("department", jsonDepartment);
        jsonObject.put("roles", jsonRoles);

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(employee).toString());

    }
}
