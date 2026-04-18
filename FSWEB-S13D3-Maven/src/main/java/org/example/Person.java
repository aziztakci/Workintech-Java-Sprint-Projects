package org.example;

public class Person {

    String firstName;
    String lastName;
    int age;
    double salary;
    boolean isMarried;
    String city;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String firstName, String lastName, int age, double salary, boolean isMarried, String city) {
        // Constructor Chaining: Yukarıdaki constructor'ı çağırıyoruz
        this(firstName, lastName, age);
        this.salary = salary;
        this.isMarried = isMarried;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isTeen() {
        return age >= 13 && age <= 19;
    }

}
