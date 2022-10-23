import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class InstallationTest {
    @Test
    void testInstallationConstructor(){
        // Create Installation object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        Installation installation = new Installation(project, "Installed", date);

        if(installation != null){
            System.out.println("Installation object created successfully.");
        }
        else{
            System.out.println("Error creating Installation object.");
        }
    }

    @Test
    void testToString() {
        // Create Installation object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        Installation installation = new Installation(project, "Installed", date);
        assertEquals("Project: 123\nStatus: Installed\nInstallation Date: " + date.format(formatter) + "\n", installation.toString());
    }

    @Test
    void getProject() {
        // Create Installation object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        Installation installation = new Installation(project, "Installed", date);

        // Verify the installation project has been set by the constructor
        assertEquals(project, installation.getProject());
    }

    @Test
    void setProject() {
        // Create Installation object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        Installation installation = new Installation(project, "Installed", date);

        // Verify the installation project has been set by the constructor
        assertEquals(project, installation.getProject());

        // Set a new project for the installation object
        Project newProject = new Project(125, "Blah", "Complete", date, date, date, date, 19.99);
        installation.setProject(newProject);
        // Verify the new installation project has been set
        assertEquals(newProject, installation.getProject());
    }

    @Test
    void getStatus() {
        // Create Installation object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        Installation installation = new Installation(project, "Installed", date);

        // Verify the installation status has been set by the constructor
        assertEquals("Installed", installation.getStatus());
    }

    @Test
    void setStatus() {
        // Create Installation object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        Installation installation = new Installation(project, "Installed", date);

        // Verify the installation status has been set by the constructor
        assertEquals("Installed", installation.getStatus());

        // Set a new status for the installation object
        installation.setStatus("Pending");
        // Verify the new installation status has been set
        assertEquals("Pending", installation.getStatus());
    }

    @Test
    void getInstallDate() {
        // Create Installation object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        Installation installation = new Installation(project, "Installed", date);

        // Verify the installation installDate has been set by the constructor
        assertEquals(date, installation.getInstallDate());
    }

    @Test
    void setInstallDate() {
        // Create Installation object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        Installation installation = new Installation(project, "Installed", date);

        // Verify the installation installDate has been set by the constructor
        assertEquals(date, installation.getInstallDate());

        // Set a new installDate for the installation object
        LocalDate newDate = LocalDate.now().plusDays(5);
        installation.setInstallDate(newDate);
        // Verify the new installation installDate has been set
        assertEquals(newDate, installation.getInstallDate());
    }

    @Test
    void testAddJobNotes(){
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Do Stuff", "In Progress", date, date, date, date, 17.85);
        Installation installation = new Installation(project, "complete", date);

        installation.addJobNotes();
    }
}