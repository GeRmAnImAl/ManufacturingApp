import java.time.LocalDate;

public class Order {
    private Project project;
    private LocalDate dateOrdered;
    private LocalDate expectedCompletionDate;



    public Order(Project project, LocalDate dateOrdered, LocalDate expectedCompletionDate){
        this.project = project;
        this.dateOrdered = dateOrdered;
        this.expectedCompletionDate = expectedCompletionDate;
    }

    public boolean decideToInsert(Order newOrder) {
        if(this.dateOrdered.isBefore(newOrder.dateOrdered)){
            if(this.expectedCompletionDate.isBefore(newOrder.expectedCompletionDate)){
                return true;
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }

    public Project getProject() {
        return project;
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public LocalDate getExpectedCompletionDate() {
        return expectedCompletionDate;
    }

    @Override
    public String toString(){
        return "Project #: " + String.valueOf(this.project.getProjectID());
    }
}
