package repo;

import model.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class PromiseUpdateRepo {

    public List<PromiseUpdate> getByPromise(String pid) {
        List<PromiseUpdate> list = new ArrayList<>();
        try (BufferedReader br =
             new BufferedReader(new FileReader("data/promiseUpdates.csv"))) {
            br.readLine();
            String l;
            while ((l = br.readLine()) != null) {
                String[] d = l.split(",");
                if (d[0].equals(pid)) {
                    list.add(new PromiseUpdate(d[0], LocalDate.parse(d[1]), d[2]));
                }
            }
        } catch (Exception e) {}
        return list;
    }

    public void addUpdate(PromiseUpdate u) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/promiseUpdates.csv", true))) {
            pw.println(u.getPromiseId()+","+u.getUpdateDate()+","+u.getUpdateDetail());
        } catch (Exception e) {}
    }
}
