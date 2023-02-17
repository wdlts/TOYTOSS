package MainCode.Toss;
import MainCode.Models.Toy;
import java.util.ArrayList;
import java.util.List;
public class ToyTossService {
    private final List<Toy> toys;
    public ToyTossService() {
        this.toys = new ArrayList<>();
    }
    public boolean putForToss(Toy toy) {
        boolean flag = false;
        if (!toys.contains(toy)) {
            this.toys.add(toy);
            flag = true;
        }
        return flag;
    }
    public boolean makeToss() {
        return false;
    }
    public boolean update(int index, Toy toy) {
        boolean flag = false;
        if (indexContains(index) != -1) {
            Toy updatedToy = toys.get(index);
            updatedToy.setName(toy.getName());
            updatedToy.setWeight(toy.getWeight());
            flag = true;
        }
        return flag;
    }
    public Toy getToy(int index) {
        return toys.get(index);
    }
    public void remove(int toyId) {
        if (indexContains(toyId) != -1) {
            toys.remove(indexContains(toyId));
            System.out.println("Успешно удалено!");
        } else
            System.out.println("Не удалено, id не найден!");
    }
    private int indexContains(int index) {
        int searchIndex = -1;
        for (Toy toy : toys) {
            if (toy.getId() == index)
                searchIndex = toys.indexOf(toy);
        }
        return searchIndex;
    }
    public List<Toy> getToys() {
        return toys;
    }
    public int count() {
        return toys.size();
    }
}