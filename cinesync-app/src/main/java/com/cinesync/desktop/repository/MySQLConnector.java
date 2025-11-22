package com.cinesync.desktop.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    private static MySQLConnector mySQLConnector = null;
    private Connection conn;

    private String driver = "jdbc:mysql://";
    
    // Create Connection Object
    private MySQLConnector(String host, String port, String dbName, String uName, String pWord){
        String connStr = driver + host +":"+ port +"/"+ dbName;
        try {
            conn = DriverManager.getConnection(connStr, uName, pWord);
            System.out.println("Connected.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Singleton getInstance
    public static MySQLConnector getInstance(String host, String port, String dbName, String uName, String pWord){
        if (mySQLConnector == null){
            mySQLConnector = new MySQLConnector(host, port, dbName, uName, pWord);
        }
        return mySQLConnector;
    }

    // get jdbc connection object
    public Connection getConnection(){
        return conn;
    }

    // close connection
    public void closeConnection(){
        try {
            if (conn != null && !conn.isClosed()){
                conn.close();
                System.out.println("Connection Closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
