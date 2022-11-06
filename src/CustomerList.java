import java.io.*;
import java.util.ArrayList;

public class CustomerList implements Serializable {
    private Customer customer;
    private ArrayList<Customer> listOfCustomers = new ArrayList<>();
    private String listOfCustomersFileName = "listOfCustomers.ser";

    public CustomerList() {
        this.readCustomerListFile();

        if(listOfCustomers.isEmpty() || listOfCustomers == null){
            this.createCustomerList();
            this.writeCustomerListFile();
            this.readCustomerListFile();
        }
    }

    public ArrayList<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public void setListOfCustomers(ArrayList<Customer> listOfCustomers) {
        this.listOfCustomers = listOfCustomers;
    }

    public void createCustomerList() {
        customer = new Customer(123, "Ron", "Burgundy", "RBurgundy@Customer.com",
                "133 News Way, San Diego CA, 00001", "555-555-5555", "RBurgundy", "$anDi3go");
        this.listOfCustomers.add(customer);
        customer = new Customer(124, "Doc", "Holiday", "DHoliday@Customer.com",
                "12 Noon Drive, Tombstone TX, 00002", "666-666-6666", "DHoliday", "Huckl3b3rry");
        this.listOfCustomers.add(customer);
        customer = new Customer(125, "Frank", "Castle", "FCastle@Customer.com",
                "1832 Astoria Blvd, Queens NY, 00003", "777-777-7777", "FCastle", "Pun1$h3r");
        this.listOfCustomers.add(customer);
    }

    public void printCustomerList() {
        for (Customer customer : listOfCustomers) {
            System.out.println(customer);
        }
    }

    private void writeCustomerListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(listOfCustomersFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfCustomers);
            out.close();
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private void readCustomerListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(listOfCustomersFileName);
            in = new ObjectInputStream(fis);
            listOfCustomers = (ArrayList) in.readObject();
            in.close();
            if(listOfCustomers.isEmpty()){
                System.out.println("There are no customers in the list.");
            }
        }
        catch (FileNotFoundException fne){
            System.out.println("File was not found, a new one will be created.");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
}
