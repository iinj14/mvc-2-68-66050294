package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.PromiseModel;

public class PromiseListView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnViewDetail;

    public PromiseListView(){
        setTitle("Promise List");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tableModel = new DefaultTableModel(new String[]{"ID", "Detail", "Date"}, 0);
        table = new JTable(tableModel);
        btnViewDetail = new JButton("View Detail");
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnViewDetail, BorderLayout.SOUTH);
    }

    public void showPromiseList(List<PromiseModel> promises) {
        tableModel.setRowCount(0);
        for (PromiseModel p : promises) {
            tableModel.addRow(new Object[]{p.getPromiseId(), p.getDesc(), p.getDate()});
        }
    }

    public String getSelectedPromiseId() {
        int row = table.getSelectedRow();
        return (row == -1) ? null : tableModel.getValueAt(row, 0).toString();
    }

    public JButton getBtnViewDetail() { return btnViewDetail; }
}