package controller;
import repo.PoliticianRepo;
import repo.PromiseRepo;
import view.PoliticianView;

import java.util.List;

import model.PromiseModel;

public class PoliticianController {

    private PoliticianView view;
    private PoliticianRepo politicianRepo;
    private PromiseRepo promiseRepo;

    public PoliticianController() {
        view = new PoliticianView();
        politicianRepo = new PoliticianRepo();
        promiseRepo = new PromiseRepo();

        view.showPoliticians(politicianRepo.getAll());

        view.onSelectPolitician(id -> {
            List<PromiseModel> promises = promiseRepo.findByPolitician(id);
            view.showPromises(promises);
        });
    }
}
