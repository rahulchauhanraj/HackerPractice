package com.rahul.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupByUsingStream {

    public static void main(String args[]) throws Exception {

        Employee e1 = new Employee("A", 1L, 0L);
        Employee e2 = new Employee("B", 2L, 1L);
        Employee e3 = new Employee("C", 3L, 1L);
        Employee e4 = new Employee("D", 4L, 2L);
        Employee e5 = new Employee("E", 5L, 2L);
        Employee e6 = new Employee("F", 6L, 5L);

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        Map<Optional<Long>, List<Employee>> result = employees.stream().collect(Collectors.groupingBy(e-> Optional.ofNullable(e.getManagerId())));

        System.out.println(result);
    }
}

class Employee{
    String name;
    Long id;
    Long managerId;

    public Employee(String name, Long id, Long managerId) {
        this.name = name;
        this.id = id;
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "name='" + name + '\'' +
            ", id=" + id +
            ", managerId=" + managerId +
            '}';
    }
}

