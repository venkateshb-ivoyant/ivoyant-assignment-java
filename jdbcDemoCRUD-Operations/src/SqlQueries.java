public class SqlQueries {
    public static final String insertQuery = "INSERT INTO EMPLOYEE(employeeID,empName,empSalary,mobile) VALUES (?,?,?,?)";
    public static final String displayQuery = "SELECT * FROM EMPLOYEE";
    public static final String searchQueryById = "SELECT * FROM EMPLOYEE WHERE employeeID = ?";
    public static final String searchQueryBySalary = "SELECT * FROM EMPLOYEE WHERE empSalary >= ?";
    public static final String updateQuery = "UPDATE  EMPLOYEE SET empName = ?,empSalary = ?,mobile =? WHERE employeeID = ?";
    public static final String deleteQuery = "DELETE FROM EMPLOYEE  WHERE employeeID = ?";
    public static final String retrieveQuery = "SELECT * FROM EMPLOYEE WHERE employeeID =?";

}
