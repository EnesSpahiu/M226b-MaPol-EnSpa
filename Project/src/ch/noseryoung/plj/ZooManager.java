package ch.noseryoung.plj;

public class ZooManager {

    IO io = new IO();
    Visitor visitor = new Visitor();
    Supervisor sv = new Supervisor();
    Cherish cherish = new Cherish();
    Animal animal = new Animal();

    public void initProject() {
        int answer = 0;

        while (answer <= 3 && answer >= 0) {
            answer = io.startProgram();

            switch (answer) {
                case 1 -> visitor.checkIfHasAccountOrSignUp();
                case 2 -> sv.superVisorInput();
                case 3 -> cherish.cherishInput();
                case 4 -> animal.AnimalInput();
            }
        }
    }


}
