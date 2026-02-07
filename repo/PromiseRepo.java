package repo;

import model.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class PromiseRepo {
    private List<PromiseModel> promises = new ArrayList<>();

    public PromiseRepo() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/promises.csv"))) {
            br.readLine();
            String l;
            while ((l = br.readLine()) != null) {
                String[] d = l.split(",");
                promises.add(new PromiseModel(d[0], d[1], d[2], LocalDate.parse(d[3]), Status.valueOf(d[4])
                ));
            }
        } catch (Exception e) {
            System.out.println("Error reading CSV at line: " + promises.size() + 1);
            e.printStackTrace();
        }
    }

    public List<PromiseModel> getAll() {
        promises.sort(Comparator.comparing(PromiseModel::getDate));
        return promises;
    }

    public PromiseModel findById(String id) {
        return promises.stream()
                .filter(p -> p.getPromiseId().equals(id))
                .findFirst().orElse(null);
    }

    public List<PromiseModel> findByPolitician(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPolitician'");
    }
    
}
