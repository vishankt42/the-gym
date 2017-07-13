/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vishu;

import java.sql.Date;

/**
 *
 * @author vishu tyagi
 */
public class details1 {
    
     private int id;
     private byte[] picture;
    private String name;
    private String joiningdate;
     private String phone;
    private String emailid;
    private String gender;
    private String pack;
    private String amount;
    private String address;
  
    
    public details1(int pid, byte[] pimg, String pname,String pphone, String pjoiningdate ,String pemailid , String paddress, String pgender ,
            String ppack , String pamount )
    {
    this.id=pid;
    this.picture = pimg;
    this.name=pname;
   this.joiningdate = pjoiningdate;
    this.phone = pphone;
    this.emailid = pemailid;
    this.gender = pgender;
    this.pack = ppack;
    this.amount = pamount;
    this.address = paddress;
    
    }
    
    public int getId()
    {
    return id;
    }
    
     public byte[] getImage()
    {
    return picture;
    }
    
    public String getName()
    {
    return name;
    }
    
     public String getJoiningdate()
    {
    return joiningdate;
    }
     
      public String getPhone()
    {
    return phone;
    }
      
       public String getEmailid()
    {
    return emailid;
    }
       
        public String getGender()
    {
    return gender;
    }
        
         public String getPack()
    {
    return pack;
    }
    
  
    public String getAmount()
    {
    return amount;
    }
    
  public String getAddress()
  {
    return address;
   }
}
