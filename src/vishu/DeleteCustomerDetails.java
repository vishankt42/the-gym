/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vishu;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.misc.resources.Messages;

/**
 *
 * @author vishu tyagi
 */
public class DeleteCustomerDetails extends javax.swing.JPanel {

    /**
     * Creates new form DeleteCustomerDetails
     */
      byte[] img;
    public DeleteCustomerDetails() {
        initComponents();
      // Show_Products_In_JTable();
      setTableOnly();
      
    }

    
    
       public java.sql.Connection getConnection()
    {
    java.sql.Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/gym","root","");
             //JOptionPane.showMessageDialog(null,"connected");
            return con;
        } catch (SQLException ex) {
           
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
          Object[] row = new Object[5];
         
                row[0] = rs.getInt("customerid");
              
                      img= rs.getBytes("image");   
                      
                     ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(100,100,Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
    
                row[1] = new JLabel(newImage);
                row[2] = rs.getString("customername");
                // System.out.println(row[2]);
               row[3] = rs.getString("phone");
                row[4] = rs.getString("emailid");
                model.addRow(row);    
   
  
    
    }  }catch (SQLException ex) {
             
              System.out.println(ex);
           }
    
    
    }      
  
    
  
   
    
    
     
     
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Delete Customer ");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Custome ID", "Image", "Name", "phone NO", "Email ID"
            }
        ));
        table.setRowHeight(150);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setHeaderValue("Custome ID");
            table.getColumnModel().getColumn(1).setHeaderValue("Image");
            table.getColumnModel().getColumn(2).setHeaderValue("Name");
            table.getColumnModel().getColumn(3).setHeaderValue("phone NO");
            table.getColumnModel().getColumn(4).setHeaderValue("Email ID");
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Delete Customer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(358, 358, 358))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
         int column = 0;
         int row =  table.getSelectedRow();
        int value =  (int) table.getModel().getValueAt(row, column);
       System.out.println(value);
        
       
        try { 
             Connection con = getConnection();
              PreparedStatement ps = con.prepareStatement("DELETE FROM addcustomer WHERE customerid = ?");
             
              ps.setInt(1,value);
              ps.executeUpdate();
             setTableOnly();
              JOptionPane.showMessageDialog(null,"Customer Deleted");
          } catch (SQLException ex) {
           
              System.out.println(ex);
          }
         
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
