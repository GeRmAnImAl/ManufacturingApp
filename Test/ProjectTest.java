import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
    @Test
    void testProjectConstructor(){
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        if(project != null){
            System.out.println("Project object created successfully.");
        }
        else{
            System.out.println("Error creating Project object.");
        }
    }

    @Test
    void testToString() {
        // Create Project object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify toString method
        assertEquals("Project ID: 123\nProject Description: Blah\nProject Status: Fabrication\nEstimated Start Date: " +
                date.format(formatter) +"\nActual Start Date: " + date.format(formatter) +"\nEstimated Finish Date: " +
                date.format(formatter) +"\nActual Finish Date: " + date.format(formatter) +"\nProject Price: $17.50\n", project.toString());
    }

    @Test
    void getProjectID() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify projectID has been set by the constructor
        assertEquals(123, project.getProjectID());
    }

    @Test
    void setProjectID() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify projectID has been set by the constructor
        assertEquals(123, project.getProjectID());

        // Set a new projectID for the project object
        project.setProjectID(124);
        // Verify the new projectID has been set
        assertEquals(124, project.getProjectID());
    }

    @Test
    void getDescription() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project description has been set by the constructor
        assertEquals("Blah", project.getDescription());
    }

    @Test
    void setDescription() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project description has been set by the constructor
        assertEquals("Blah", project.getDescription());

        // Set a new description for the project object
        project.setDescription("Blah, Blah, Blah");
        // Verify the new project description has been set
        assertEquals("Blah, Blah, Blah", project.getDescription());
    }

    @Test
    void getStatus() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project status has been set by the constructor
        assertEquals("Fabrication", project.getStatus());
    }

    @Test
    void setStatus() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project status has been set by the constructor
        assertEquals("Fabrication", project.getStatus());

        // Set a new status for the project object
        project.setStatus("Completed");
        // Verify the new project status has been set
        assertEquals("Completed", project.getStatus());
    }

    @Test
    void getEstimatedStart() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project estimatedStart date has been set by the constructor
        assertEquals(date, project.getEstimatedStart());
    }

    @Test
    void setEstimatedStart() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project estimatedStart date has been set by the constructor
        assertEquals(date, project.getEstimatedStart());

        // Set a new estimatedStart date for the project object
        LocalDate newDate = LocalDate.now().plusMonths(3).plusDays(5);
        project.setEstimatedStart(newDate);
        // Verify the new project estimatedStart date has been set
        assertEquals(newDate, project.getEstimatedStart());
    }

    @Test
    void getActualStart() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project actualStart date has been set by the constructor
        assertEquals(date, project.getActualStart());
    }

    @Test
    void setActualStart() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project actualStart date has been set by the constructor
        assertEquals(date, project.getActualStart());

        // Set a new actualStart date for the project object
        LocalDate newDate = LocalDate.now().plusDays(2);
        project.setActualStart(newDate);
        // Verify the new project actualStart date has been set
        assertEquals(newDate, project.getActualStart());
    }

    @Test
    void getEstimatedFinish() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project estimatedFinish date has been set by the constructor
        assertEquals(date, project.getEstimatedFinish());
    }

    @Test
    void setEstimatedFinish() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project estimatedFinish date has been set by the constructor
        assertEquals(date, project.getEstimatedFinish());

        // Set a new estimatedFinish date for the project object
        LocalDate newDate = LocalDate.now().plusDays(5);
        project.setEstimatedFinish(newDate);
        // Verify the new project estimatedFinish date has been set
        assertEquals(newDate, project.getEstimatedFinish());
    }

    @Test
    void getActualFinish() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project actualFinish date has been set by the constructor
        assertEquals(date, project.getActualFinish());
    }

    @Test
    void setActualFinish() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project actualFinish date has been set by the constructor
        assertEquals(date, project.getActualFinish());

        // Set a new actualFinish date for the project object
        LocalDate newDate = LocalDate.now().plusMonths(5).plusDays(20);
        project.setActualFinish(newDate);
        // Verify the new project actualFinish date has been set
        assertEquals(newDate, project.getActualFinish());
    }

    @Test
    void getPrice() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project price has been set by the constructor
        assertEquals(17.50, project.getPrice());
    }

    @Test
    void setPrice() {
        // Create Project object
        LocalDate date = LocalDate.now();
        Project project = new Project(123, "Blah", "Fabrication", date, date, date, date, 17.50);

        // Verify the project price has been set by the constructor
        assertEquals(17.50, project.getPrice());

        // Set a new price for the project object
        project.setPrice(1239.12);
        // Verify the new project price has been set
        assertEquals(1239.12, project.getPrice());
    }
}