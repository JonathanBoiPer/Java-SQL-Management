package uf6.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexio {

    public static Connection openCon() {
        String url = "jdbc:sqlite:C:\\Users\\jonab\\Documents\\Programación\\Java-M03\\UF6\\Practica\\bdrodamons.db";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url);
            System.out.println("Connexió establerta");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static void closeCon(Connection con) {
        try {
            if (con != null) con.close();
            System.out.println("S'ha tancat la connexió");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void closeStmt(Statement stmt) {
        try {
            if (stmt != null) stmt.close();
            System.out.println("S'ha tancat la connexió");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
