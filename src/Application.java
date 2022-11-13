import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        //TestHarness testHarness = new TestHarness();

        //ProjectCntl projectCntl = new ProjectCntl();
        //CustomerCntl customerCntl = new CustomerCntl();
        //LoginCntl loginCntl = new LoginCntl();
        ProjectQueue projectQueue = new ProjectQueue();

        // Create project object to use in the creation of a new order object
        LocalDate newDate = LocalDate.now().plusDays(5);
        Project estateGate = new Project(127, """
                Customer would like an Estate Gate for their driveway. The gate should be black, with a gothic look.
                The gate should have a large G monogram adorned with gold leaf. The gate should measure 6'x 12' and
                will be connected to the existing fencing. Customer would also like the gate to be equipped with a
                sensor to automatically open and close the gate.""",
                "Open", newDate.plusDays(1), newDate.plusDays(1), newDate.plusMonths(1),
                newDate.plusMonths(1), 10387.99);
        Order order = new Order(estateGate, estateGate.getActualStart(), estateGate.getActualFinish());

        // Add new order object to ProjectQueue
        projectQueue.addOrder(order);
        projectQueue.printProjectQueue();

        // Search for an order and assign it to a variable to be used with the removal method
        Order orderToRemove = projectQueue.getOrder("125");

        // Remove order object from the ProjectQueue
        projectQueue.removerOrder(orderToRemove);
        projectQueue.printProjectQueue();
    }

}
