package ch.noseryoung.plj;

import ch.noseryoung.plj.supervisor.Supervisor;
import ch.noseryoung.plj.visitor.Visitor;

/**
 * This class ZooManager handles the Zoo. It runs a switch case.
 **/
public class ZooManager {

    IO io = new IO();
    Visitor visitor = new Visitor();
    Supervisor sv = new Supervisor();

    /**
     * The function initProject() handles the first input from the user. If the user wants to check if account has to
     * sign up, then the program will call the function for that. If the user wants to login himself into the program,
     * then the program checks the user.
     */
    public void initProject() {
        int answer = 0;

        while (answer <= 2 && answer >= 0) {
            answer = io.startProgram();

            switch (answer) {
                case 1 -> visitor.checkIfHasAccountOrSignUp();
                case 2 -> sv.loginSuperVisor();
            }
        }
    }


}
