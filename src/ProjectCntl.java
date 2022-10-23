import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.HashMap;

public class ProjectCntl implements ActionListener {
    private Library library;
    private final ProjectUI projectUI;
    ProjectAddCntl projectAddCntl;

    public ProjectCntl(){
        library = new Library();
        projectUI = new ProjectUI(this);
        addALButtons();
        projectUI.setVisible(true);
    }

    public void addALButtons(){
        projectUI.getNextButton().addActionListener(this);
        projectUI.getPreviousButton().addActionListener(this);
        projectUI.getAddProjectButton().addActionListener(this);
        projectUI.getUpdateProjectButton().addActionListener(this);
        projectUI.getDeleteProjectButton().addActionListener(this);
        projectUI.getQuitButton().addActionListener(this);
    }

    public HashMap<Integer, Project> getOpenProjects(){
        return library.getOpenProjects();
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if(source == projectUI.getNextButton()){
            goNext();
        }
        else if (source == projectUI.getPreviousButton()) {
            goPrevious();
        }
        else if (source == projectUI.getAddProjectButton()) {
            goAddProject();
        }
        else if(source == projectUI.getUpdateProjectButton()){
            goUpdateProject();
        }
        else if(source == projectUI.getDeleteProjectButton()){
            goDeleteProject();
        }
        else if(source == projectUI.getQuitButton()){
            projectUI.dispose();
        }
    }

    private void goDeleteProject() {
        projectUI.getOpenProjects().remove(projectUI.getOpenProjectKeys().get(projectUI.getCurrentProject()));
        projectUI.getOpenProjectKeys().remove(projectUI.getCurrentProject());
    }

    // Couldn't get this to work properly
    private void goUpdateProject() {
        Project project = projectAddCntl.getOpenProjects().get(projectAddCntl.getProjectKeys().get(0));
        library.getOpenProjects().put(projectAddCntl.getProjectKeys().get(0), project);
        projectUI.getOpenProjectKeys().add(project.getProjectID());
        Collections.sort(projectUI.getOpenProjectKeys());
    }

    private void goAddProject() {
        projectAddCntl = new ProjectAddCntl();
    }


    private void goPrevious() {
        if(projectUI.getCurrentProject() == 0){
            projectUI.setCurrentProject(projectUI.getOpenProjectKeys().size() - 1);
            projectUI.parseProject(projectUI.getOpenProjects().get(projectUI.getOpenProjectKeys().get(projectUI.getCurrentProject())));

        }
        else{
            projectUI.setCurrentProject(projectUI.getCurrentProject() - 1);
            projectUI.parseProject(projectUI.getOpenProjects().get(projectUI.getOpenProjectKeys().get(projectUI.getCurrentProject())));
        }
    }

    private void goNext(){
        if(projectUI.getCurrentProject() == projectUI.getOpenProjectKeys().size() - 1){
            projectUI.setCurrentProject(0);
            projectUI.parseProject(projectUI.getOpenProjects().get(projectUI.getOpenProjectKeys().get(projectUI.getCurrentProject())));
        }
        else{
            projectUI.setCurrentProject(projectUI.getCurrentProject() + 1);
            projectUI.parseProject(projectUI.getOpenProjects().get(projectUI.getOpenProjectKeys().get(projectUI.getCurrentProject())));
        }

    }
}
