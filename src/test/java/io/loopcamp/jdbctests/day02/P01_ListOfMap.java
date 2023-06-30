package io.loopcamp.jdbctests.day02;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P01_ListOfMap {

    String dbURL = "jdbc:oracle:thin:@52.91.199.232:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test

    public void task1 () throws SQLException {
        // DriverManger class has getConnection() method which is used to create connection
        Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

        // Create Statement object from Connection to execute Query
        Statement stmtn = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // Using this stmnt object to execute the query
        ResultSet rs = stmtn.executeQuery("SELECT * FROM EMPLOYEES");

        Map< String, Object> row1Map = new HashMap<>();
        row1Map.put ("FIRST_NAME", "Steven");                 // KEY=FIRST_NAME         VALUE=Steven
        row1Map.put ("LAST_NAME", "King");                     // KEY=FLAST_NAME         VALUE=King
        row1Map.put ("SALARY", 20000);
        System.out.println(row1Map);// KEY=SLARY         VALUE=24,000



        Map < String, Object> row2Map = new HashMap<>();
        row2Map.put ("FIRST_NAME", "Neena");                 // KEY=FIRST_NAME         VALUE= Neena
        row2Map.put ("LAST_NAME", "Kochhar");                 // KEY=FLAST_NAME         VALUE= Kochhar
        row2Map.put ("SALARY", 17000);
        System.out.println(row1Map);// KEY=SLARY         VALUE= 17,000


        // After getting each row into a MAP, now we can store EACH MAP into a List


        List<Map <String, Object>> dataList = new ArrayList<>();
        dataList.add(row1Map);
        dataList.add(row2Map);
        System.out.println(dataList);
        System.out.println(dataList.get(0).get("LAST_NAME"));

    }

    @Test
    public void task2 () throws SQLException{
        // DriverManger class has getConnection() method which is used to create connection
        Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

        // Create Statement object from Connection to execute Query
        Statement stmtn = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // Using this stmnt object to execute the query
        ResultSet rs = stmtn.executeQuery("select FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES WHERE ROWNUM < 5");

    ResultSetMetaData rsmd = rs.getMetaData();

        Map< String, Object> row1Map = new HashMap<>();
        rs.next();
        row1Map.put (rsmd.getColumnName(1), rs.getString(1));                 // KEY=FIRST_NAME         VALUE=Steven
        row1Map.put (rsmd.getColumnName(2),rs.getString(2));                     // KEY=FLAST_NAME         VALUE=King
        row1Map.put (rsmd.getColumnName(3), rs.getInt(3));
        System.out.println(row1Map);// KEY=SLARY         VALUE=24,000

        List<Map<String, Object>> dataList = new ArrayList<>();
        dataList.add(row1Map);
        System.out.println(dataList);

        for (Map <String, Object> each:dataList) {
            System.out.println(each);
        }


        rs.close();







    }
}
