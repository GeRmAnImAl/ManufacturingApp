import java.util.HashMap;

public class Customer extends User {
    private int customerID;
    private String address;
    private String phoneNumber;
    // This will not be included in the constructor and will be created by default.
    private HashMap<Integer, Project> projects = new HashMap<>();
    private String[] reasonList = {"Late Payment", "Non-Payment", "Fraud"};

    // Constructor
    public Customer(int customerID, String firstName, String lastName, String email, String address, String phoneNumber,
                    String userName, String password) {
        super(firstName, lastName, email, userName, password);
        this.customerID = customerID;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("Customer Name: %s %s\nCustomer ID #:%d\nContact Info:\nEmail: %s\nPhone: %s\nAddress: %s\nUser Name: %s" +
                "\nPassword: %s\n", this.getFirstName(), this.getLastName(), customerID, this.getEmail(), phoneNumber, address, this.getUserName(), this.getPassword());
    }

    // Getters & Setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String[] getReasonList(){
        return reasonList;
    }

    public HashMap<Integer, Project> getProjects() {
        return projects;
    }

    @Override
    public void createFlag(String reason){
        for (int i = 0; i < this.reasonList.length; i++) {
            if (this.reasonList[i].equalsIgnoreCase(reason)) {
                super.createFlag(reason);
                System.out.printf("Customer %s %s has been successfully flagged for %s.\n", this.getFirstName(), this.getLastName(),
                reason.toLowerCase());
                break;
            }
        }
        if (!this.isFlagged()) {
            System.out.printf("That is not a valid reason to flag %s %s.\n", this.getFirstName(), this.getLastName());
        }
    }
}
