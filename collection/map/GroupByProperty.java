package collection.map;

/*
 * Question 5: Group Objects by Property
 * Given a list of Employee objects, group them by their department using a Map<Department, List<Employee>>.
 * Example: Employees: [Alice (HR), Bob (IT), Carol (HR)] → Output: HR: [Alice, Carol], IT: [Bob]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByProperty {
    
    // Employee class
    static class Employee {
        private String name;
        private String department;
        private int salary;
        
        public Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        
        public String getName() {
            return name;
        }
        
        public String getDepartment() {
            return department;
        }
        
        public int getSalary() {
            return salary;
        }
        
        @Override
        public String toString() {
            return name + " (" + department + ", $" + salary + ")";
        }
    }
    
    // Group employees by department
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> groupedMap = new HashMap<>();
        
        for (Employee employee : employees) {
            String department = employee.getDepartment();
            
            // If department doesn't exist in map, create new list
            if (!groupedMap.containsKey(department)) {
                groupedMap.put(department, new ArrayList<>());
            }
            
            // Add employee to department list
            groupedMap.get(department).add(employee);
        }
        
        return groupedMap;
    }
    
    // Group employees by department using computeIfAbsent
    public static Map<String, List<Employee>> groupByDepartmentModern(List<Employee> employees) {
        Map<String, List<Employee>> groupedMap = new HashMap<>();
        
        for (Employee employee : employees) {
            groupedMap.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>())
                     .add(employee);
        }
        
        return groupedMap;
    }
    
    // Group employees by salary range
    public static Map<String, List<Employee>> groupBySalaryRange(List<Employee> employees) {
        Map<String, List<Employee>> groupedMap = new HashMap<>();
        
        for (Employee employee : employees) {
            String range;
            int salary = employee.getSalary();
            
            // Determine salary range
            if (salary < 50000) {
                range = "Below 50K";
            } else if (salary < 75000) {
                range = "50K-75K";
            } else if (salary < 100000) {
                range = "75K-100K";
            } else {
                range = "Above 100K";
            }
            
            groupedMap.computeIfAbsent(range, k -> new ArrayList<>()).add(employee);
        }
        
        return groupedMap;
    }
    
    // Count employees per department
    public static Map<String, Integer> countByDepartment(List<Employee> employees) {
        Map<String, Integer> countMap = new HashMap<>();
        
        for (Employee employee : employees) {
            String department = employee.getDepartment();
            countMap.put(department, countMap.getOrDefault(department, 0) + 1);
        }
        
        return countMap;
    }
    
    // Display grouped employees
    public static void displayGroupedEmployees(Map<String, List<Employee>> groupedMap) {
        for (Map.Entry<String, List<Employee>> entry : groupedMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Employee emp : entry.getValue()) {
                System.out.println("  - " + emp);
            }
        }
    }
    
    public static void main(String[] args) {
        // Create employee list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR", 55000));
        employees.add(new Employee("Bob", "IT", 75000));
        employees.add(new Employee("Carol", "HR", 60000));
        employees.add(new Employee("David", "IT", 80000));
        employees.add(new Employee("Eve", "Finance", 70000));
        employees.add(new Employee("Frank", "IT", 90000));
        employees.add(new Employee("Grace", "HR", 58000));
        employees.add(new Employee("Henry", "Finance", 95000));
        
        System.out.println("=== All Employees ===");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        
        System.out.println("\n=== Grouped by Department ===");
        Map<String, List<Employee>> byDepartment = groupByDepartment(employees);
        displayGroupedEmployees(byDepartment);
        
        System.out.println("\n=== Employee Count by Department ===");
        Map<String, Integer> countByDept = countByDepartment(employees);
        for (Map.Entry<String, Integer> entry : countByDept.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " employees");
        }
        
        System.out.println("\n=== Grouped by Salary Range ===");
        Map<String, List<Employee>> bySalaryRange = groupBySalaryRange(employees);
        displayGroupedEmployees(bySalaryRange);
        
        System.out.println("\n=== Using Modern Approach ===");
        Map<String, List<Employee>> modernGrouping = groupByDepartmentModern(employees);
        System.out.println("Departments: " + modernGrouping.keySet());
        System.out.println("IT Department size: " + modernGrouping.get("IT").size());
    }
}
