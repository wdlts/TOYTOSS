package MainCode.MVP;
import MainCode.Models.Toy;
import java.util.List;

public interface View {
    int getToyId();
    String getToyNaming();
    int getToyWeight();
    void setToyId(int value);
    void setToyNaming(String value);
    void setToyWeight(int value);
    void showAll(List<Toy> toys);
    boolean clearAllDecision();
    void savedAll();
    void savedItem();
    void saveError();
    void emptyListMessage();
    void showGetToy(Toy toy);
    void loadMessage();
    int getTossTimes();
}