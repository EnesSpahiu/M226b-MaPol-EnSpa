package ch.noseryoung.plj.supervisor;

import ch.noseryoung.plj.DB;
import ch.noseryoung.plj.animal.animals.*;
import ch.noseryoung.plj.cherish.Cherish;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DB_Supervisor implements DB {

    private Connection connection = null;
    private final String userName = "stduser";
    private final String password = "pwd";
    private final String URL = "jdbc:mariadb://localhost:3306/zoo";
    private final String driver = "org.mariadb.jdbc.Driver";
    Supervisor supervisor;
    Scanner sc = new Scanner(System.in);

    public DB_Supervisor() {
    }

    @Override
    public void testConnection() {
        try {
            connection = DriverManager.getConnection(URL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Supervisor> getData() {
        String output = "";
        ArrayList<Supervisor> supervisors = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL, userName, password);
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM supervisor");
            while (rs.next()) {
                supervisors.add(new Supervisor((String) rs.getObject(2), (String) rs.getObject(3),
                        (String) rs.getObject(4), (String) rs.getObject(5)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return supervisors;
    }

    @Override
    public void insertData() {

        boolean errorOccurred = true;
        int generatedKey = 0;

        System.out.println("Enter the first name: ");
        String firstName = sc.nextLine();

        System.out.println("Enter the last name: ");
        String lastName = sc.nextLine();

        System.out.println("Enter the password: ");
        String pwd = sc.nextLine();

        System.out.println("Enter the cherishname: ");
        String cherishname = sc.nextLine();

        try {
            connection = DriverManager.getConnection(URL, userName, password);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO supervisor " + "VALUES ("+ generatedKey +", '" + firstName + "' , '" + lastName + "', '" + pwd + "', '" + cherishname + "')",
                    Statement.RETURN_GENERATED_KEYS);

            ps.execute();

            System.out.println("Successfully added supervisor");

            supervisor = new Supervisor(firstName, lastName, pwd, cherishname);

            supervisor.setFirstName(firstName);
            supervisor.setLastName(lastName);
            supervisor.setPassword(pwd);
            switch (cherishname.toLowerCase()){
                case "tigercherish" -> supervisor.setCherishOfSuperVisor(new Cherish("Tigercherish", new Tiger("SomeTiger", 3)));
                case "sharkcherish" -> supervisor.setCherishOfSuperVisor(new Cherish("Sharkcherish", new Shark("SomeShark", 12)));
                case "frogcherish" -> supervisor.setCherishOfSuperVisor(new Cherish("Frogcherish", new Frog("SomeFrog", 5)));
                case "crocodilecherish" -> supervisor.setCherishOfSuperVisor(new Cherish("Crocodilecherish", new Crocodile("SomeCrocodile", 2)));
                case "birdcherish" -> supervisor.setCherishOfSuperVisor(new Cherish("BirdCherish", new Bird("SomeBird", 8)));
            }

        } catch (SQLException e){
            System.out.println("Something went wrong");
        }

        updateTable();

    }

    @Override
    public void deleteData() {
        try {
            System.out.println("Type in first name of Account: (Look out for Capital letters)");
            String firstName = sc.nextLine();

            System.out.println("Type in last name of Account: (Look out for Capital letters)");
            String lastName = sc.nextLine();

            System.out.println("Type in password of Account: (Look out for Capital letters)");
            String pwd = sc.nextLine();

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(URL, userName, password);

            String query = "DELETE FROM supervisor WHERE firstname='" + firstName + "' AND lastname='" + lastName + "' AND password='" + pwd + "'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.execute();

            System.out.println("User deleted");

        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }

    @Override
    public boolean loginUser() {
        boolean isLoggedIn = false;
        String firstName = " ";
        String lastName = " ";
        String pwd = " ";
        ArrayList<Supervisor> supervisors;

        supervisors = getData();

        try{
            connection = DriverManager.getConnection(URL, userName, password);
            while (!isLoggedIn) {
                System.out.println("Type in first name of Account or (s) to stop: (Look out for Capital letters)");
                firstName = sc.nextLine();

                if (firstName.toLowerCase().equals("s")){
                    break;
                }

                System.out.println("Type in last name of Account or (s) to stop: (Look out for Capital letters)");
                lastName = sc.nextLine();

                if (lastName.toLowerCase().equals("s")){
                    break;
                }

                System.out.println("Type in password of Account or (s) to stop: (Look out for Capital letters)");
                pwd = sc.nextLine();

                if (pwd.toLowerCase().equals("s")){
                    break;
                }

                for (int i = 0; i < supervisors.size(); i++) {
                    if (supervisors.get(i).getFirstName().equals(firstName) && supervisors.get(i).getLastName().equals(lastName) && supervisors.get(i).getPassword().equals(pwd)) {
                        isLoggedIn = true;
                        supervisor = new Supervisor(supervisors.get(i).getFirstName(), supervisors.get(i).getLastName(), supervisors.get(i).getPassword());

                        supervisor.setFirstName(supervisors.get(i).getFirstName());
                        supervisor.setLastName(supervisors.get(i).getLastName());
                        supervisor.setPassword(supervisors.get(i).getPassword());

                        break;
                    } else {
                        isLoggedIn = false;
                    }
                }
                if (isLoggedIn){
                    System.out.println("Successfully logged in");
                }else {
                    System.out.println("There is no such user, try again");
                }
            }
        }catch (Exception e){
            System.out.println("Something went wrong");
        }
        return isLoggedIn;
    }

    @Override
    public void updateTable(){
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(URL, userName, password);

            String query = "UPDATE supervisor SET cherishname=" + supervisor.getCherishOfSuperVisor().getName() + " WHERE firstName='" + supervisor.getFirstName() + "' AND lastName='" + supervisor.getLastName() + "' AND password='" + supervisor.getPassword() + "'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.execute();

        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}