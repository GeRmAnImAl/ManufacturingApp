import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerCntl implements ActionListener{
    private CustomerList customerList;
    private CustomerUI customerUI;
    private CustomerTableModel customerTableModel;
    private CustomerListUI customerListUI;

    public CustomerCntl(){
        customerList = new CustomerList();
        customerTableModel = new CustomerTableModel(getListOfCustomers());
        customerListUI = new CustomerListUI(this);
        customerTableModel = new CustomerTableModel(getListOfCustomers());
        customerListUI.setVisible(true);
    }

    public ArrayList<Customer> getListOfCustomers(){
        return customerList.getListOfCustomers();
    }

    public void addALButtons(){
        customerUI.getNextButton().addActionListener(this);
        customerUI.getPreviousButton().addActionListener(this);
        customerUI.getAddButton().addActionListener(this);
        customerUI.getUpdateButton().addActionListener(this);
        customerUI.getDeleteButton().addActionListener(this);
        customerUI.getDoneButton().addActionListener(this);
    }

    public CustomerTableModel getCustomerTableModel(){
        return customerTableModel;
    }

    public void getCustomerUI(int selectedRow){
        customerUI = new CustomerUI(this, selectedRow);
        customerListUI.setVisible(false);
        addALButtons();
        customerUI.setVisible(true);
    }

    public void getBlankCustomerUI(){
        customerUI = new CustomerUI(this);
        customerListUI.setVisible(false);
        addALButtons();
        customerUI.setVisible(true);
    }


    public int getCustomer(int selectedRow) {

        return selectedRow;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if(source == customerUI.getNextButton()){
            goNextCustomer();
        }
        else if (source == customerUI.getPreviousButton()) {
            goPreviousCustomer();
        }
        else if (source == customerUI.getAddButton()) {
            goAddCustomer();
        }
        else if(source == customerUI.getUpdateButton()){
            goUpdateCustomer();
        }
        else if(source == customerUI.getDeleteButton()){
            goDeleteCustomer();
        }
        else if(source == customerUI.getDoneButton()){
            customerUI.setVisible(false);
            customerListUI.setVisible(true);
        }
    }

    private void goDeleteCustomer() {
        int customerToDelete = customerUI.getCurrentCustomer();
        if(customerUI.getCurrentCustomer() == customerUI.getListOfCustomers().size() - 1){
            customerUI.setCurrentCustomer(customerUI.getListOfCustomers().size() - 2);
        }
        customerUI.getListOfCustomers().remove(customerToDelete);
        customerUI.parseCustomer(customerUI.getListOfCustomers().get(customerUI.getCurrentCustomer()));

    }

    private void goUpdateCustomer() {
        int id = Integer.parseInt(customerUI.getCustIDTextField().getText());
        String userName = customerUI.getCustUserNameTextField().getText();
        String[] name = customerUI.getCustNameTextField().getText().split(" ");
        String phoneNumber = customerUI.getCustPhoneTextField().getText();
        String email = customerUI.getCustEmailTextField().getText();
        String address = customerUI.getCustAddressTextField().getText();

        Customer customerToUpdate = customerUI.getListOfCustomers().get(customerUI.getCurrentCustomer());

        customerToUpdate.setCustomerID(id);
        customerToUpdate.setUserName(userName);
        customerToUpdate.setFirstName(name[0]);
        customerToUpdate.setLastName(name[1]);
        customerToUpdate.setPhoneNumber(phoneNumber);
        customerToUpdate.setEmail(email);
        customerToUpdate.setAddress(address);
    }

    private void goAddCustomer() {
        int id = Integer.parseInt(customerUI.getCustIDTextField().getText());
        String userName = customerUI.getCustUserNameTextField().getText();
        String[] name = customerUI.getCustNameTextField().getText().split(" ");
        String phoneNumber = customerUI.getCustPhoneTextField().getText();
        String email = customerUI.getCustEmailTextField().getText();
        String address = customerUI.getCustAddressTextField().getText();
        // Password will be set by default
        String password = "Change me for security";

        Customer customerToAdd = new Customer(id, name[0], name[1], email, address, phoneNumber, userName, password);
        customerUI.getListOfCustomers().add(customerToAdd);


    }

    private void goPreviousCustomer() {
        if(customerUI.getCurrentCustomer() == 0){
            customerUI.setCurrentCustomer(customerUI.getListOfCustomers().size() - 1);
            customerUI.parseCustomer(customerUI.getListOfCustomers().get(customerUI.getCurrentCustomer()));
        }
        else{
            customerUI.setCurrentCustomer(customerUI.getCurrentCustomer() - 1);
            customerUI.parseCustomer(customerUI.getListOfCustomers().get(customerUI.getCurrentCustomer()));
        }
    }

    private void goNextCustomer() {
        if(customerUI.getCurrentCustomer() == customerUI.getListOfCustomers().size() - 1){
            customerUI.setCurrentCustomer(0);
            customerUI.parseCustomer(customerUI.getListOfCustomers().get(customerUI.getCurrentCustomer()));
        }
        else{
            customerUI.setCurrentCustomer(customerUI.getCurrentCustomer() + 1);
            customerUI.parseCustomer(customerUI.getListOfCustomers().get(customerUI.getCurrentCustomer()));
        }
    }
}
