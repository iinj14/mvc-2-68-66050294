package view;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame{
    public JButton btnPromiseList = new JButton("Promise List");
    public JButton btnPromiseDetail = new JButton("Promise Detail");
    public JButton btnPromiseUpdate = new JButton("Promise update");
    public JButton btnPolitician = new JButton("Politician's Promise");
    JPanel panel = new JPanel();

    public MenuView(){
        setTitle("Menu");
        setSize(300, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
        panel.add(btnPromiseList);
        panel.add(btnPromiseDetail);
        panel.add(btnPromiseUpdate);
        panel.add(btnPolitician);
        
        add(panel);
        setVisible(true);
    }
    
}
