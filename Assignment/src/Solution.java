import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter the size of Customers");
        int size = scanner.nextInt();
        Customer_Information[] customerInfo = new Customer_Information[size];

        for (int i = 0; i < size; i++) {
            int customerId = scanner.nextInt();
            scanner.nextLine();
            String customerName = scanner.nextLine();

            double billAmount = scanner.nextDouble();
            int noOfTerms = scanner.nextInt();
            scanner.nextLine();
            String branchName = scanner.nextLine();
            customerInfo[i] = new Customer_Information(customerId, customerName, billAmount, noOfTerms, branchName);
        }
        System.out.print("Enter Branch Name: ");
        String branchName = scanner.nextLine();

        System.out.print("Enter Bill Amount: ");
        double billAmount = scanner.nextDouble();

        System.out.print("Enter Starting letter of name: ");
        String startingLetterOfName = scanner.next();

        double avgBillAmount = findAvgBillByBranch(customerInfo, branchName);
        if (avgBillAmount > 0) {
            System.out.println(avgBillAmount);
        } else {
            System.out.println("There are no customer purchases in that particular branch");
        }

        Customer_Information discountedCustomer = discountByBillAmount(customerInfo, billAmount, startingLetterOfName);
        double totalDiscountedAmount =0;
        if (discountedCustomer != null) {
            totalDiscountedAmount = billAmount- discountedCustomer.getBillAmount();
            System.out.println(discountedCustomer.getCustomer_Name() + ":" + discountedCustomer.getBillAmount());
            System.out.println("the total Bill Amount discounted for "+discountedCustomer.getCustomer_Name()+":"+totalDiscountedAmount);
        } else {
            System.out.println("NO");
        }


    }

    private static double findAvgBillByBranch(Customer_Information[] CustomerInfo,String branch_Name ) {

        int count = 0;
        double totalBillAmount = 0;

        for (Customer_Information customer : CustomerInfo) {
            if (customer.getBranch_Name().equalsIgnoreCase(branch_Name)) {
                totalBillAmount += customer.getBillAmount();
                count++;
            }
        }

        if (count > 0) {
            return totalBillAmount / count;
        } else {
            return 0;
        }
    }
    private static Customer_Information discountByBillAmount(Customer_Information[] customerInfo, double billAmount, String startingLetterOfName){

        for (Customer_Information customer : customerInfo) {
            if (customer.getCustomer_Name().startsWith(startingLetterOfName)) {
                if (customer.getBillAmount() >= billAmount) {
                    double discountedAmount = customer.getBillAmount() * 0.8;
                    customer.setBillAmount(discountedAmount);
                } else {
                    double discountedAmount = customer.getBillAmount() * 0.9;
                    customer.setBillAmount(discountedAmount);
                }
                return customer;
            }
        }

        return null;
    }
}
