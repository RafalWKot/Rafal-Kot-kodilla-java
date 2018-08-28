package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private final String peselId;
    private final String firstname;
    private final String secondname;
    private final BigDecimal baseSalary;

    public Employee(String peselId, String firstname, String secondname, BigDecimal baseSalary) {
        this.peselId = peselId;
        this.firstname = firstname;
        this.secondname = secondname;
        this.baseSalary = baseSalary;
    }

    public String getPeselId() {
        return peselId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(peselId, employee.peselId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(peselId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "peselId='" + peselId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
