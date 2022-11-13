import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ListIterator;

public class ProjectQueue {
    private LocalDate startDate = LocalDate.now();
    private LinkedList<Order> projectList = new LinkedList<>();


    public ProjectQueue(){
        buildTestQueue();
        printProjectQueue();

    }

    public void printProjectQueue() {
        ListIterator<Order> projectListIterator = projectList.listIterator();
        while(projectListIterator.hasNext()){
            System.out.println(projectListIterator.next().toString());
        }
        System.out.println();
    }

    private void buildTestQueue() {
        LocalDate newDate = LocalDate.now().plusDays(5);
        Project fence = new Project(123, """
                Customer would like a fence for their garden. The fence should be black, with a gothic look.
                the fence should have gold leaf and fleur de lis as decoration. The fence should measure 10'x 6'
                and will need to be cemented into the ground.""",
                "Open", newDate.plusDays(8), newDate.plusDays(8), newDate.plusMonths(1),
                newDate.plusMonths(1), 17.58);
        Order orderOne = new Order(fence, fence.getActualStart(), fence.getActualFinish());
        projectList.add(orderOne);

        Project gate = new Project(124, """
                Customer wants a small gate to keep their pomeranian from escaping an enclosure. The gate should
                have a modern aesthetic while remaining functional. Customer has chosen to have the gate powder
                coated in a pale blue to match the dog house in the enclosure.""",
                "Open", newDate.plusDays(15), newDate.plusDays(15), newDate.plusMonths(2),
                newDate.plusMonths(2), 17.58);
        Order orderTwo = new Order(gate, gate.getActualStart(), gate.getActualFinish());
        addOrder(orderTwo);

        Project railing = new Project(125, """
                Customer wants a handicap railing for their business. Railing will be 5' x 3' and use rounded
                aluminium. There should be a loop at both ends for users to grab easily. Must comply with USADA
                standards and codes.""",
                "Open", newDate.plusDays(7), newDate.plusDays(7), newDate.plusMonths(1),
                newDate.plusMonths(1), 17.58);
        Order orderThree = new Order(railing, railing.getActualStart(), railing.getActualFinish());
        addOrder(orderThree);

        Project banister = new Project(126, """
                Customer would like a simple banister for a small flight of stairs in their home. The banister
                should resemble the branch of a tree. To achieve this look, there should be many bends in the
                banister and nubs will need to be added. The banister is to be aesthetically pleasing while
                remaining fully functional for users.""",
                "Open", newDate.plusDays(6), newDate.plusDays(6), newDate.plusMonths(1).plusDays(2),
                newDate.plusMonths(1).plusDays(2), 17.58);
        Order orderFour = new Order(banister, banister.getActualStart(), banister.getActualFinish());
        addOrder(orderFour);
    }


    public void addOrder(Order newProject){
        boolean orderAdded = false;
        boolean insertDecision = false;
        ListIterator<Order> projectListIterator = projectList.listIterator();

        while(projectListIterator.hasNext()){
            insertDecision = projectListIterator.next().decideToInsert(newProject);
            if(insertDecision){
                projectList.add(projectListIterator.previousIndex(), newProject);
                orderAdded = true;
                break;
            }
        }

        if(orderAdded == false){
            projectList.add(newProject);
        }
    }

    public void removerOrder(Order orderToRemove){
        projectList.remove(orderToRemove);
    }

    public Order getOrder(String thingToSearch){
        ListIterator<Order> projectListIterator = projectList.listIterator();

        while(projectListIterator.hasNext()){
            if(String.valueOf(projectListIterator.next().getProject().getProjectID()).equals(thingToSearch)){
                System.out.println("Project found.");
                return projectListIterator.previous();
            }
        }
        System.out.println("Project not found.");
        return null;
    }
}
