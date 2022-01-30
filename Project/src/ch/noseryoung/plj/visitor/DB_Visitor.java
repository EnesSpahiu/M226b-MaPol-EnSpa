package ch.noseryoung.plj.visitor;

import ch.noseryoung.plj.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DB_Visitor implements DB {

    private Connection connection = null;
    private final String userName = "stduser";
    private final String password = "pwd";
    private final String URL = "jdbc:mariadb://localhost:3306/zoo";
    private final String driver = "org.mariadb.jdbc.Driver";
    Visitor visitor;
    Scanner sc = new Scanner(System.in);

    public DB_Visitor() {
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
    public ArrayList<Visitor> getData() {
        String output = "";
        ArrayList<Visitor> visitors = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL, userName, password);
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM visitor");
            while (rs.next()) {
                visitors.add(new Visitor((String) rs.getObject(2), ((String) rs.getObject(3)),
                        ((String) rs.getObject(4)), (int) rs.getObject(5)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return visitors;
    }

    @Override
    public void insertData() {

        boolean errorOccurred = true;
        int age = 0;
        int generatedKey = 0;

        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();

        while (errorOccurred) {
            try {
                System.out.println("Enter your age: ");
                age = sc.nextInt();
                sc.nextLine();
                errorOccurred = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }

        System.out.println("Enter your password: ");
        String pwd = sc.nextLine();

        try {
            connection = DriverManager.getConnection(URL, userName, password);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO visitor " + "VALUES ("+ generatedKey +", '" + firstName + "' , '" + lastName + "', '" + pwd + "', '" + age + "')",
                    Statement.RETURN_GENERATED_KEYS);

            ps.execute();

            System.out.println("Successfully Signed in");
            System.out.println("Welcome to our Zoo");

            visitor = new Visitor(firstName, lastName, pwd, age);

            visitor.setFirstName(firstName);
            visitor.setLastName(lastName);
            visitor.setPassword(pwd);
            visitor.setAge(age);

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

            String query = "DELETE FROM visitor WHERE firstname='" + firstName + "' AND lastname='" + lastName + "' AND password='" + pwd + "'";
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
        ArrayList<Visitor> users;

        users = getData();

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

                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getFirstName().equals(firstName) && users.get(i).getLastName().equals(lastName) && users.get(i).getPassword().equals(pwd)) {
                        isLoggedIn = true;
                        visitor = new Visitor(users.get(i).getFirstName(), users.get(i).getLastName(), users.get(i).getPassword(), users.get(i).getAge());

                        visitor.setFirstName(users.get(i).getFirstName());
                        visitor.setLastName(users.get(i).getLastName());
                        visitor.setAge(users.get(i).getAge());
                        visitor.setPassword(users.get(i).getPassword());

                        System.out.println(users.get(i).getAge());
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

            String query = "UPDATE visitor SET age=" + visitor.getAge() + " WHERE firstName='" + visitor.getFirstName() + "' AND lastName='" + visitor.getLastName() + "' AND password='" + visitor.getPassword() + "'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.execute();

        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}