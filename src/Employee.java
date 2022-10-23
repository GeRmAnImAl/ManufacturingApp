import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends User {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private String department;
    private int employeeID;
    private LocalDate hireDate;
    private String[] reasonList = {"Late", "Suspended", "Terminated", "On Leave", "Vacation"};

    // Constructor
    public Employee(String firstName, String lastName, int employeeID, LocalDate hireDate, String department, String email, String userName,
                    String password) {
        super(firstName, lastName, email, userName, password);
        this.employeeID = employeeID;
        this.hireDate = hireDate;
        this.department = department;
    }

    // toString override method
    @Override
    public String toString() {

        return String.format("Employee Name: %s %s\nEmployee ID #: %d\nDepartment: %s\nHire Date: %s\nEmail: %s\nUser Name: " +
                "%s\nPassword: %s\n", this.getFirstName(), this.getLastName(), employeeID, department, hireDate.format(formatter),
                this.getEmail(), this.getUserName(), this.getPassword());
    }

    // Getters & Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void createFlag(String reason){
        for (int i = 0; i < this.reasonList.length; i++) {
            if (this.reasonList[i].equalsIgnoreCase(reason)) {
                super.createFlag(reason);
                System.out.printf("Employee %s %s has been successfully flagged as %s.\n", this.getFirstName(), this.getLastName(),
                        reason.toLowerCase());
                break;
            }
        }
        if (!this.isFlagged()) {
            System.out.printf("That is not a valid reason to flag %s %s.\n", this.getFirstName(), this.getLastName());
        }
    }
}
