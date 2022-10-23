import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TestHarness {

    public TestHarness(){
        testLibrary();
        testInstallation();
        testClassHierarchy();
        testInterface();
    }

    private void testLibrary(){
        System.out.println("Testing the Library class:");
        Library library = new Library();
        if(library != null) {
            System.out.println("Open Projects: " + library.getOpenProjects());
            System.out.println("Completed Projects: " + library.getCompletedProjects());
        }
        else{
            System.out.println("There was an error creating the Library object.");
        }
        System.out.println("Library fields may not be manually set.");
        System.out.println("toString method test:");
        System.out.println(library.toString());
    }

    private void testInstallation(){
        System.out.println("Testing the Installation class:");
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        Installation installation = new Installation(project, "Installed", date);

        if(installation != null){
            System.out.println(installation.getProject());
            System.out.println(installation.getStatus());
            System.out.println(installation.getInstallDate().format(formatter) + "\n");
        }
        else{
            System.out.println("Error creating Installation object.");
        }

        LocalDate newDate = LocalDate.now().plusDays(5);
        Project newProject = new Project(124, "Blah, Blah, Blah", "Completed", newDate, newDate, newDate, newDate, 19.53);
        installation.setProject(newProject);
        installation.setStatus("Pending");
        installation.setInstallDate(newDate);
        System.out.println("toString method test:");
        System.out.println(installation.toString());
    }

    private void testClassHierarchy(){
        System.out.println("Testing Class Hierarchy:");
        ArrayList<User> users = new ArrayList<>();
        LocalDate date = LocalDate.now();
        Customer customer = new Customer(123, "Ron", "Burgundy", "RBurgundy@Customer.com",
                "133 News Way, San Diego CA, 00001", "555-555-5555", "RBurgundy", "$anDi3go");
        Employee employee = new Employee("Doc", "Holiday", 1882, date, "Gun-slinging",
                "DHoliday@Employee.com", "Dholiday", "Huck13b33ry");
        users.add(customer);
        users.add(employee);
        for (User user : users){
            user.createFlag("Late");
        }
    }

    private void testInterface(){
        System.out.println("Testing Interface implementation:");
        ArrayList<JobNotes> jobNotes = new ArrayList<>();
        LocalDate date = LocalDate.now();

        Project project = new Project(123, "Do Stuff", "In Progress", date, date, date, date, 17.85);
        Installation installation = new Installation(project, "complete", date);

        jobNotes.add(project);
        jobNotes.add(installation);

        for(JobNotes job : jobNotes){
            job.addJobNotes();
            job.printJobNotes();
        }
    }

}
