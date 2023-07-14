public class CustomerInformation {
   private  int customerId;
  private   String customerName;
   private double billAmount;

   private int noOfItems;
   private String branchName;
   //setters and getters
   //setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }





    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public CustomerInformation(int customerId, String customerName, double billAmount, double totalDiscountedAmount, String branchName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.billAmount = billAmount;
        this.noOfItems = noOfItems;
        this.branchName = branchName;
    }
}
