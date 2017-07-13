
package vishu;


public class details {
    
    private int customerid;
      private String emailid;
    private String customername;
    private String phone;
   
    private byte[] image;
    
    public details(){}
    
   public details(int customerid , byte[] pimage,String pcustomername , String pphone, String pemailid)
    {
        this.customerid=customerid;
    this.emailid=pemailid;
    this.customername=pcustomername;
    this.phone = pphone;
   
    this.image = pimage;
    }
    
    
     public int getCusId()
    {
    return customerid;
    }
    
    public void setCusId(int ID){
        this.customerid = ID;
    }
    
    
    
    public String getCustomerName()
    {
    return customername;
    }
    
    public void setCustomerName(String Name){
        this.customername = Name;
    }
    
    public String getEmailId()
    {
    return emailid;
    }
    
    public void setEmailId(String Mail){
        this.emailid = Mail;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public void setPhone(String mobile){
        this.phone = mobile;
    }
    
  public byte[] getMyImage()
    {
    return image;
    }
   
}
