import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Library {

    private HashMap<Integer, Project> openProjects;
    private HashMap<Integer, Project> completedProjects;

    public Library() {
        this.openProjects = new HashMap<>();
        this.completedProjects = new HashMap<>();

        // This is code used to test the GUI
        this.createOpenProjects();
    }

    public Library(HashMap<Integer, Project> openProjects, HashMap<Integer, Project> completedProjects) {
        this.openProjects = openProjects;
        this.completedProjects = completedProjects;
    }

    // Utility method used to create a list of faux projects to test GUI
    public void createOpenProjects() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Project fence = new Project(123, """
                Customer would like a fence for their garden. The fence should be black, with a gothic look.
                the fence should have gold leaf and fleur de lis as decoration. The fence should measure 10'x 6'
                and will need to be cemented into the ground.""",
                "Open", date, date, date, date, 17.58);
        Project gate = new Project(124, """
                Customer wants a small gate to keep their pomeranian from escaping an enclosure. The gate should
                have a modern aesthetic while remaining functional. Customer has chosen to have the gate powder
                coated in a pale blue to match the dog house in the enclosure.""",
                "Open", date, date, date, date, 17.58);
        Project railing = new Project(125, """
                Customer wants a handicap railing for their business. Railing will be 5' x 3' and use rounded
                aluminium. There should be a loop at both ends for users to grab easily. Must comply with USADA
                standards and codes.""",
                "Open", date, date, date, date, 17.58);
        Project banister = new Project(126, """
                Customer would like a simple banister for a small flight of stairs in their home. The banister
                should resemble the branch of a tree. To achieve this look, there should be many bends in the
                banister and nubs will need to be added. The banister is to be aesthetically pleasing while
                remaining fully functional for users.""",
                "Open", date, date, date, date, 17.58);

        this.openProjects.put(fence.getProjectID(), fence);
        this.openProjects.put(gate.getProjectID(), gate);
        this.openProjects.put(railing.getProjectID(), railing);
        this.openProjects.put(banister.getProjectID(), banister);
    }

    // Needs functionality
    public boolean addProject(){
        return false;
    }

    // Needs functionality
    public boolean deleteProject(){
        return false;
    }

    @Override
    public String toString() {
        return String.format("Open Projects: \n%s\nCompleted Projects: \n%s\n", openProjects, completedProjects);
    }

    public HashMap<Integer, Project> getOpenProjects() {
        return this.openProjects;
    }

    public HashMap<Integer, Project> getCompletedProjects() {
        return completedProjects;
    }
}
