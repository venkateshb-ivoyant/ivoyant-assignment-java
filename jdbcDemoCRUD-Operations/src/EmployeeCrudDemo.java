import java.util.Scanner;

public class EmployeeCrudDemo {
    public static void main(String[] args) throws Exception {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        Employee con = new Employee();
        con.getConnection();
        do {
            System.out.println("\n 1. INSERT");
            System.out.println("2. DISPLAY ALL");
            System.out.println("3. SEARCH BY ID");
            System.out.println("4. SEARCH BY SALARY");
            System.out.println("5. UPDATE");
            System.out.println("6. DELETE");
            System.out.println("7. CHECK CONNECTION IS SUCCESS OR NOT ");
            System.out.println("0. EXIT");
            System.out.println("Enter your Choice :");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    con.close();
                    break;

                case 1:
                    System.out.println("Enter how many employee do you want to insert toEmployee Table:");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter the Employee ID:");
                        int employeeID = scanner.nextInt();
                        System.out.println("Enter the Employee Name:");
                        String empName = scanner.next();
                        System.out.println("Enter the Employee Salary:");
                        int empSalary = scanner.nextInt();
                        System.out.println("Enter the Employee Mobile Number:");
                        int mobile = scanner.nextInt();
                        con.insert(employeeID, empName, empSalary, mobile);
                    }
                    break;
                case 2:
                    con.display();
                    break;
                case 3:
                    System.out.println("Enter the Employee ID to search:");
                    int employeeID = scanner.nextInt();
                    con.searchById(employeeID);
                    break;
                case 4:
                    System.out.println("Enter the Employee Salary to search:");
                    int salary = scanner.nextInt();
                    con.searchBySalary(salary);
                    break;
                case 5:
                    System.out.println("Enter the Employee ID to update:");
                    employeeID = scanner.nextInt();
                    System.out.println("Enter the Employee  New Name:");
                    String empName = scanner.next();
                    System.out.println("Enter the Employee New  Salary:");
                    int empSalary = scanner.nextInt();
                    System.out.println("Enter the Employee  New Mobile Number:");
                    int mobile = scanner.nextInt();
                    con.update(employeeID, empName, empSalary, mobile);
                    break;
                case 6:
                    System.out.println("Enter the Employee ID to Delete:");
                    employeeID = scanner.nextInt();
                    con.delete(employeeID);
                    break;
                case 7:
                    con.checkConnection();
                    break;
                default:
                    System.out.println("please Enter Correct choice");
            }
        } while (choice != 0);
    }

}
