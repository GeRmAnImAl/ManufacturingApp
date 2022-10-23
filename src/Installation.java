import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Installation implements JobNotes{
    private Project project;
    // Installed, Scheduled, Not Scheduled
    private String status;
    private LocalDate installDate;

    public enum NoteType{
        CUSTOMERCOMMENT,
        EMPLOYEECOMMENT
    }

    // Fields for notes regarding installations
    private HashMap<LocalDate, String> customerNote = new HashMap<>();
    private HashMap<LocalDate, String> employeeNote = new HashMap<>();
    private HashMap<NoteType, HashMap<LocalDate, String>> jobNotes = new HashMap<>();





    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    // Constructor
    public Installation(Project project, String status, LocalDate installDate){
        this.project = project;
        this.status = status;
        this.installDate = installDate;
        this.jobNotes.put(NoteType.CUSTOMERCOMMENT, customerNote);
        this.jobNotes.put(NoteType.EMPLOYEECOMMENT, employeeNote);


    }

    @Override
    public String toString(){
        return String.format("Project: %d\nStatus: %s\nInstallation Date: %s\n", project.getProjectID(), status, installDate.format(formatter));
    }

    // Getters & Setters
    public Project getProject(){
        return this.project;
    }

    public void setProject(Project project){
        this.project = project;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getInstallDate(){
        return installDate;
    }

    public void setInstallDate(LocalDate installDate) {
        this.installDate = installDate;
    }



    @Override
    public void addJobNotes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is this a CUSTOMER or EMPLOYEE comment: ");
        String userInput = scanner.nextLine();
        String comment;
        LocalDate date;


        switch (userInput.toUpperCase()){
            case "CUSTOMER":
                System.out.println("Please enter the CUSTOMER comment: ");
                comment = scanner.nextLine();
                System.out.println("Please enter the date (mm/dd/yy): ");
                date = LocalDate.parse(scanner.nextLine(), formatter);

                // Check if map is empty
                if(!customerNote.isEmpty()){
                    // If map is not empty check if key is already in the map, if it's not add the comment
                    if(this.customerNote.get(date) == null){
                        customerNote.put(date,comment);
                    }
                    // If the key IS in the map, append the value
                    else{
                        for(Map.Entry<LocalDate, String> note : this.customerNote.entrySet()){
                            if(note.getKey() == date){
                                this.customerNote.put(date, note.getValue() + "\n\n" + comment);
                            }
                        }
                    }
                }
                // Map is empty, add comment
                else{
                    customerNote.put(date,comment);
                }
                System.out.println("The note has been added.");
                break;

            case "EMPLOYEE":
                System.out.println("Please enter the EMPLOYEE comment: ");
                comment = scanner.nextLine();
                System.out.println("Please enter the date (mm/dd/yy): ");
                date = LocalDate.parse(scanner.nextLine(), formatter);

                // Check if list is empty
                if(!employeeNote.isEmpty()){
                    // If list is not empty check if key is already in the list, if it's not add the comment
                    if(this.employeeNote.get(date) == null){
                        employeeNote.put(date,comment);
                    }
                    // If the key IS in the list, append the value
                    else{
                        for(Map.Entry<LocalDate, String> note : this.employeeNote.entrySet()){
                            if(note.getKey() == date){
                                this.employeeNote.put(date, note.getValue() + "\n\n" + comment);
                            }
                        }
                    }
                }
                // List is empty, add comment
                else{
                    employeeNote.put(date,comment);
                }
                System.out.println("The note has been added.");
                break;
        }

    }

    @Override
    public void printJobNotes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What notes would you like to print? (CUSTOMER or EMPLOYEE):");
        String choice = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();

        switch (choice.toUpperCase()){
            case "CUSTOMER":
                if(this.customerNote.isEmpty()){
                    System.out.println("There are no CUSTOMER comments.");
                }
                else{
                    stringBuilder.append("CUSTOMER COMMENTS\n");
                    for(Map.Entry<NoteType, HashMap<LocalDate, String>> note : this.jobNotes.entrySet()){
                        if(note.getKey().equals(NoteType.CUSTOMERCOMMENT)){
                            for(Map.Entry<LocalDate, String> comment : this.customerNote.entrySet()){
                                LocalDate key = comment.getKey();
                                String value = comment.getValue();
                                stringBuilder.append(key).append("\n");
                                stringBuilder.append(value).append("\n");
                                stringBuilder.append("\n");
                            }
                            System.out.print(stringBuilder);

                        }
                    }
                }
                break;

            case "EMPLOYEE":
                if(this.employeeNote.isEmpty()){
                    System.out.println("There are no EMPLOYEE comments.");
                }
                else{
                    stringBuilder.append("EMPLOYEE COMMENTS\n");
                    for(Map.Entry<NoteType, HashMap<LocalDate, String>> note : this.jobNotes.entrySet()){
                        if(note.getKey().equals(NoteType.EMPLOYEECOMMENT)){
                            for(Map.Entry<LocalDate, String> comment : this.employeeNote.entrySet()){
                                LocalDate key = comment.getKey();
                                String value = comment.getValue();
                                stringBuilder.append(key).append("\n");
                                stringBuilder.append(value).append("\n");
                                stringBuilder.append("\n");
                            }
                            System.out.print(stringBuilder);

                        }
                    }
                }
                break;

            default:
                System.out.println("Incorrect input.");
                break;
        }
    }
}
