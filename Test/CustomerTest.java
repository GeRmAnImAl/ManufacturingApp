import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    @Test
    void testCustomerConstructor(){
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");
        if (customer != null) {
            System.out.println("Customer object created successfully");
        }
        else{
            System.out.println("Error when creating customer class");
        }
    }
    @Test
    void testToString() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");
        String string = customer.toString();

        // Verify toString method
        assertEquals("Customer Name: Bobby Knight\nCustomer ID #:123\nContact Info:\nEmail: Bknight@Customer.com\n" +
                "Phone: 555-555-5555\nAddress: 11 Wall Way New York New York 08561\nUser Name: BKnight\nPassword: BKnight123\n",
                string);
    }

    @Test
    void testGetCustomerID() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customerID has been set by the constructor
        assertEquals(123, customer.getCustomerID());
    }

    @Test
    void testSetCustomerID() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customerID has been set by the constructor
        assertEquals(123, customer.getCustomerID());

        // Set a new customerID for the customer object
        customer.setCustomerID(124);
        // Verify the new customerID has been set
        assertEquals(124, customer.getCustomerID());
    }

    @Test
    void testGetFirstName() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customer firstName was set by the constructor
        assertEquals("Bobby", customer.getFirstName());
    }

    @Test
    void testSetFirstName() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customer firstName was set by the constructor
        assertEquals("Bobby", customer.getFirstName());

        // Set a new firstName for the customer object
        customer.setFirstName("Robert");
        // Verify the new customer firstName has been set
        assertEquals("Robert", customer.getFirstName());
    }

    @Test
    void testGetLastName() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customer lastName was set by the constructor
        assertEquals("Knight", customer.getLastName());
    }

    @Test
    void testSetLastName() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customer lastName was set by the constructor
        assertEquals("Knight", customer.getLastName());

        // Set a new lastName for the customer object
        customer.setLastName("Night");
        // Verify the new customer lastName has been set
        assertEquals("Night", customer.getLastName());
    }

    @Test
    void testGetEmail() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customer email has been set by the constructor
        assertEquals("Bknight@Customer.com", customer.getEmail());
    }

    @Test
    void testSetEmail() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customer email has been set by the constructor
        assertEquals("Bknight@Customer.com", customer.getEmail());

        // Set a new email for the customer object
        customer.setEmail("RNight@Customer.com");
        //Verify the new customer email has been set
        assertEquals("RNight@Customer.com", customer.getEmail());
    }

    @Test
    void testGetAddress() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customer address has been set by the constructor
        assertEquals("11 Wall Way New York New York 08561", customer.getAddress());
    }

    @Test
    void testSetAddress() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customer address has been set by the constructor
        assertEquals("11 Wall Way New York New York 08561", customer.getAddress());

        // Set a new address for the customer object
        customer.setAddress("11 Wallaby Way Sydney Australia 08561");
        // Verify the new customer address has been set
        assertEquals("11 Wallaby Way Sydney Australia 08561", customer.getAddress());
    }

    @Test
    void testGetPhoneNumber() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customer phoneNumber has been set by the constructor
        assertEquals("555-555-5555", customer.getPhoneNumber());
    }

    @Test
    void testSetPhoneNumber() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify customer phoneNumber has been set by the constructor
        assertEquals("555-555-5555", customer.getPhoneNumber());

        // Set a new phoneNumber for the customer object
        customer.setPhoneNumber("666-666-6666");
        // Verify the new customer phoneNumber has been set
        assertEquals("666-666-6666", customer.getPhoneNumber());
    }

    @Test
    void testGetUserName() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify the customer userName has been set by the constructor
        assertEquals("BKnight", customer.getUserName());
    }

    @Test
    void testSetUserName() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify the customer userName has been set by the constructor
        assertEquals("BKnight", customer.getUserName());

        // Set a new userName for the customer object
        customer.setUserName("RNight");
        // Verify the new customer userName has been set
        assertEquals("RNight", customer.getUserName());
    }

    @Test
    void testGetPassword() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify the customer password has been set by the constructor
        assertEquals("BKnight123", customer.getPassword());
    }

    @Test
    void testSetPassword() {
        // Create customer object
        Customer customer = new Customer(123, "Bobby", "Knight", "Bknight@Customer.com",
                "11 Wall Way New York New York 08561", "555-555-5555", "BKnight", "BKnight123");

        // Verify the customer password has been set by the constructor
        assertEquals("BKnight123", customer.getPassword());

        // Set a new password for the customer object
        customer.setPassword("RNight123");
        // Verify the new customer password has been set
        assertEquals("RNight123", customer.getPassword());
    }
}