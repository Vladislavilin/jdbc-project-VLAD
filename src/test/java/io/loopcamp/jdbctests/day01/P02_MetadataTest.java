package io.loopcamp.jdbctests.day01;

import java.sql.*;
import java.util.*;

public class P02_MetadataTest {
    public static void main(String[] args) throws SQLException {


        String dbURL = "jdbc:oracle:thin:@52.91.199.232:1521:XE";
        String dbUserName = "hr";
        String dbPassword = "hr";

        // DriverManger class has getConnection() method which is used to create connection
        Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

        // Create Statement object from Connection to execute Query
        Statement stmtn = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // Using this stmnt object to execute the query
        ResultSet rs = stmtn.executeQuery("SELECT * FROM EMPLOYEES");


        /**
         * Database Meta Data
         */
        DatabaseMetaData dbMetaData = conn.getMetaData();
        System.out.println(dbMetaData.getUserName());
        System.out.println(dbMetaData.getDatabaseProductName());
        System.out.println(dbMetaData.getDatabaseProductVersion());


        /**
         * ResultSet Meta Data
         */
        //getMetaData() will return ResultSetMetaData object
        ResultSetMetaData rsmd = rs.getMetaData();


        // How many columns we have
        System.out.println("Total column in EMPLOYEES table " + rsmd.getColumnCount());


        // 1st Column Name
        System.out.println("First Column Name: " + rsmd.getColumnName(1)); // Indexes starts from 1 in SQL


        // The following method will return the size of the Characters that can be put
        System.out.println("Size of Character for " + rsmd.getColumnName(2) + " is " + rsmd.getColumnDisplaySize(2));


        // Print all column names
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.println("#" + i + ": Column Name: " + rsmd.getColumnName(i));
        }


        System.out.println("-------------------------------------");
        // SINCE we now how we can jump through rows and jump through columns, can we print all data dynamically


//        List<Map> list  =new ArrayList<>();

        List<Map<String,Object>> list  =new ArrayList<>();



        while (rs.next()) {
            Map<String, Object> map = new LinkedHashMap<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                    map.put(rsmd.getColumnName(i), rs.getString(i));
                }
            list.add(map);
//            System.out.println(list);

            }
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");


//        System.out.println(map);

        for (Map each :list) {
            System.out.println(each);

        }

        int mapp = 100;
        List<Integer> list2 = new ArrayList<>();
        list2.add(mapp);
        mapp = 101;
        list2.add(mapp);
        System.out.println(list2);

    }
}