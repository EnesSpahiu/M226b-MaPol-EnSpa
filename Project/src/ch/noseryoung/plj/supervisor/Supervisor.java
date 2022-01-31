package ch.noseryoung.plj.supervisor;

import ch.noseryoung.plj.IO;
import ch.noseryoung.plj.User;
import ch.noseryoung.plj.animal.Animal;
import ch.noseryoung.plj.animal.animals.*;
import ch.noseryoung.plj.cherish.Cherish;

/**
 * This class Supervisor extends the User.
 */
public class Supervisor extends User {

    Animal animal;
    Cherish cherish;

    private Cherish cherishOfSuperVisor;

    IO io = new IO();
    DB_Supervisor db = new DB_Supervisor();

    public Supervisor(String name, String lastName, String password) {
        super(name, lastName, password);
    }

    public Supervisor(String name, String lastName, String password, String cherishname) {
        super(name, lastName, password);
        switch (cherishname.toLowerCase()){
            case "tigercherish" -> setCherishOfSuperVisor(new Cherish("Tigercherish", new Tiger("SomeTiger", 3)));
            case "sharkcherish" -> setCherishOfSuperVisor(new Cherish("Sharkcherish", new Shark("SomeShark", 12)));
            case "frogcherish" -> setCherishOfSuperVisor(new Cherish("Frogcherish", new Frog("SomeFrog", 5)));
            case "crocodilecherish" -> setCherishOfSuperVisor(new Cherish("Crocodilecherish", new Crocodile("SomeCrocodile", 2)));
            case "birdcherish" -> setCherishOfSuperVisor(new Cherish("BirdCherish", new Bird("SomeBird", 8)));
        }
    }

    public Supervisor(){
        super();
    }

    public void superVisorInput() {
        int answer = 0;
        while(answer >= 0 && answer <= 3){
            answer = io.superVisorInput();
            switch (io.superVisorInput()){
                case 1 -> addSuperVisor();
                case 2 -> editSuperVisor();
                case 3 -> deleteSuperVisor();
            }
        }
    }

    public void loginSuperVisor() {
        db.loginUser();
        superVisorInput();
    }

    public void addSuperVisor() {
        db.insertData();
    }

    public void editSuperVisor() {
        db.updateTable();
    }

    public void deleteSuperVisor() {
        db.deleteData();
    }

    public Cherish getCherishOfSuperVisor() {
        return cherishOfSuperVisor;
    }

    public void setCherishOfSuperVisor(Cherish cherishOfSuperVisor) {
        this.cherishOfSuperVisor = cherishOfSuperVisor;
    }
}
