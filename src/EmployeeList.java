import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeList {
    private Employee employee;
    private ArrayList<Employee> listOfEmployees = new ArrayList<>();

    private String listOfEmployeesFileName = "listOfEmployees.ser";

    public EmployeeList() {
        this.readEmployeeListFile();

        if(listOfEmployees.isEmpty() || listOfEmployees == null){
            this.createEmployeeList();
            this.writeEmployeeListFile();
            this.readEmployeeListFile();
        }



    }

    private void writeEmployeeListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(listOfEmployeesFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfEmployees);
            out.close();
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private void readEmployeeListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(listOfEmployeesFileName);
            in = new ObjectInputStream(fis);
            listOfEmployees = (ArrayList) in.readObject();
            in.close();
            if(!listOfEmployees.isEmpty()){
                System.out.println("There are no employees in the list.");
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

    public ArrayList<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(ArrayList<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }


    public void createEmployeeList() {
        LocalDate date = LocalDate.now();
        employee = new Employee("Robert", "Paulsin", 19567, date, "Fight Club",
                "RPaulsiny@Employee.com", "RPaulsin", "F1r$t_Ru13");
        this.listOfEmployees.add(employee);
        employee = new Employee("Bruce", "Wayne", 19764, date, "Vigilantes",
                "BWayne@Employee.com", "BWayne", "B@tm@n");
        this.listOfEmployees.add(employee);
        employee = new Employee("John", "Snow", 19846, date, "The Night's Watch",
                "JSnow@Employee.com", "JSnow", "W1nt3r");
        this.listOfEmployees.add(employee);
    }

    public void printEmployeeList() {
        for (Employee employee : listOfEmployees) {
            System.out.println(employee);
        }
    }
}
