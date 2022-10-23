import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CustomerTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "Last Name", "Phone"};
    private ArrayList<Customer> customerList;

    public CustomerTableModel(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }


    @Override
    public int getRowCount() {
        return customerList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (Object) customerList.get(rowIndex).getCustomerID();
            case 1:
                return (Object) customerList.get(rowIndex).getLastName();
            case 2:
                return (Object) customerList.get(rowIndex).getPhoneNumber();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}
