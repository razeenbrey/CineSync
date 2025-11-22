package com.cinesync.desktop;

import java.sql.Connection;

import com.cinesync.desktop.repository.MySQLConnector;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Connection conn = MySQLConnector.getInstance("10.0.0.14", "3306", "episodesdb", "Master", "UCT81new!RAZ7861").getConnection();
        MySQLConnector.getInstance("10.0.0.14", "3306", "episodesdb", "Master", "UCT81new!RAZ7861").closeConnection();
    }
}
