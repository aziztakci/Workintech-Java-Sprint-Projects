package org.example;

import java.util.Arrays;

public class Company {
    private long id;
    private String name;
    private  double giro;
    private String[] developerNames;

    public Company(long id, String name, double giro, String[] developerNames) {
        this.id = id;
        this.name = name;
        this.giro = Math.max(0,giro);
        this.developerNames = developerNames;
    }

    public void addEmployee(int index, String name) {

        if(index < 0 || index >= developerNames.length) {
            System.out.println("index is no allowed " + index );
            return;
        }
        if (developerNames[index] == null) {
            developerNames[index] = name;
        } else {
            System.out.println("index (" +index + ") is already taken.");
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGiro() {
        return giro;
    }

    public String[] getDeveloperNames() {
        return developerNames;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", giro=" + giro +
                ", developerNames=" + Arrays.toString(developerNames) +
                '}';
    }
}
