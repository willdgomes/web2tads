/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gomes
 */
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException{
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost/banco_web2", "root", "root");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
