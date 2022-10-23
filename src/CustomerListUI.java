import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerListUI extends JFrame {
    private CustomerCntl customerCntl;

    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JTable customerTable;
    private JButton quitButton;
    private JButton detailsButton;
    private JButton newButton;
    private JScrollPane tableScroller;
    private ButtonListener listener = new ButtonListener();

    public CustomerListUI(CustomerCntl customerCntl){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.customerCntl = customerCntl;
        initComponents();
    }

    public void initComponents(){
        tablePanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1,4));

        customerTable = new JTable(customerCntl.getCustomerTableModel());
        customerTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        customerTable.getColumnModel().getColumn(1).setPreferredWidth(50);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(listener);
        detailsButton = new JButton("Show Details");
        detailsButton.addActionListener(listener);
        newButton = new JButton("New");
        newButton.addActionListener(listener);

        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(quitButton);

        tableScroller = new JScrollPane(customerTable);
        customerTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(350,300));
        tablePanel.add(tableScroller);

        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
    }

    public class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();
            if(source == quitButton){
                System.exit(0);
            }
            else if(source == newButton){
                CustomerListUI.this.customerCntl.getBlankCustomerUI();

            }
            else if(source == detailsButton) {
                int selectedTableRow = customerTable.getSelectedRow();
                int selectedModelRow = customerTable.convertRowIndexToModel(selectedTableRow);
                if (selectedModelRow < 0) {
                    selectedModelRow = 0;
                }
                CustomerListUI.this.customerCntl.getCustomerUI(selectedModelRow);
            }
        }
    }
}
