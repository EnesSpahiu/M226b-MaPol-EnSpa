package ch.noseryoung.plj.animal.animals;

import ch.noseryoung.plj.animal.Animal;

/**
 * The class Bird extends the class Animal.
 * In this class there are only constructors, one empty super constructor and the other one got the attributes: name and age.
 */
public class Bird extends Animal {

    public Bird() {
        super();
    }

    public Bird(String name, int age) {
        super(name, age);
    }

}
