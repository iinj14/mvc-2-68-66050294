package controller;
import java.util.List;
import model.*;
import view.*;
import repo.*;

public class PromiseDetailController {
    private PromiseDetailView view;
    private PromiseRepo promiseRepo;
    private PromiseUpdateRepo updateRepo;
    private PromiseModel promise;

    public PromiseDetailController(String promiseId) {
        view = new PromiseDetailView();
        promiseRepo = new PromiseRepo();
        updateRepo = new PromiseUpdateRepo();

        promise = promiseRepo.findById(promiseId);
        view.showPromise(promise);

        List<PromiseUpdate> updates = updateRepo.getByPromise(promiseId);
        view.showUpdates(updates);

        view.btnAddUpdate.addActionListener(e -> {
            view.dispose();
            new PromiseUpdateController(promiseId);
        });
        
        view.btnBack.addActionListener(e -> {
            view.dispose();
            new PromiseListController();
        });

        view.setVisible(true);
    }
}