package org.example;

import org.example.enums.Plan;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("-----------------------");

        runMethods();
    }

    public static void runMethods() {
        Healthplan basicPlan = new Healthplan(1, "Basic Sigorta", Plan.BASIC);
        System.out.println(basicPlan.toString());

        System.out.println("-----------------------");

        String[] healthplans = new String[3];
        Employee employee = new Employee(1, "Ömer Developer", "omer@test.com", "1234", healthplans);

        employee.addHealthPlan(0, Plan.BASIC.getName());
        employee.addHealthPlan(0, "Z Sigorta");
        employee.addHealthPlan(5, "Geçersiz");

        System.out.println(employee.toString());

        System.out.println("-----------------------");

        String[] devs = new String[2];
        Company company = new Company(1, "Saint Tech", 150000, devs);

        company.addEmployee(0, "Ahmet");
        company.addEmployee(1, "Ayşe");

        System.out.println(company.toString());
    }
    }
