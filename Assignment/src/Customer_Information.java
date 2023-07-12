public class Customer_Information {
   private  int customer_Id;
  private   String customer_Name;
   private double billAmount;
   private int no_Of_Items;
   private String branch_Name;
   //setters and getters
   //setters
   public void setCustomer_Id(int cid){
       this.customer_Id=cid;

   }
   public void setCustomer_Name( String cName){
       this.customer_Name = cName;
    }
    public void setBillAmount(double billamt){
       this.billAmount=billamt;
    }
    public void setNo_Of_Items(int totalitems){
        this.no_Of_Items=totalitems;
    }
    public void setBranch_Name(String branchName){
       this.branch_Name=branchName;
    }
    // getters
    public int getCustomer_Id(){
       return customer_Id;

    }
   public String getCustomer_Name(){
       return customer_Name;
    }
    public double getBillAmount(){
       return billAmount;
    }
    public int getNo_Of_Items(){
       return no_Of_Items;
    }
    public String getBranch_Name(){
       return branch_Name;
    }
    Customer_Information(int cust_id, String cust_name,double bill_amt,int noOfitems,String branchName){
       this.setCustomer_Id(cust_id);
       this.setCustomer_Name(cust_name);
       this.setBillAmount(bill_amt);
       this.setNo_Of_Items(noOfitems);
       this.setBranch_Name(branchName);
    }


}
