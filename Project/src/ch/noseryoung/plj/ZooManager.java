package ch.noseryoung.plj;

import ch.noseryoung.plj.supervisor.Supervisor;
import ch.noseryoung.plj.visitor.Visitor;

public class ZooManager {

    IO io = new IO();
    Visitor visitor = new Visitor();
    Supervisor sv = new Supervisor();

    public void initProject() {
        int answer = 0;

        while (answer <= 3 && answer >= 0) {
            answer = io.startProgram();

            switch (answer) {
                case 1 -> visitor.checkIfHasAccountOrSignUp();
                case 2 -> sv.loginSuperVisor();
            }
        }
    }


}
