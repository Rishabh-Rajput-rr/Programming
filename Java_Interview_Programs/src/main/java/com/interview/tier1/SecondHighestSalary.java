package com.interview.tier1;

import java.util.*;

public class SecondHighestSalary {

    // Stream: distinct prevents duplicate highest salaries
    public static Optional<Integer> streamApproach(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getSalary)
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    // Optimized: one pass, O(n) time and O(1) extra space
    public static Optional<Integer> optimized(List<Employee> employees) {
        Integer highest = null;
        Integer second = null;

        for (Employee employee : employees) {
            Integer salary = employee.getSalary();
            if (salary == null) continue;

            if (highest == null || salary > highest) {
                second = highest;
                highest = salary;
            } else if (salary < highest && (second == null || salary > second)) {
                second = salary;
            }
        }
        return Optional.ofNullable(second);
    }

    public static class Employee {
        private final int id;
        private final String name;
        private final Integer salary;

        public Employee(int id, String name, Integer salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public Integer getSalary() { return salary; }

        @Override
        public String toString() {
            return id + " " + name + " " + salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "A", 80000),
                new Employee(2, "B", 95000),
                new Employee(3, "C", 95000),
                new Employee(4, "D", 70000),
                new Employee(5, "E", null)
        );

        System.out.println(streamApproach(employees).orElse(null));
        System.out.println(optimized(employees).orElse(null));
    }
}
