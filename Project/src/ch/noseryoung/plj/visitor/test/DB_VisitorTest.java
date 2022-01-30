package ch.noseryoung.plj.visitor.test;

import ch.noseryoung.plj.ZooManager;
import ch.noseryoung.plj.visitor.DB_Visitor;
import ch.noseryoung.plj.visitor.Visitor;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DB_VisitorTest {

    DB_Visitor db_visitor;

    @BeforeEach
    void setUp() {
        db_visitor = new DB_Visitor();
        db_visitor.testConnection();
    }

    @org.junit.jupiter.api.Test
    void testConnection() {
        assertNotNull(db_visitor.getConnection());
    }

    @org.junit.jupiter.api.Test
    void getData() {
        ArrayList<Visitor> visitors;
        visitors = db_visitor.getData();
        assertNotNull(visitors);
    }

    @org.junit.jupiter.api.Test
    void insertData() {
        boolean isInDB = false;
        db_visitor.insertDataMock("TestUser", "TestUser", "TestPWD", 1);
        ArrayList<Visitor> visitors;
        visitors = db_visitor.getData();

        for (Visitor visitor : visitors){
            if (visitor.getFirstName().toLowerCase().equals("testuser") && visitor.getPassword().toLowerCase().equals("testpwd")){
                isInDB = true;
            }
        }

        assertTrue(isInDB);
    }

    @org.junit.jupiter.api.Test
    void deleteData() {
        boolean isInDB = false;
        db_visitor.deleteDataMock("TestUser", "TestUser", "TestPWD");
        ArrayList<Visitor> visitors;
        visitors = db_visitor.getData();

        for (Visitor visitor : visitors){
            if (visitor.getFirstName().toLowerCase().equals("testuser") && visitor.getPassword().toLowerCase().equals("testpwd")){
                isInDB = true;
            }
        }

        assertFalse(isInDB);
    }

    @org.junit.jupiter.api.Test
    void loginUser() {
        assertTrue(db_visitor.loginUserMock("Enes", "Spahiu", "SomePWD"));
    }
}