package MainCode.MVP;
import MainCode.Toss.ToyTossService;
import MainCode.Models.Toy;
import java.io.*;
import java.util.List;

public class Model {
    ToyTossService currentToyTossService;
    private final String path;
    public Model(String path) {
        currentToyTossService = new ToyTossService();
        this.path = path;
    }
    public void load() {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String toyId = reader.readLine();
            while (toyId!= null) {
                String name = reader.readLine();
                String weight = reader.readLine();
                this.currentToyTossService.putForToss(new Toy(Integer.parseInt(toyId), name, Integer.parseInt(weight)));
                toyId = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Ошибка, создайте файл prizes здесь " + path);
            e.printStackTrace();
        }
    }
    public void save() {

        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentToyTossService.count(); i++) {
                Toy toy = currentToyTossService.getToy(i);
                writer.append(String.format("%s\n", toy.getId()));
                writer.append(String.format("%s\n", toy.getName()));
                writer.append(String.format("%s\n", toy.getWeight()));
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ToyTossService currentToss() {
        return this.currentToyTossService;
    }

    public void saveResult(String pathResult, List<Toy> toysList) {
        try (FileWriter writer = new FileWriter(pathResult, false)) {
            for (Toy toy : toysList) {
                writer.append(String.format("%s  ", toy.getId()));
                writer.append(String.format("%s  ", toy.getName()));
                writer.append(String.format("%s  ", toy.getWeight()));
                writer.append("\n");
                writer.flush();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}