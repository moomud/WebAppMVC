/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mud.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Muhammad
 */
public class InsertData {
    public void Insert(String id, String firstname, String lastname, 
            String email, String phone, double salary) throws ClassNotFoundException, SQLException{
        
        
        Connection conn = new ConnectionToDb().getConnection();
       
         
         try {
              
             String idemp = id+"";
             String sql = "INSERT INTO employees "
                          +"(employee_id,first_name,last_name, email ,phone_number,salary,job_id,hire_date)" 
                          + "values (?,?,?,?,?,?,?,SYSDATE)";
             
             PreparedStatement pre = conn.prepareStatement(sql);
             pre.setString(1, idemp);
             pre.setString(2, firstname);
             pre.setString(3, lastname);
             pre.setString(4, email);
             pre.setString(5, phone);
             pre.setDouble(6, salary);
             pre.setString(7, "IT_PROG");
           
             if(pre.executeUpdate() != -1){
                 System.out.println("Success");
             }
             
          
        } catch (SQLException ex) {
             ex.printStackTrace();
         }finally{
             if(conn != null){
                 try {
                     conn.close();
                 } catch (SQLException ex) {
                    
                 }
             }
         }
        
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        InsertData ins = new InsertData();
        ins.Insert("0002", "mud", "mud", "mud@gmail", "0829682427", 34567);
    }
    
  
    
}