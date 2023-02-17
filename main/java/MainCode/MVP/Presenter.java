package MainCode.MVP;
import MainCode.Models.Toy;
import PathDB.PathToDb;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
public class Presenter {
    private final Model model;
    private final View view;
    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }
    public void loadFromFile() {
        model.load();
        view.loadMessage();
    }
    public void putForToss() {
        if (model.currentToss().putForToss(
                new Toy(view.getToyId(), view.getToyNaming(), view.getToyWeight())))
            view.savedItem();
        else
            view.saveError();
    }
    public void deleteFromToss() {
        if (model.currentToyTossService.getToys().size() == 0)
            view.emptyListMessage();
        else
            model.currentToss().remove(view.getToyId());
    }
    public void saveToFile() {
        model.save();
        view.savedAll();
    }
    public void showAll() {
        if (model.currentToyTossService.getToys().size() == 0)
            view.emptyListMessage();
        else
            view.showAll(model.currentToyTossService.getToys());
    }
    public void clearAll() {
        if (model.currentToyTossService.getToys().size() == 0)
            view.emptyListMessage();
        else {
            if (view.clearAllDecision()) {
                model.currentToyTossService.getToys().clear();
                System.out.println("Все записи удалены!");
            }
        }
    }
    public void getToss() {
        PriorityQueue<Toy> priorityQueue = new PriorityQueue<>();
        Toy tossedToy;
        List<Toy> drawnToys = new ArrayList<>();
        if (model.currentToyTossService.getToys().size() != 0) {
            int times = view.getTossTimes();
            priorityQueue.addAll(model.currentToss().getToys());
            while (priorityQueue.size() < times) {
                priorityQueue.addAll(model.currentToss().getToys());
            }
            for (int i = 0; i < times; i++) {
                tossedToy = priorityQueue.remove();
                view.showGetToy(tossedToy);
                drawnToys.add(tossedToy);
            }
            model.saveResult(PathToDb.pathResult, drawnToys);
        } else
            view.emptyListMessage();
    }
}