package controller;

import view.MenuView;

public class MenuController {
    private MenuView menuView;
   
   /* 
    public void openPromiseDetail(){
        menuView.dispose();
        new PromiseDetailController(AppSession.getPromiseId());
        
    }
    public void openPromiseUpdate(){
        menuView.dispose();
        new PromiseUpdateController(AppSession.getPromiseId());
        
    }
   */
   
    public MenuController(){
        menuView = new MenuView();
        menuView.btnPromiseList.addActionListener(e -> {
            menuView.dispose();
            new PromiseListController();
        });
        menuView.btnPolitician.addActionListener(e -> {
            menuView.dispose();
            new PoliticianController();
        });
        menuView.btnPromiseDetail.setEnabled(false);
        menuView.btnPromiseUpdate.setEnabled(false);
    }
}



