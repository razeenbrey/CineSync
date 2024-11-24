package com.github.razeenbrey.cinesync;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 public class SqlDb implements Runnable
 {  
    public String url;
    public String user;
    private String passwd;
    
    public SqlDb(String url, String user, String passwd)
    {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
    
    public void run()
    {
        // load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }

        // create connection
        try (Connection conn = DriverManager.getConnection(url, user, passwd)){
            // statements to execute go here
            conn.close();

        } catch (SQLException e1) {
           e1.printStackTrace();
        }
    }
 }
