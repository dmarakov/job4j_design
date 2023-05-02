package ru.job4j.serialization;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "department")

public class Department {

    @XmlAttribute
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department() {

    }

    @Override
    public String toString() {
        return "Department{"
                + "departmentName='" + departmentName + '\'' + '}';
    }
}
