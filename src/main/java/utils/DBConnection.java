package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=BookstoreDB";
private static final String USER = "";
private static final String PASSWORD = "";

/**
 * Establishes and returns a connection to the database.
 * 
 * @return Connection object
 * @throws SQLException if a database access error occurs 
 */
public static Connection getConnection() throws SQLException{
	return DriverManager.getConnection(URL + ";integratedSecurity=true");
}

}
