import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class CustomerUI extends JFrame {
    private CustomerCntl customerCntl;
    private ArrayList<Customer> listOfCustomers;
    private int currentCustomer = 0;
    private Customer customer;
    private int currentSelectedRow;

    // UI components
    private JLabel idField;
    private JLabel lNameField;
    private JLabel phoneField;
    private JTextField custIDTextField;
    private JTextField custNameTextField;
    private JTextField custEmailTextField;
    private JTextField custPhoneTextField;
    private JTextField custUserNameTextField;
    private JTextField custAddressTextField;
    private JLabel custID;
    private JLabel custName;
    private JLabel custEmail;
    private JLabel custPhone;
    private JLabel custUserName;
    private JLabel custAddress;
    private JButton previousButton;
    private JButton nextButton;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JLabel custProjects;
    private JTextField custProjectsTextField;
    private JPanel mainPanel;
    private JButton doneButton;

    // int selectedRow
    public CustomerUI(CustomerCntl customerCntl, int selectedRow) {
        setContentPane(mainPanel);
        setSize(350, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.customerCntl = customerCntl;
        this.currentSelectedRow = selectedRow;
        this.currentCustomer = customerCntl.getCustomer(selectedRow);
        listOfCustomers = customerCntl.getListOfCustomers();
        customer = listOfCustomers.get(currentCustomer);
        parseCustomer(customer);
    }

    public CustomerUI(CustomerCntl customerCntl) {
        setContentPane(mainPanel);
        setSize(350, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.customerCntl = customerCntl;
        listOfCustomers = customerCntl.getListOfCustomers();
        customer = listOfCustomers.get(currentCustomer);
        createEmptyPage();
    }

    // Getters
    public JButton getPreviousButton() {
        return previousButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getDoneButton() {
        return doneButton;
    }

    public ArrayList<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public int getCurrentCustomer() {
        return currentCustomer;
    }

    // Setters
    public void setCurrentCustomer(int currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public JTextField getCustIDTextField() {
        return custIDTextField;
    }

    public JTextField getCustNameTextField() {
        return custNameTextField;
    }

    public JTextField getCustEmailTextField() {
        return custEmailTextField;
    }

    public JTextField getCustPhoneTextField() {
        return custPhoneTextField;
    }

    public JTextField getCustUserNameTextField() {
        return custUserNameTextField;
    }

    public JTextField getCustAddressTextField() {
        return custAddressTextField;
    }

    public JTextField getCustProjectsTextField() {
        return custProjectsTextField;
    }

    public void parseCustomer(Customer customer) {
        custIDTextField.setText(String.valueOf(customer.getCustomerID()));
        custUserNameTextField.setText(customer.getUserName());
        custEmailTextField.setText(customer.getEmail());
        custPhoneTextField.setText(customer.getPhoneNumber());
        custAddressTextField.setText(customer.getAddress());
        custNameTextField.setText(customer.getFirstName() + " " + customer.getLastName());
        ArrayList<Integer> projectList = new ArrayList<>();
        for (Integer projectID : customer.getProjects().keySet()) {
            projectList.add(projectID);
        }
        Collections.sort(projectList);
        custProjectsTextField.setText(String.valueOf(projectList.toString()));
    }

    public void createEmptyPage() {
        custIDTextField.setText("");
        custUserNameTextField.setText("");
        custEmailTextField.setText("");
        custPhoneTextField.setText("");
        custAddressTextField.setText("");
        custNameTextField.setText("");
        custProjectsTextField.setText("Can not add projects at this time.");
    }


}
