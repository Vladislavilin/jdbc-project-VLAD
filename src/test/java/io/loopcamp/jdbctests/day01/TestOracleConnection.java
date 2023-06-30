package io.loopcamp.jdbctests.day01;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestOracleConnection {
    public static void main(String[] args) throws SQLException {


        String dbURL = "jdbc:oracle:thin:@52.91.199.232:1521:XE";
        String dbUserName = "hr";
        String dbPassword = "hr";

        // DriverManger class has getConnection() method which is used to create connection
        Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);


        // Create Statement object from Connection to execute Query
        Statement stmtn = conn.createStatement();


        // Using this stmnt object to execute the query
        ResultSet rs = stmtn.executeQuery("SELECT * FROM EMPLOYEES");

        // We use next() method to iterate each row
        // While the next row is not NUL we can continue iterating

        rs.next();  // This will jump next row


        // getString(columnName) -- this method will return the value of the given ColumnName
        String firstRowFirstName = rs.getString("FIRST_NAME");
        System.out.println(firstRowFirstName);

        rs.next();
        System.out.println(rs.getString("FIRST_NAME"));

        //Instead of using column name we can also use index. Indexes starts from 1
        String lastName = rs.getString(3);
        System.out.println(lastName);  //


        int getNextSalary = rs.getInt(8);
        System.out.println(getNextSalary);


        // We can not get the String data type and assign it into int data type.
        // That is why we are getting exception with the code below
        //int getNextLastname = rs.getInt(2);
        //System.out.println(getNextSalary);


        // How can you loop through the first_name and print all names
        while (rs.next()) {
            System.out.println(rs.getString("FIRST_NAME"));
            System.out.println(rs.getString(2));
            System.out.println();
        }


    }
}



