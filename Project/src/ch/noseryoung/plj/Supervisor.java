package ch.noseryoung.plj;

public class Supervisor {

    private String name;
    private Cherish cherish;

    IO io = new IO();

    public Supervisor(String name, Cherish cherish) {
        this.name = name;
        this.cherish = cherish;
    }

    public void superVisorInput() {
        switch (io.superVisorInput()){
            case 1 -> addSuperVisor();
            case 2 -> editSuperVisor();
            case 3 -> deleteSuperVisor();
        }
    }

    public Supervisor() {
    }

    public void addSuperVisor() {
        System.out.println("Added Supervisor");
    }

    public void editSuperVisor() {
        System.out.println("Edited Supervisor");
    }

    public void deleteSuperVisor() {
        System.out.println("Deleted Supervisor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cherish getCherish() {
        return cherish;
    }

    public void setCherish(Cherish cherish) {
        this.cherish = cherish;
    }
}
