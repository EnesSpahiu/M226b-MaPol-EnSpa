package ch.noseryoung.plj.visitor;

import ch.noseryoung.plj.IO;
import ch.noseryoung.plj.User;
import ch.noseryoung.plj.Zoo;

/**
 * The class Visitor extends the class user.
 * It has a constructor with the attributes firstName, lastName, password and age.
 * This class handles he visitor.
 */
public class Visitor extends User {

    private int age;

    IO io = new IO();
    DB_Visitor db = new DB_Visitor();
    Zoo zoo = new Zoo();

    public Visitor(String firstName, String lastName, String password, int age) {
        super(firstName, lastName, password);
        this.age = age;
    }

    public Visitor() {
    }

    /**
     * This function checks if the user has to an account, or if he needs to sign up first.
     * It's solved within a switch case
     */
    public void checkIfHasAccountOrSignUp(){
        int answer = 0;
        while(answer <= 4 && answer >= 0){
            answer = io.userOptions();
            switch (answer){
                case 1 -> signUp();
                case 2 -> login();
                case 3 -> deleteAcc();
                case 4 -> zoo.visitZoo();
            }
        }
    }

    public void login() {
        db.loginUser();
    }

    public void signUp () {
        db.insertData();
    }

    public void deleteAcc(){db.deleteData();}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DB_Visitor getDb() {
        return db;
    }

    public void setDb(DB_Visitor db) {
        this.db = db;
    }
}
