package ch.noseryoung.plj.animal;

import ch.noseryoung.plj.IO;

import java.util.List;

public class Animal {

    private String name;
    private int age;

    IO io = new IO();

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {
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

}
