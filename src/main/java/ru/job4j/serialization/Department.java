package ru.job4j.serialization;

public class Department {
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{"
                + "departmentName='" + departmentName + '\'' + '}';
    }
}
