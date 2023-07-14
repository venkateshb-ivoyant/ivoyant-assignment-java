import java.sql.*;

public class Employee {
    Connection con;
    PreparedStatement pst;
    ResultSet rst;

    public void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/companydb", "root", "root");
            System.out.println("Successs");
        } catch (Exception ex) {
            ex.getMessage();

        }
    }

    public void insert(int employeeID, String empName, int empSalary, int mobile) throws Exception {
        pst = con.prepareStatement(SqlQueries.insertQuery);
        pst.setInt(1, employeeID);
        pst.setString(2, empName);
        pst.setInt(3, empSalary);
        pst.setInt(4, mobile);
        pst.executeUpdate();
    }

    public void update(int empid, String empname, int salary, int mobile) throws Exception {
        pst = con.prepareStatement(SqlQueries.updateQuery);
        pst.setString(1, empname);
        pst.setInt(2, salary);
        pst.setInt(3, mobile);
        pst.setInt(4, empid);
        pst.executeUpdate();
    }

    public void delete(int empid) throws Exception {
        pst = con.prepareStatement(SqlQueries.retrieveQuery);
        pst.setInt(1, empid);
        rst = pst.executeQuery();
        if (rst.next()) {
            pst = con.prepareStatement(SqlQueries.deleteQuery);
            pst.setInt(1, empid);
            pst.executeUpdate();
            System.out.println("Deleted Successfully...");
        } else {
            System.out.println("Record not Found...");
        }
    }

    public void display() throws Exception {
        pst = con.prepareStatement(SqlQueries.displayQuery);
        rst = pst.executeQuery();
        while (rst.next()) {
            System.out.printf("%-15s  %20s %5s   %5s\n", rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getInt(4));
        }

    }

    public void searchById(int empId) throws Exception {
        pst = con.prepareStatement(SqlQueries.searchQueryById);
        pst.setInt(1, empId);
        rst = pst.executeQuery();
        if (rst.next()) {
            System.out.printf("%-15s  %20s  %5s  %5s", rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getInt(4));
        } else {
            System.out.println("Record Not Found");
        }

    }

    public void searchBySalary(int salary) throws Exception {
        boolean found = false;
        pst = con.prepareStatement(SqlQueries.searchQueryBySalary);
        pst.setInt(1, salary);
        rst = pst.executeQuery();
        while (rst.next()) {
            System.out.printf("%-15s  %20s  %5s  %5s \n", rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getInt(4));
            found = true;
        }
        if (!found) {
            System.out.println("Record Not Found");
        }
    }

    public void checkConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/companydb", "root", "root");
            System.out.println("Successs");
        } catch (Exception ex) {
            System.out.println("the following error is occurred" + ex.getMessage());
        }
    }

    public void close() throws Exception {
        con.close();
        System.out.println("Connection Closed");
    }

}
