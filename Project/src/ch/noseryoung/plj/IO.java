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
                drawBox(40, "1. Sign Up/Login Guest");
                drawBox(40, "2. Edit Supervisors");
                drawBox(40, "3. Edit Cherishes");
                drawBox(40, "4. Edit Animals");
                drawBox(40, "5. Leave");
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

    public int hasAccount() {
        int answer = 0;
        boolean errorOccured = true;

        while (errorOccured){
            try {
                drawBox(40, "1. Login");
                drawBox(40, "2. Sign Up");
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
                drawBox(40, "1. Add Supervisor");
                drawBox(40, "2. Edit Supervisor");
                drawBox(40, "3. Delete Supervisor");
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

    public int cherishVisorInput() {
        int answer = 0;
        boolean errorOccured = true;

        while (errorOccured){
            try {
                drawBox(40, "1. Add Cherish");
                drawBox(40, "2. Edit Cherish");
                drawBox(40, "3. Delete Cherish");
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
