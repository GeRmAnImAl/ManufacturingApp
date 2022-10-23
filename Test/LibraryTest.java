import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test
    void testLibraryConstructor(){
        // Create Library object
        LocalDate date = LocalDate.now();
        Project fence = new Project(123, "Blah", "Open", date, date, date, date, 17.58);
        Project gate = new Project(124, "Blah", "Open", date, date, date, date, 17.58);
        HashMap<Integer, Project> openProjects = new HashMap<>();
        openProjects.put(fence.getProjectID(), fence);
        HashMap<Integer, Project> completedProjects = new HashMap<>();
        completedProjects.put(gate.getProjectID(), gate);

        Library library = new Library(openProjects, completedProjects);

        // Verify creation of Library object
        if (library != null) {
            System.out.println("Library object created successfully.");
        }
        else{
            System.out.println("Error creating Library object.");
        }
    }

    @Test
    void testToString(){
        // Create Library object
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project fence = new Project(123, "Blah", "Open", date, date, date, date, 17.58);
        Project gate = new Project(124, "Blah", "Open", date, date, date, date, 17.58);
        HashMap<Integer, Project> openProjects = new HashMap<>();
        openProjects.put(fence.getProjectID(), fence);
        HashMap<Integer, Project> completedProjects = new HashMap<>();
        completedProjects.put(gate.getProjectID(), gate);

        Library library = new Library(openProjects, completedProjects);

        // Verify output of toString method
        assertEquals("Open Projects: \n{123=Project ID: 123\nProject Description: Blah\nProject Status: Open\n" +
                "Estimated Start Date: " + date.format(formatter) + "\nActual Start Date: " + date.format(formatter) + "\n" +
                "Estimated Finish Date: " + date.format(formatter) + "\nActual Finish Date: " + date.format(formatter) +
                "\nProject Price: $17.58\n}\nCompleted Projects: \n{124=Project ID: 124\nProject Description: Blah\n" +
                "Project Status: Open\nEstimated Start Date: " + date.format(formatter) + "\nActual Start Date: " +
                date.format(formatter) + "\nEstimated Finish Date: " + date.format(formatter) + "\nActual Finish Date: "
                + date.format(formatter) + "\nProject Price: $17.58\n}\n", library.toString());
    }

    @Test
    void getOpenProjects() {
        // Create Library object using empty constructor
        Library library = new Library();

        // Verify the creation of an empty openProjects hashmap
        assertEquals("{}", library.getOpenProjects().toString());

        // Add projects to openProjects hashmap
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project fence = new Project(123, "Blah", "Open", date, date, date, date, 17.58);
        Project gate = new Project(124, "Blah", "Open", date, date, date, date, 17.58);
        library.getOpenProjects().put(fence.getProjectID(), fence);
        library.getOpenProjects().put(gate.getProjectID(), gate);

        // Verify the addition of the projects to the openProjects hashmap
        assertEquals("{123=Project ID: 123\nProject Description: Blah\nProject Status: Open\nEstimated Start Date: "
                + date.format(formatter) + "\nActual Start Date: " + date.format(formatter) + "\nEstimated Finish Date: "
                + date.format(formatter) + "\nActual Finish Date: " + date.format(formatter) + "\nProject Price: $17.58\n" +
                ", 124=Project ID: 124\nProject Description: Blah\nProject Status: Open\nEstimated Start Date: " +
                date.format(formatter) + "\nActual Start Date: " + date.format(formatter) + "\nEstimated Finish Date: "
                + date.format(formatter) + "\nActual Finish Date: " + date.format(formatter) + "\nProject Price: $17.58\n" +
                "}", library.getOpenProjects().toString());
    }

    @Test
    void getCompletedProjects() {
        // Create Library object using empty constructor
        Library library = new Library();

        // Verify the creation of an empty completedProjects hashmap
        assertEquals("{}", library.getCompletedProjects().toString());

        // Add projects to completedProjects hashmap
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project fence = new Project(123, "Blah", "Open", date, date, date, date, 17.58);
        Project gate = new Project(124, "Blah", "Open", date, date, date, date, 17.58);
        library.getCompletedProjects().put(fence.getProjectID(), fence);
        library.getCompletedProjects().put(gate.getProjectID(), gate);

        // Verify the addition of the projects to the completedProjects hashmap
        assertEquals("{123=Project ID: 123\nProject Description: Blah\nProject Status: Open\nEstimated Start Date: "
                + date.format(formatter) + "\nActual Start Date: " + date.format(formatter) + "\nEstimated Finish Date: "
                + date.format(formatter) + "\nActual Finish Date: " + date.format(formatter) + "\nProject Price: $17.58\n" +
                ", 124=Project ID: 124\nProject Description: Blah\nProject Status: Open\nEstimated Start Date: " +
                date.format(formatter) + "\nActual Start Date: " + date.format(formatter) + "\nEstimated Finish Date: "
                + date.format(formatter) + "\nActual Finish Date: " + date.format(formatter) + "\nProject Price: $17.58\n" +
                "}", library.getCompletedProjects().toString());
    }
}