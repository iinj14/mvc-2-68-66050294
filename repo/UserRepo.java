package repo;


import model.UserModel;
import model.Role;

import java.io.*;
import java.util.*;

public class UserRepo {

    private List<UserModel> users = new ArrayList<>();

    public UserRepo() {
        loadFromCSV();
    }

    private void loadFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/account.csv"))) {
            String line;
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length >= 3) {
                    String username = data[0].trim();
                    String password = data[1].trim();
                    Role role = Role.valueOf(data[2].trim());

                    users.add(new UserModel(username, password, role));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserModel login(String username, String password) {
        for (UserModel u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public List<UserModel> getAllUsers() {
        return new ArrayList<>(users);
    }
    
}
