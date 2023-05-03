package ru.job4j.serialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @XmlAttribute
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

    public Employee() {

    }

    public boolean isActive() {
        return isActive;
    }

    public int getAge() {
        return age;
    }

    public String getLogin() {
        return login;
    }

    public String[] getRoles() {
        return roles;
    }

    public Department getDepartment() {
        return department;
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
