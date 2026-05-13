package org.example;

import org.example.entity.Employee;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> emp1 = new LinkedList<>();
        emp1.add(new Employee(1, "Dogancan", "Kinik"));
        emp1.add(new Employee(1, "Dogancan", "Kinik"));
        emp1.add(new Employee(2, "Seyyit Battal", "Arvas"));
        emp1.add(new Employee(2, "Seyyit Battal", "Arvas"));
        emp1.add(new Employee(3, "Anil", "Ensari"));
        emp1.add(new Employee(3, "Anil", "Ensari"));
        emp1.add(new Employee(4, "Burak", "Cevizli"));
        emp1.add(null);

        findDuplicates(emp1);
        System.out.println("--------------------");
        findUniques(emp1);
    }

    public static List<Employee> findDuplicates(List<Employee> employee) {
        if (employee == null) return new ArrayList<>();

        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicates = new LinkedHashSet<>();
        for (Employee emp : employee) {
            if (emp != null && !seen.add(emp)) {
                duplicates.add(emp);
            }
        }
        System.out.println(duplicates);
        return new ArrayList<>(duplicates);
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employee) {
        if (employee == null) return new HashMap<>();

        Map<Integer, Employee> uniques = new HashMap<>();
        for (Employee emp : employee) {
            if (emp != null) {
                uniques.put(emp.getId(), emp);
            }
        }
        System.out.println(uniques);
        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        if (employees == null) return new ArrayList<>();

        Map<Integer, Integer> counts = new HashMap<>();
        for (Employee emp : employees) {
            if (emp != null) {
                counts.put(emp.getId(), counts.getOrDefault(emp.getId(), 0) + 1);
            }
        }

        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp != null && counts.get(emp.getId()) == 1) {
                result.add(emp);
            }
        }
        return result;
    }
}