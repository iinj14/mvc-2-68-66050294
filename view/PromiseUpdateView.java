package view;

import javax.swing.*;
import java.awt.*;

public class PromiseUpdateView extends JFrame {

    private JTextArea txtDetail;
    public JButton btnSave;
    public JButton btnCancel;

    public PromiseUpdateView() {
        setTitle("update");
        setSize(400, 300);
        setLocationRelativeTo(null);

        txtDetail = new JTextArea();
        btnSave = new JButton("save");
        btnCancel = new JButton("cancel");

        setLayout(new BorderLayout());
        add(new JLabel("detail"), BorderLayout.NORTH);
        add(new JScrollPane(txtDetail), BorderLayout.CENTER);
        add(btnSave, BorderLayout.SOUTH);

        setVisible(true);
    }

    public String getDetail() {
        return txtDetail.getText();
    }

    public void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
