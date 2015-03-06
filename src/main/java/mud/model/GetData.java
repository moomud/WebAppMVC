/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mud.model;

import mud.controller.ConnectionToDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class GetData {
    
    ArrayList<String> id;
    ArrayList<String> fname;
    ArrayList<String> lname;
    ArrayList<String> email;
    ArrayList<String> phone;
    ArrayList<String> salary;
    
    public void RunData() throws ClassNotFoundException, SQLException{
        Connection conn = new ConnectionToDb().getConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM employees");
          
           id = new ArrayList<String>();
           fname  = new ArrayList<String>();
           lname = new ArrayList<String>();
           email = new ArrayList<String>();
           phone = new ArrayList<String>();
           salary = new ArrayList<String>();
           
        while(rs.next()){
            id.add(rs.getString("employee_id"));
            fname.add(rs.getString("first_name"));
            lname.add(rs.getString("last_name"));
            email.add(rs.getString("email"));
            phone.add(rs.getString("phone_number"));
            salary.add(rs.getString("salary"));
        }
    }

    public ArrayList<String> getId() {
        return id;
    }

    public void setId(ArrayList<String> id) {
        this.id = id;
    }

    public ArrayList<String> getFname() {
        return fname;
    }

    public void setFname(ArrayList<String> fname) {
        this.fname = fname;
    }

    public ArrayList<String> getLname() {
        return lname;
    }

    public void setLname(ArrayList<String> lname) {
        this.lname = lname;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }

    public ArrayList<String> getPhone() {
        return phone;
    }

    public void setPhone(ArrayList<String> phone) {
        this.phone = phone;
    }

    public ArrayList<String> getSalary() {
        return salary;
    }

    public void setSalary(ArrayList<String> salary) {
        this.salary = salary;
    }
    
    
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        GetData gd = new GetData();
        gd.RunData();
        
        for(int i = 0 ; i < gd.getId().size() ;i++){
            System.out.println(gd.getId().get(i)+" "+
                               gd.getFname().get(i)+" "+
                               gd.getLname().get(i)+" "+
                               gd.getEmail().get(i)+" "+
                               gd.getPhone().get(i)+" "+
                               gd.getSalary().get(i));
        }
    }
    
}
