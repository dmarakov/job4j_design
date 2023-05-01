package ru.job4j.serialization;

import java.util.Arrays;

public class Employee {
    private boolean isActive;
    private int age;
    private String login;
    private String[] roles;
    private Department department;

    public Employee(boolean isActive, int age, String login, String[] roles, Department department) {
        this.isActive = isActive;
        this.age = age;
        this.login = login;
        this.roles = roles;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "isActive=" + isActive + ", age=" + age
                + ", login='" + login + '\''
                + ", roles=" + Arrays.toString(roles)
                + ", department=" + department + '}';
    }
}
