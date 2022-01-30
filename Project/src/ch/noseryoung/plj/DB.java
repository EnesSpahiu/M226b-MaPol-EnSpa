package ch.noseryoung.plj;

import java.util.ArrayList;

public interface DB {
    void testConnection();
    ArrayList<?> getData();
    void insertData();
    void deleteData();
    boolean loginUser();
    void updateTable();
}
