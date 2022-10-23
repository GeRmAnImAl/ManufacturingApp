import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProjectAddUI extends JFrame{
    private ProjectAddCntl projectAddCntl;
    private JTextField projectID;
    private JTextField projectStatus;
    private JTextField estStartDate;
    private JTextField actStartDate;
    private JTextField estFinishDate;
    private JTextField actFinishDate;
    private JTextField projectPrice;
    private JTextArea projectDescription;
    private JButton saveButton;
    private JButton cancelButton;
    private JPanel mainPanel;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


    public int getProjectID() {
        return Integer.parseInt(String.valueOf(projectID.getText()));
    }

    public String getProjectStatus() {
        return String.valueOf(projectStatus.getText());
    }

    public LocalDate getEstStartDate() {
        return LocalDate.parse(String.valueOf(estStartDate.getText()), formatter);
    }

    public LocalDate getActStartDate() {
        return LocalDate.parse(String.valueOf(actStartDate.getText()), formatter);

    }

    public LocalDate getEstFinishDate() {
        return LocalDate.parse(String.valueOf(estFinishDate.getText()), formatter);

    }

    public LocalDate getActFinishDate() {
        return LocalDate.parse(String.valueOf(actFinishDate.getText()), formatter);
    }

    public double getProjectPrice() {
        return Double.parseDouble(String.valueOf(projectPrice.getText()));
    }

    public String getProjectDescription() {
        return String.valueOf(projectDescription.getText());
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public ProjectAddUI(ProjectAddCntl projectAddCntl){
    setContentPane(mainPanel);
    setSize(700, 800);
    this.projectAddCntl = projectAddCntl;

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
}
}
