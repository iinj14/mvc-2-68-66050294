package controller;
import view.PromiseListView;
import repo.PromiseRepo;
import java.util.List;
import model.PromiseModel;

public class PromiseListController {
    private PromiseListView view;
    private PromiseRepo repo;

    public PromiseListController(){
        view = new PromiseListView();
        repo = new PromiseRepo();
        loadPromiseList();
        
        view.getBtnViewDetail().addActionListener(e -> {
            String id = view.getSelectedPromiseId();
            if(id != null) {
                view.dispose();
                new PromiseDetailController(id);
            }
        });
        view.setVisible(true);
    }

    private void loadPromiseList(){
        List<PromiseModel> promiseList = repo.getAll();
        view.showPromiseList(promiseList);
    }
}