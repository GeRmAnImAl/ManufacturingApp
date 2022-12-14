import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private boolean flagged = false;
    private String flagReason;

    public User(String firstName, String lastName, String email, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFlagged(){
        return this.flagged;
    }

    public void setFlagged(boolean flagged){
        this.flagged = flagged;
    }

    public String getFlagReason(){
        return this.flagReason;
    }

    public void setFlagReason(String reason){
        this.flagReason = reason;
    }

    public void createFlag(String reason){
        this.flagged = true;
        this.flagReason = reason;
    }
}
