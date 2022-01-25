package ch.noseryoung.plj;

public class Visitor {

    private String firstName;
    private String lastName;
    private int age;
    private boolean isMember;

    IO io = new IO();

    public Visitor(String firstName, String lastName, int age, boolean isMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMember = isMember;
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
        System.out.println("Logged In");
        System.out.println("Welcome back to our zoo");
    }

    public void signUp () {
        System.out.println("Signed Up");
        System.out.println("Welcome to our zoo");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }
}
