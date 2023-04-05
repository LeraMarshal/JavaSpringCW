package de.marshal.javaspringcw.entities.helloworld;

import org.springframework.stereotype.Component;

public class Person {
    private String name;
    private int age;
    private Country country;

    public Person(String name, int age, Country country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void introduce(){
        System.out.println("Action on init step");
    }

    public void finishOperation(){
        System.out.println("Final work with bean");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country=" + country +
                '}';
    }
}
