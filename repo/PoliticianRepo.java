package repo;


import model.PoliticianModel;

import java.io.*;
import java.util.*;

public class PoliticianRepo {
    private List<PoliticianModel> politicians = new ArrayList<>();

    public PoliticianRepo() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/politicians.csv"))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                politicians.add(new PoliticianModel(
                        d[0], d[1], d[2]
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PoliticianModel> getAll() {
        return politicians;
    }

    public PoliticianModel findById(String id) {
        return politicians.stream()
                .filter(p -> p.getPoliticianId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
