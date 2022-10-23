import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ProjectUI extends JFrame{
    private final ProjectCntl projectCntl;
    private HashMap<Integer, Project> openProjects;
    private ArrayList<Integer> openProjectKeys;
    private int currentProject = 0;
    private Project project;
    private JTextField projectID;
    private JTextField projectStatus;
    private JTextField estStartDate;
    private JTextField actStartDate;
    private JTextField estFinishDate;
    private JTextField actFinishDate;
    private JTextField projectPrice;
    private JTextArea projectDescription;
    private JButton previousButton;
    private JButton addProjectButton;
    private JButton deleteProjectButton;
    private JButton nextButton;
    private JButton updateProjectButton;
    private JButton quitButton;
    private JPanel mainPanel;

    public HashMap<Integer, Project> getOpenProjects() {
        return openProjects;
    }



    public ArrayList<Integer> getOpenProjectKeys() {
        return openProjectKeys;
    }



    public int getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(int currentProject) {
        this.currentProject = currentProject;
    }

    public Project getProject() {
        return project;
    }



    public JTextField getProjectID() {
        return projectID;
    }



    public JTextField getProjectStatus() {
        return projectStatus;
    }



    public JTextField getEstStartDate() {
        return estStartDate;
    }



    public JTextField getActStartDate() {
        return actStartDate;
    }



    public JTextField getEstFinishDate() {
        return estFinishDate;
    }



    public JTextField getActFinishDate() {
        return actFinishDate;
    }



    public JTextField getProjectPrice() {
        return projectPrice;
    }



    public JTextArea getProjectDescription() {
        return projectDescription;
    }



    public JButton getPreviousButton() {
        return previousButton;
    }



    public JButton getAddProjectButton() {
        return addProjectButton;
    }



    public JButton getDeleteProjectButton() {
        return deleteProjectButton;
    }



    public JButton getNextButton() {
        return nextButton;
    }



    public JButton getUpdateProjectButton() {
        return updateProjectButton;
    }



    public JButton getQuitButton() {
        return quitButton;
    }



    public ProjectUI(ProjectCntl projectCntl) {
        setContentPane(mainPanel);
        setSize(700, 800);
        this.projectCntl = projectCntl;
        this.openProjects = projectCntl.getOpenProjects();
        this.openProjectKeys = new ArrayList<>(this.openProjects.keySet());
        Collections.sort(openProjectKeys);
        project = openProjects.get(openProjectKeys.get(currentProject));
        parseProject(project);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void parseProject(Project project){
        projectID.setText(String.valueOf(project.getProjectID()));
        projectStatus.setText(project.getStatus());
        estStartDate.setText(String.valueOf(project.getEstimatedStart()));
        actStartDate.setText(String.valueOf(project.getActualStart()));
        estFinishDate.setText(String.valueOf(project.getEstimatedFinish()));
        actFinishDate.setText(String.valueOf(project.getActualFinish()));
        projectPrice.setText("$" + project.getPrice());
        projectDescription.setText(project.getDescription());
    }
}
