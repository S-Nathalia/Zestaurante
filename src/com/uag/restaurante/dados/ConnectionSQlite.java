/*package com.uag.restaurante.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSQlite {


    public static Connection getConnection() throws SQLException{
            String url = "jdbc:sqlite:db/sqlite.db";
            System.out.println("CONECTOU!");
            return DriverManager.getConnection(url);
    }

   public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:db/sqlite.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:db/sqlite.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);


            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
*/
