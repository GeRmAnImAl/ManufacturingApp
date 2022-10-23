import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    void testEmployeeConstructor(){
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        if (employee != null) {
            System.out.println("Employee object created successfully.");
        }
        else{
            System.out.println("Error creating Employee object.");
        }
    }

    @Test
    void testToString() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify toString method
        assertEquals("Employee Name: Bill Burr\nEmployee ID #: 123\nDepartment: Manufacturing\nHire Date: " +
                date.format(formatter) + "\nEmail: BBurr@Company.com\nUser Name: BBurr\nPassword: BBurr123\n", employee.toString());
    }

    @Test
    void testGetFirstName() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify employee firstName has been set by the constructor
        assertEquals("Bill", employee.getFirstName());
    }

    @Test
    void testSetFirstName() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify employee firstName has been set by the constructor
        assertEquals("Bill", employee.getFirstName());

        // Set a new firstName for the employee object
        employee.setFirstName("William");
        // Verify the new employee firstName has been set
        assertEquals("William", employee.getFirstName());
    }

    @Test
    void testGetLastName() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify employee lastName has been set by the constructor
        assertEquals("Burr", employee.getLastName());
    }

    @Test
    void testSetLastName() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify employee lastName has been set by the constructor
        assertEquals("Burr", employee.getLastName());

        // Set a new lastName for the employee object
        employee.setLastName("Burnt");
        // Verify the new employee lastName has been set
        assertEquals("Burnt", employee.getLastName());
    }

    @Test
    void testGetEmployeeID() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employeeID has been set by the constructor
        assertEquals(123, employee.getEmployeeID());
    }

    @Test
    void testSetEmployeeID() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employeeID has been set by the constructor
        assertEquals(123, employee.getEmployeeID());

        // Set a new employeeID for the employee object
        employee.setEmployeeID(124);
        // Verify the new employeeID has been set
        assertEquals(124, employee.getEmployeeID());
    }

    @Test
    void testGetHireDate() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employee hireDate has been set by the constructor
        assertEquals(date, employee.getHireDate());
    }

    @Test
    void testSetHireDate() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employee hireDate has been set by the constructor
        assertEquals(date, employee.getHireDate());

        // Set a new hireDate for the employee object
        LocalDate newDate = LocalDate.now().minusDays(2);
        employee.setHireDate(newDate);
        assertEquals(newDate, employee.getHireDate());
    }

    @Test
    void testGetDepartment() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employee department has been set by the constructor
        assertEquals("Manufacturing", employee.getDepartment());
    }

    @Test
    void testSetDepartment() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employee department has been set by the constructor
        assertEquals("Manufacturing", employee.getDepartment());

        // Set a new department for the employee object
        employee.setDepartment("Human Resources");
        // Verify the new employee department has been set
        assertEquals("Human Resources", employee.getDepartment());
    }

    @Test
    void testGetEmail() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employee email has been set by the constructor
        assertEquals("BBurr@Company.com", employee.getEmail());
    }

    @Test
    void testSetEmail() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employee email has been set by the constructor
        assertEquals("BBurr@Company.com", employee.getEmail());

        // Set new email for employee object
        employee.setEmail("WBurnt@Company.com");
        // Verify the new employee email has been set
        assertEquals("WBurnt@Company.com", employee.getEmail());
    }

    @Test
    void testGetUserName() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employee userName has been set by the constructor
        assertEquals("BBurr", employee.getUserName());
    }

    @Test
    void testSetUserName() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employee userName has been set by the constructor
        assertEquals("BBurr", employee.getUserName());

        // Set a new userName for the employee object
        employee.setUserName("WBurnt");
        // Verify the new employee userName has been set
        assertEquals("WBurnt", employee.getUserName());
    }

    @Test
    void testGetPassword() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employee password has been set by the constructor
        assertEquals("BBurr123", employee.getPassword());
    }

    @Test
    void testSetPassword() {
        // Create Employee object
        LocalDate date = LocalDate.now();
        Employee employee = new Employee("Bill", "Burr", 123, date, "Manufacturing",
                "BBurr@Company.com", "BBurr", "BBurr123");

        // Verify the employee password has been set by the constructor
        assertEquals("BBurr123", employee.getPassword());

        // Set a new password for the employee object
        employee.setPassword("WBurnt123");
        // Verify the new employee password has been set
        assertEquals("WBurnt123", employee.getPassword());
    }
}