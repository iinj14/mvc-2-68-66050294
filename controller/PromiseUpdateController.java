package controller;
import model.*;
import repo.*;
import view.PromiseUpdateView;
import java.time.LocalDate;

public class PromiseUpdateController {
    private PromiseUpdateView view;
    private PromiseUpdateRepo updateRepo;
    private PromiseRepo promiseRepo;
    private PromiseModel promise;

    public PromiseUpdateController(String promiseId) {
        view = new PromiseUpdateView();
        updateRepo = new PromiseUpdateRepo();
        promiseRepo = new PromiseRepo();
        promise = promiseRepo.findById(promiseId);

        if (promise == null || !promise.canUpdate()) {
            view.showError("cannot add update for this promise (Status: เงียบหาย)");
            view.dispose();
            new PromiseDetailController(promiseId);
            return;
        }

        view.btnSave.addActionListener(e -> saveUpdate());
        view.btnCancel.addActionListener(e -> {
            view.dispose();
            new PromiseDetailController(promiseId);
        });
    }

    private void saveUpdate() {
        String detail = view.getDetail().trim();
        if (detail.isEmpty()) {
            view.showError("input your update detail");
            return;
        }
        PromiseUpdate update = new PromiseUpdate(promise.getPromiseId(), LocalDate.now(), detail);
        updateRepo.addUpdate(update);
        view.dispose();
        new PromiseDetailController(promise.getPromiseId());
    }
}