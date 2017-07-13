/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vishu;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author vishu tyagi
 */
public class Panel1 extends javax.swing.JPanel {

    /**
     * Creates new form Panel1
     */
    public Panel1() {
        initComponents();
    }
  
    String ImgPath = null;
    
     public java.sql.Connection getConnection()
    {
    java.sql.Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/gym","root","");
           // JOptionPane.showMessageDialog(null,"connected");
            return con;
        } catch (SQLException ex) {
           
            return null;
        }
    }
     
     
       public ImageIcon ResizeImage(String imagePath, byte[] pic)
    {
        ImageIcon myImage  = null;
        
        if(imagePath != null)
        {
        myImage  = new ImageIcon(imagePath);
        } else {
        myImage = new ImageIcon(pic);
        }
        
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(ibl_image.getWidth(),ibl_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ibl_image = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        emailid = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("   Add New Admin");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 490, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 204, 80, -1));

        Name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 200, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 120, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Username :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 243, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Password :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 283, 112, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Email Id :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 323, 100, -1));

        ibl_image.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(ibl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 240, 190));

        Username.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 200, -1));

        emailid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add(emailid, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 290, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Clean");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 120, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Choose image");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, 180, -1));

        password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 200, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
              try {
                  
             String name= Username.getText();
            String username= Username.getText();
            String password1 = password.getText();
            String email= emailid.getText();
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO adminregistration(name,username,password,emailid,image) " + " value(?,?,?,?,?)");
                ps.setString(1,name);
                ps.setString(2,username);
                ps.setString(3,password1);
                ps.setString(4,email);
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(5,img);
                ps.executeUpdate();
               
                JOptionPane.showMessageDialog(null,"ADMIN DATA SAVED ");
                Name.setText(null);
                  Username.setText(null);
        password.setText(null);
        emailid.setText(null);
        ibl_image.setIcon(null);
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null,ex.getMessage());
            }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
           JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image","jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION)
        {
        File selectedFile = file.getSelectedFile();
        String path  = selectedFile.getAbsolutePath();
        ibl_image.setIcon(ResizeImage(path,null));
        ImgPath = path;
        }
        else
        {
      //  System.out.println(" NO FILE Selected");
         JOptionPane.showMessageDialog(null," NO FILE Selected");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Name.setText(null);
        Username.setText(null);
        password.setText(null);
        emailid.setText(null);
        ibl_image.setIcon(null);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Username;
    private javax.swing.JTextField emailid;
    private javax.swing.JLabel ibl_image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
