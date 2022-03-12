
/**
 * ControlAccesosSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class serviceClass{
    static String login= "root";
    static String password = "8AIAGUzOgTrzHZDxQg1P";
    public static boolean soapKeyChecker(String soapKey)
    {
        int no_of_rows=0;
        try {
            Connection con = DriverManager.getConnection (
                    "jdbc:mysql://localhost:3306/mtis", login, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery ("SELECT * FROM soapkey WHERE soap_key=" + soapKey + ";");
            while (rs.next()) {
                no_of_rows++;
            }
        } catch(SQLException e){
            System.out.println("SQL exception occured" + e);

        }
        if (no_of_rows>=1)
        {
            return true;
        }
        return false;
    }

    public static boolean restKeyChecker(String restKey)
    {
        int no_of_rows=0;
        try {
            Connection con = DriverManager.getConnection (
                    "jdbc:mysql://localhost:3306/mtis", login, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery ("SELECT * FROM restkey WHERE rest_key=" + restKey + ";");
            while (rs.next()) {
                no_of_rows++;
            }
        } catch(SQLException e){
            System.out.println("SQL exception occured" + e);

        }
        if (no_of_rows>=1)
        {
            return true;
        }
        return false;
    }
}