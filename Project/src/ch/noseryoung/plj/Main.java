package ch.noseryoung.plj;

import ch.noseryoung.plj.visitor.DB_Visitor;

public class Main {

    public static void main(String[] args) {

        ZooManager mgr = new ZooManager();
        DB_Visitor db = new DB_Visitor();

        db.testConnection();

        mgr.initProject();

    }
}
