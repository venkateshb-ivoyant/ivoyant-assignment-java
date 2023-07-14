import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter the size of Customers");
        int size = scanner.nextInt();
        CustomerInformation[] customerInfo = new CustomerInformation[size];
        for (int i = 0; i < size; i++) {
            int customerId = scanner.nextInt();
            scanner.nextLine();
            String customerName = scanner.nextLine();
            double billAmount = scanner.nextDouble();
            int noOfTerms = scanner.nextInt();
            scanner.nextLine();
            String branchName = scanner.nextLine();
            customerInfo[i] = new CustomerInformation(customerId, customerName, billAmount, noOfTerms, branchName);
        }
        System.out.print("Enter Branch Name: ");
        String branchName = scanner.nextLine();
        System.out.print("Enter todays threshold  Bill Amount: ");
        double thresholdBillAmount = scanner.nextDouble();
        System.out.print("Enter Starting letter of name: ");
        String startingLetterOfName = scanner.next();
        System.out.print("Enter  name of the week: ");
        String nameOfTheWeek = scanner.next();
        double avgBillAmount = findAvgBillByBranch(customerInfo, branchName);
        if (avgBillAmount > 0) {
            System.out.println(avgBillAmount);
        } else {
            System.out.println("There are no customer purchases in that particular branch");
        }
        CustomerInformation discountedCustomer = discountByBillAmount(customerInfo, thresholdBillAmount, startingLetterOfName, nameOfTheWeek);
        if (discountedCustomer != null) {
            System.out.println(discountedCustomer.getCustomerName() + ":" + discountedCustomer.getBillAmount());
        } else {
            System.out.println("NO");
        }
    }

    private static double findAvgBillByBranch(CustomerInformation[] CustomerInfo, String branch_Name) {
        int count = 0;
        double totalBillAmount = 0;
        for (CustomerInformation customer : CustomerInfo) {
            if (customer.getBranchName().equalsIgnoreCase(branch_Name)) {
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

    private static CustomerInformation discountByBillAmount(CustomerInformation[] customerInfo, double thresholdBillAmount, String startingLetterOfName, String nameOfTheWeek) {
        double totalDiscounted = 0;
        double billAmt = 0;
        double discountedAmount = 0;
        double amtDiscounted = 0;

        for (CustomerInformation customer : customerInfo) {
            if (customer.getCustomerName().matches(nameOfTheWeek)) {
                System.out.println("Congrats...! " + customer.getCustomerName() + " is eligible for Special Discount");
                billAmt = customer.getBillAmount();
                discountedAmount = specialDiscount(customer.getBillAmount());
                amtDiscounted = billAmt - discountedAmount;
                totalDiscounted += amtDiscounted;
                customer.setBillAmount(discountedAmount);
                System.out.println("total amt discounted for taday is:" + totalDiscounted);
                return customer;
            } else {
                if (customer.getCustomerName().startsWith(startingLetterOfName)) {
                    if (customer.getBillAmount() >= thresholdBillAmount) {
                        billAmt = customer.getBillAmount();
                        discountedAmount = customer.getBillAmount() * 0.8;
                        customer.setBillAmount(discountedAmount);
                        amtDiscounted = billAmt - discountedAmount;
                        totalDiscounted += amtDiscounted;
                        System.out.println("total amt discounted for taday is:" + totalDiscounted);
                    } else {
                        billAmt = customer.getBillAmount();
                        discountedAmount = customer.getBillAmount() * 0.8;
                        customer.setBillAmount(discountedAmount);
                        amtDiscounted = billAmt - discountedAmount;
                        totalDiscounted += amtDiscounted;
                        System.out.println("total amt discounted for taday is:" + totalDiscounted);
                    }
                    return customer;
                }
            }
        }
        return null;
    }

    public static double specialDiscount(double billAmount) {
        return billAmount * 0.5;
    }
}
