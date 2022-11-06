import javax.swing.*;

public class LoginUI extends JFrame{
    private JTextField userNameTextField;
    private JButton loginButton;
    private JButton quitButton;
    private JRadioButton employeeRadioButton;
    private JRadioButton customerRadioButton;
    private JPasswordField passwordField1;
    private JPanel mainPanel;
    private JLabel messageField;


    public LoginUI(){
        setContentPane(mainPanel);
        setSize(350, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public JTextField getUserNameTextField() {
        return userNameTextField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public JRadioButton getEmployeeRadioButton() {
        return employeeRadioButton;
    }

    public JRadioButton getCustomerRadioButton() {
        return customerRadioButton;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getMessageField() {
        return messageField;
    }

    public void setMessageField(JLabel messageField) {
        this.messageField = messageField;
    }
}

