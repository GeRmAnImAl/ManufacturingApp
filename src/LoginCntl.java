import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginCntl<T> implements ActionListener {
    private LoginUI loginUI;

    private EmployeeList currentEmployeeList;
    private CustomerList currentCustomerList;
    private ArrayList<Employee> listOfEmployees;
    private ArrayList<Customer> listOfCustomers;
    private String listToCheck = "";

    public LoginCntl(){
        currentEmployeeList = new EmployeeList();
        currentCustomerList = new CustomerList();
        loginUI = new LoginUI();
        listOfEmployees = currentEmployeeList.getListOfEmployees();
        listOfCustomers = currentCustomerList.getListOfCustomers();
        loginUI.setVisible(true);
        addALButtons();
    }

    private void addALButtons() {
        loginUI.getLoginButton().addActionListener(this);
        loginUI.getQuitButton().addActionListener(this);
        loginUI.getCustomerRadioButton().addActionListener(this);
        loginUI.getEmployeeRadioButton().addActionListener(this);
    }

    public EmployeeList getEmployeeList(){
        return currentEmployeeList;
    }

    public CustomerList getCustomerList(){
        return currentCustomerList;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if(source == loginUI.getLoginButton()){
            if(listToCheck.isEmpty()){
                loginUI.getMessageField().setText("Are you an employee or a customer?");
            }
            else{
                goLogin();
            }
        } else if (source == loginUI.getQuitButton()) {
            System.exit(0);
        } else if (source == loginUI.getCustomerRadioButton()) {
            this.listToCheck = "Customer";
        } else if (source == loginUI.getEmployeeRadioButton()) {
            this.listToCheck = "Employee";

        }

    }

    private void goLogin() {
        boolean userFound = false;
        if(this.listToCheck.equals("Customer")){
            for(Customer customer : listOfCustomers){
                if (loginUI.getUserNameTextField().getText().equals(customer.getUserName())){
                    userFound = true;
                    if(loginUI.getPasswordField1().getText().equals(customer.getPassword())){
                        loginUI.getMessageField().setText("Login Successful.");
                    }
                    else{
                        System.out.println("Incorrect Password.");
                    }
                }
                else{
                    continue;
                }
            }
        } else if (this.listToCheck.equals("Employee")) {
            for(Employee employee : listOfEmployees){
                if (loginUI.getUserNameTextField().getText().equals(employee.getUserName())){
                    userFound = true;
                    if(loginUI.getPasswordField1().getText().equals(employee.getPassword())){
                        loginUI.getMessageField().setText("Login Successful.");
                    }
                    else{
                        System.out.println("Incorrect Password.");
                    }
                }
                else{
                    continue;
                }
            }
        }

        if(!userFound){
            loginUI.getMessageField().setText("User name does not exist.");
        }
    }
}
