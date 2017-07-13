/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vishu;

import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vishu tyagi
 */
public class DateReminder extends javax.swing.JPanel {

    /**
     * Creates new form DateReminder
     */
    byte[] img;
    String output;
    public DateReminder() {
       initComponents();
      setTableOnly();
    }

       public Connection getConnection()
    {
    Connection con = null;
    
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/gym","root","");
            
            return con;
        } catch (SQLException ex) {
          //  Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
           
            return null;
        }
    
    }
    
    
    
    
    
     public void setTableOnly()
    {
     Connection con = getConnection();
    String query = " SELECT * FROM addcustomer";
    
    Statement st;
    ResultSet rs;
     table.setDefaultRenderer(Object.class, new TableImage());
     DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);     
    try {
    st=con.createStatement();
    rs = st.executeQuery(query);
  
    
    while(rs.next())   
    {  
       String packag = rs.getString("package"); 
       int days = 0;
       if(packag.equals("One Month")) 
       {
       days=30;
       }
       
        if(packag.equals("Three Month")) 
       {
       days=90;
       }
        
          if(packag.equals("Six Month")) 
       {
       days=180;
       }
          
            if(packag.equals("One Year")) 
       {
       days=365;
       }
            
         if(packag.equals("With Trainer")) 
       {
       days=30;
       }
         
        if(packag.equals("1 Month")) 
       {
       days=30;
       }
            
        if(packag.equals("3 Month")) 
       {
       days=90;
       }
               
       if(packag.equals("6 Month")) 
       {
       days=180;
       }
                  
        if(packag.equals("1 Year")) 
       {
       days=365;
       }
          Object[] row = new Object[10];
            
                row[0] = rs.getInt("customerid");
              
                      img= rs.getBytes("image");   
                     
                     ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(100,100,Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    row[1] = new JLabel(newImage);
                   row[2] = rs.getString("customername");
                
                String date =  rs.getString("dateofjoining");
             
               DateFormat formatter;
              formatter = new SimpleDateFormat("dd-MM-yyyy");
             java.util.Date date_temp=null;
              try {
              date_temp =  formatter.parse(date);
               Calendar cal = Calendar.getInstance();
                cal.setTime(date_temp);
                cal.add(Calendar.DATE, days);
                output = formatter.format(cal.getTime());
               
               // System.out.println("added date" +output);
               // System.out.println("added date" +formatter.format(cal.getTime()));
                
              
             } catch (ParseException ex) {
 // Logger.getLogger(Attendance_Calculation.class.getName()).log(Level.SEVERE, null, ex);
                 System.out.println(ex);
}
//System.out.println("output: "+date_temp);
               if(output.equals(date))
               {
               date=output;
               }
               
       
              // row[3] = rs.getString("phone");
                row[3] = date;
               // SimpleDateFormat sdf =  new SimpleDateFormat();
                row[4] =output;
                // row[6] = rs.getString("address");       
               // row[7] = rs.getString("gender");
               // row[8] = rs.getString("package");
              //  row[9] = rs.getString("amount");
                
                model.addRow(row);    
   
   // p = new details1(rs.getInt("customerid"), img ,rs.getString("customername"),rs.getString("phone"),rs.getString("dateofjoining"),rs.getString("emailid") ,rs.getString("address"),rs.getString("gender"),rs.getString("package"),rs.getString("amount"));
   // productList.add(p);
    
    }  }catch (SQLException ex) {
              // Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println(ex);
           }
    
    
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("  Date Reminder");
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Image", "Name", "Start Month", "End Month"
            }
        ));
        table.setRowHeight(120);
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(326, 326, 326))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
