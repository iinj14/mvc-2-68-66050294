package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.PoliticianModel;
import model.PromiseModel;

public class PoliticianView extends JFrame {
    private JComboBox<String> comboPolitician;
    private DefaultTableModel model;
    private JTable table;

    public PoliticianView() {
        setTitle("Politician's Promises");
        setSize(700, 400);
        setLocationRelativeTo(null);
        comboPolitician = new JComboBox<>();
        model = new DefaultTableModel(new String[]{"ID", "Promise", "Status"}, 0);
        table = new JTable(model);
        setLayout(new BorderLayout());
        add(comboPolitician, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        setVisible(true);
    }

    public void showPoliticians(List<PoliticianModel> list) {
        comboPolitician.removeAllItems();
        for (PoliticianModel p : list) {
            comboPolitician.addItem(p.getPoliticianId() + " - " + p.getName());
        }
    }

    public void showPromises(List<PromiseModel> promises) {
        model.setRowCount(0);
        for (PromiseModel p : promises) {
            model.addRow(new Object[]{p.getPromiseId(), p.getDesc(), p.getStatus()});
        }
    }

    public void onSelectPolitician(java.util.function.Consumer<String> callback) {
        comboPolitician.addActionListener(e -> {
            Object selected = comboPolitician.getSelectedItem();
            if (selected != null) {
                String id = selected.toString().split(" - ")[0];
                callback.accept(id);
            }
        });
    }
}