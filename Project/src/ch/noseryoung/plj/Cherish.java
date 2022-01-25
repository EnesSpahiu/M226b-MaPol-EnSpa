package ch.noseryoung.plj;

public class Cherish {

    private Animal animal;

    IO io = new IO();

    public Cherish() {
    }

    public Cherish(Animal animal) {
        this.animal = animal;
    }

    public void cherishInput() {
        switch (io.cherishVisorInput()) {
            case 1 -> addCherish();
            case 2 -> editCherish();
            case 3 -> deleteCherish();
        }
    }

    public void addCherish() {
        System.out.println("Added Cherish");
    }

    public void editCherish() {
        System.out.println("Edited Cherish");
    }

    public void deleteCherish() {
        System.out.println("Deleted Cherish");
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
