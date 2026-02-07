package view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public JTextField u = new JTextField();
    public JPasswordField p = new JPasswordField();
    public JButton btnLogin = new JButton("Login");
    public JLabel msg = new JLabel(" ");

    public LoginView() {
        setTitle("Login");
        setSize(300, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4,2,5,5));
        panel.add(new JLabel("Username:"));
        panel.add(u);
        panel.add(new JLabel("Password:"));
        panel.add(p);
        panel.add(new JLabel(""));
        panel.add(btnLogin);
        panel.add(new JLabel(""));
        panel.add(msg);

        add(panel);
        setVisible(true);
    }

    public String getUsername(){
        return u.getText().trim();
    }

    public String getPassword(){
        return new String(p.getPassword());
    }

    public void showErrorMsg(String text){
        msg.setText(text);
    }

    public void showSuccessMsg(String text){
        msg.setText(text);
    }
}
