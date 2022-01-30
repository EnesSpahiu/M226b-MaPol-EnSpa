package ch.noseryoung.plj.visitor;

import ch.noseryoung.plj.IO;
import ch.noseryoung.plj.User;

public class Visitor extends User {

    private int age;

    IO io = new IO();
    DB_Visitor db = new DB_Visitor();

    public Visitor(String firstName, String lastName, String password, int age) {
        super(firstName, lastName, password);
        this.age = age;
    }

    public Visitor() {
    }

    public void checkIfHasAccountOrSignUp(){
        switch (io.hasAccount()){
            case 1 -> login();
            case 2 -> signUp();
        }
    }

    public void login() {
        db.loginUser();
    }

    public void signUp () {
        db.insertData();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
