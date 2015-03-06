/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Best
 */
public class ConnectionToDb {
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        String user = "hr";
        String password = "hr";
        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        Class.forName(driver);
       
        return DriverManager.getConnection(url,user,password);
    }
    
 }
