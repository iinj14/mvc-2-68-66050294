package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.*;

public class PromiseDetailView extends JFrame {
    private JLabel lblTitle, lblPolitician, lblStatus;
    private JTextArea txtDescription;
    private JTable table;
    private DefaultTableModel model;
    public JButton btnAddUpdate, btnBack;

    public PromiseDetailView() {
        setTitle("Promise Detail");
        setSize(800, 500);
        setLocationRelativeTo(null);
        lblTitle = new JLabel();
        lblPolitician = new JLabel();
        lblStatus = new JLabel();
        txtDescription = new JTextArea();
        txtDescription.setEditable(false);
        model = new DefaultTableModel(new String[]{"Date", "Detail"}, 0);
        table = new JTable(model);
        btnAddUpdate = new JButton("Add Update");
        btnBack = new JButton("Back");
        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        infoPanel.add(lblTitle);
        infoPanel.add(lblPolitician);
        infoPanel.add(lblStatus);
        JPanel southPanel = new JPanel();
        southPanel.add(btnAddUpdate);
        southPanel.add(btnBack);
        setLayout(new BorderLayout());
        add(infoPanel, BorderLayout.NORTH);
        add(new JScrollPane(txtDescription), BorderLayout.CENTER);
        add(new JScrollPane(table), BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void showPromise(PromiseModel p) {
        lblTitle.setText("Description: " + p.getDesc());
        lblPolitician.setText("Politician ID: " + p.getPoliticianId());
        lblStatus.setText("Status: " + p.getStatus());
        txtDescription.setText(p.getDesc());
    }

    public void showUpdates(List<PromiseUpdate> updates) {
        model.setRowCount(0);
        for (PromiseUpdate u : updates) {
            model.addRow(new Object[]{u.getUpdateDate(), u.getUpdateDetail()});
        }
    }
}