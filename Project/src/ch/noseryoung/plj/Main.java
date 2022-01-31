package ch.noseryoung.plj;

import ch.noseryoung.plj.visitor.DB_Visitor;

/**
 * The class Main calls all functions to start the program. First it tests the database connection,
 * then it starts the program with the function initProject().
 */
public class Main {

    public static void main(String[] args) {

        ZooManager mgr = new ZooManager();
        DB_Visitor db = new DB_Visitor();

        db.testConnection();

        mgr.initProject();

    }
}
