package com.github.razeenbrey.cinesync;
import java.sql.*;

public class SqlDb
{   
    Connection conn;

    public boolean connectSql(String url, String username, String password)
    {

        try {
            conn = DriverManager.getConnection(url, username, password);
            return true;
        } catch (SQLException e) {
            return false;
        }
        
    }

    
}