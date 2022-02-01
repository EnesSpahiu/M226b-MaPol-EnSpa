package ch.noseryoung.plj.cherish;

import ch.noseryoung.plj.animal.Animal;
import ch.noseryoung.plj.IO;

/**
 * This class handles the cherish. It uses the  attributes name and animal.
 */
public class Cherish {

    private String name;
    private Animal animal;

    IO io = new IO();

    public Cherish() {
    }

    public Cherish(String name, Animal animal) {
        this.name = name;
        this.animal = animal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
