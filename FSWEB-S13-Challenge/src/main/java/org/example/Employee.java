package org.example;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Employee {
    private long id;
    private String fullName;
    private String email;
    private String password;
    private String[] healthPlans;

    public Employee(long id, String fullName, String email, String password, String[] healthplans) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.healthPlans = healthplans;
    }

    public void addHealthPlan(int index, String name) {
        if(index < 0 || index >= healthPlans.length) {
            System.out.println("index is no allowed " + index );
            return;
        }
        if (healthPlans[index] == null) {
            healthPlans[index] = name;
        } else {
            System.out.println("index (" +index + ") is already taken.");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", healthplans=" + Arrays.toString(healthPlans) +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String[] getHealthPlans() {
        return healthPlans;
    }


}
