package ch.noseryoung.plj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {

    Scanner sc = new Scanner(System.in);

    public int startProgram() {
        int answer = 0;
        boolean errorOccured = true;

        while (errorOccured){
            try {
                drawBox(40, "1. Visitor");
                drawBox(40, "2. Login Supervisor ");
                drawBox(40, "3. Exit ");
                answer = sc.nextInt();
                sc.nextLine();
                errorOccured = false;
            }catch (InputMismatchException e){
                System.out.println("Wrong Input");
                sc.nextLine();
            }
        }
        return answer;
    }

    public int superVisorInput() {
        int answer = 0;
        boolean errorOccured = true;

        while (errorOccured){
            try {
                drawBox(40, "1. Add Supervisor ");
                drawBox(40, "2. Edit Supervisor");
                drawBox(40, "3. Delete Supervisor");
                drawBox(40, "4. Exit ");
                answer = sc.nextInt();
                sc.nextLine();
                errorOccured = false;
            }catch (InputMismatchException e){
                System.out.println("Wrong Input");
                sc.nextLine();
            }
        }
        return answer;
    }

    /**
     * Method: userOptions
     *
     * Function: Prints out options of user and gets his input while
     * trying to catch an InputMismatchException so the user can not type in
     * false inputs.
     *
     * @return answer -> Contains the answer which option the user chooses
     */
    public int userOptions() {
        int answer = 0;
        boolean errorOccurred = true;

        while (errorOccurred){
            try {
                drawBox(40, "1. Sign Up");
                drawBox(40, "2. Login");
                drawBox(40, "3. Delete Account ");
                drawBox(40, "4. Visit zoo");
                drawBox(40, "5. Exit ");
                answer = sc.nextInt();
                sc.nextLine();
                errorOccurred = false;
            }catch (InputMismatchException e){
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }
        return answer;
    }

    public int zooOptions() {
        int answer = 0;
        boolean errorOccurred = true;

        while (errorOccurred){
            try {
                drawBox(40, "1. Visit Tiger");
                drawBox(40, "2. Visit Shark");
                drawBox(40, "3. Visit Frog ");
                drawBox(40, "4. Visit Bird ");
                drawBox(40, "5. Visit Crocodile");
                drawBox(40, "6. Exit ");
                answer = sc.nextInt();
                sc.nextLine();
                errorOccurred = false;
            }catch (InputMismatchException e){
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }
        return answer;
    }

    public void drawBox(int length, String singleWord){

        if (singleWord.length() > length){
            length = singleWord.length();
        }

        if (length % 2 != 0){
            length--;
        }

        System.out.print("\u2554");

        for (int i = 0; i < length; i++) {
            System.out.print("\u2550");
        }

        System.out.print("\u2557\n");
        System.out.print("\u2551");

        for (int j = 0; j < (length - singleWord.length()) / 2; j++) {
            System.out.print(" ");
        }

        System.out.print("" + singleWord);

        for (int j = 0; j < (length - singleWord.length()) / 2; j++) {
            System.out.print(" ");
        }

        System.out.print("\u2551\n");
        System.out.print("\u255A");

        for (int i = 0; i < length; i++) {
            System.out.print("\u2550");
        }
        System.out.print("\u255D\n");
    }

}
