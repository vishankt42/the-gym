/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vishu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author vishu tyagi
 */
public class MyQuery {
    
     public Connection getConnection()
    {
    Connection con = null;
    
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/gym","root","");
            
            return con;
        } catch (SQLException ex) {
            //Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
           
            return null;
        }
    
    }
     
     
        public ArrayList<details> BindTable(){
        
   ArrayList<details> list = new ArrayList<details>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   
   try {
   st = con.createStatement();
   rs = st.executeQuery(" SELECT * FROM addcustomer");
   
   details p;
   while(rs.next()){
   p = new details(rs.getInt("customerid"),rs.getBytes("image"),rs.getString("customername"),rs.getString("phone"),rs.getString("emailid"));
   //String name= rs.getString("customername");
   //System.out.println(name);
   list.add(p);
   }
   
   } catch (SQLException ex) {
  // Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
  JOptionPane.showMessageDialog(null,ex.getMessage());
   }
   return list;
   }
}
