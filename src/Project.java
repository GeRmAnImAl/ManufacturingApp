import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Project implements JobNotes {
    private int projectID;
    private String description, status;
    private LocalDate estimatedStart;
    private LocalDate actualStart;
    private LocalDate estimatedFinish;
    private LocalDate actualFinish;
    private double price;
    private HashMap<String, String> jobNotes = new HashMap<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


    // Constructor
    public Project(int projectID, String description, String status, LocalDate estimatedStart, LocalDate actualStart,
                   LocalDate estimatedFinish, LocalDate actualFinish, double price) {
        this.projectID = projectID;
        this.description = description;
        this.status = status;
        this.estimatedStart = estimatedStart;
        this.actualStart = actualStart;
        this.estimatedFinish = estimatedFinish;
        this.actualFinish = actualFinish;
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format("Project ID: %d\nProject Description: %s\nProject Status: %s\nEstimated Start Date: %s" +
                "\nActual Start Date: %s\nEstimated Finish Date: %s\nActual Finish Date: %s\nProject Price: $%,.2f\n",
                projectID, description, status, estimatedStart.format(formatter), actualStart.format(formatter), estimatedFinish.format(formatter),
                actualFinish.format(formatter), price);

    }

    // Getters & Setters
    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getEstimatedStart() {
        return estimatedStart;
    }

    public void setEstimatedStart(LocalDate estimatedStart) {
        this.estimatedStart = estimatedStart;
    }

    public LocalDate getActualStart() {
        return actualStart;
    }

    public void setActualStart(LocalDate actualStart) {
        this.actualStart = actualStart;
    }

    public LocalDate getEstimatedFinish() {
        return estimatedFinish;
    }

    public void setEstimatedFinish(LocalDate estimatedFinish) {
        this.estimatedFinish = estimatedFinish;
    }

    public LocalDate getActualFinish() {
        return actualFinish;
    }

    public void setActualFinish(LocalDate actualFinish) {
        this.actualFinish = actualFinish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public void addJobNotes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title for this notation: ");
        String title = scanner.nextLine();
        System.out.println("Enter your notation: ");
        String note = scanner.nextLine();
        jobNotes.put(title, note);
        System.out.println("The note has been added.");
    }

    @Override
    public void printJobNotes() {
        StringBuilder stringBuilder = new StringBuilder();
        if(jobNotes.isEmpty()){
            System.out.println("There are no Job Notes to display.");
        }
        else{
            for(Map.Entry<String, String> note : this.jobNotes.entrySet()){
                String key = note.getKey();
                String value = note.getValue();
                stringBuilder.append(key.toUpperCase()).append("\n");
                stringBuilder.append(value).append("\n");
                stringBuilder.append("\n");
            }
        }
        System.out.println(stringBuilder);

    }
}
