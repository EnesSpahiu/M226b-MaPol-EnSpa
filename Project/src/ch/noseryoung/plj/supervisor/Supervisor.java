package ch.noseryoung.plj.supervisor;

import ch.noseryoung.plj.IO;
import ch.noseryoung.plj.User;
import ch.noseryoung.plj.animal.Animal;
import ch.noseryoung.plj.cherish.Cherish;

public class Supervisor extends User {

    Animal animal;
    Cherish cherish;

    private Cherish cherishOfSuperVisor;

    IO io = new IO();
    DB_Supervisor db = new DB_Supervisor();

    public Supervisor(String name, String lastName, String password) {
        super(name, lastName, password);
    }

    public Supervisor(){
        super();
    }

    public void superVisorInput() {
        switch (io.superVisorInput()){
            case 1 -> addSuperVisor();
            case 2 -> editSuperVisor();
            case 3 -> deleteSuperVisor();
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
