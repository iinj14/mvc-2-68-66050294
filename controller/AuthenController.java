package controller;

import model.UserModel;
import repo.UserRepo;
import view.*;

public class AuthenController {
    LoginView LoginView;
    UserRepo u;
    
    public AuthenController(){
        LoginView = new LoginView();
        u = new UserRepo();
        
        LoginView.btnLogin.addActionListener(e -> login());
    }

    private void login(){
        String username = LoginView.getUsername();
        String password = LoginView.getPassword();
        UserModel user = u.login(username, password);

        if(user == null){
            LoginView.showErrorMsg("invalid username or password");
        }else{
            LoginView.showSuccessMsg("login success");

            if(user.getRole().toString().equals("ADMIN")){
                System.out.println("admin logged in");
            }else{
                System.out.println("user logged in");
            }

            LoginView.dispose();
            new MenuController();
            

        }

    }
}
