import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class ProjectAddCntl implements ActionListener {
    private Library library;
    private ProjectAddUI projectAddUI;
    private Project project;
    private ArrayList<Integer> projectKeys;

    public Library getLibrary() {
        return library;
    }


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ArrayList<Integer> getProjectKeys() {
        return projectKeys;
    }

    public ProjectAddCntl(){
        library = new Library();
        projectAddUI = new ProjectAddUI(this);
        addALButtons();
        projectAddUI.setVisible(true);
    }

    public void addALButtons(){
        projectAddUI.getSaveButton().addActionListener(this);
        projectAddUI.getCancelButton().addActionListener(this);

    }

    public HashMap<Integer, Project> getOpenProjects(){
        return library.getOpenProjects();
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if(source == projectAddUI.getSaveButton()){
            goSave();
            projectAddUI.setVisible(false);

        }
        else if(source == projectAddUI.getCancelButton()){
            goCancel();
        }
    }

    private void goCancel() {
        projectAddUI.setVisible(false);
    }

    private void goSave() {
        project = new Project(projectAddUI.getProjectID(), projectAddUI.getProjectDescription(), projectAddUI.getProjectStatus(),
                projectAddUI.getEstStartDate(), projectAddUI.getActStartDate(), projectAddUI.getEstFinishDate(), projectAddUI.getActFinishDate(),
                projectAddUI.getProjectPrice());
        library.getCompletedProjects().put(project.getProjectID(), project);
        projectKeys = new ArrayList<>(library.getOpenProjects().keySet());
    }

}
