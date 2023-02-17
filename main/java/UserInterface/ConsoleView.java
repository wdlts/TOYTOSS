package UserInterface;
import java.util.List;
import java.util.Scanner;
import PathDB.PathToDb;
import MainCode.MVP.View;
import MainCode.Models.Toy;
public class ConsoleView implements View {
    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in);
    }
    @Override
    public int getToyId() {
        System.out.print("id игрушки: ");
        return Integer.parseInt(in.nextLine());
    }
    @Override
    public void setToyId(int value) {
        System.out.printf("id игрушки: %s\n", value);
    }
    @Override
    public String getToyNaming() {
        System.out.print("Название игрушки: ");
        return in.nextLine();
    }
    @Override
    public void setToyNaming(String value) {
        System.out.printf("Название игрушки: %s\n", value);
    }
    @Override
    public int getToyWeight() {
        System.out.print("Вес игрушки: ");
        return Integer.parseInt(in.nextLine());
    }
    @Override
    public void setToyWeight(int value) {
        System.out.printf("Вес игрушки: %s\n", value);
    }
    @Override
    public void showAll(List<Toy> toys) {
        System.out.println("\nВсе игрушки для розыгрыша:");
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }
    @Override
    public void showGetToy(Toy toy) {
        System.out.print("\nРезультат розыгрыша: ");
        System.out.println(toy);
    }
    @Override
    public void loadMessage() {
        //System.out.println("\nФайл загружен");
    }
    @Override
    public boolean clearAllDecision() {
        boolean f = false;
        System.out.print("\nУдалить все записи (д/н): ");
        if (in.nextLine().equalsIgnoreCase("д")) {
            f = true;
        }
        return f;
    }
    @Override
    public void savedAll() {
        System.out.println("\nВсе записи сохранены в файл: " + PathToDb.pathDb);
    }
    @Override
    public void savedItem() {
        System.out.println("\nУспешное сохранение в текущий розыгрыш");
    }
    @Override
    public void saveError() {
        System.out.println("\nНе удалось сохранить в текущий розыгрыш");
    }
    @Override
    public void emptyListMessage() {
        System.out.println("Список игрушек пуст!");
    }
    @Override
    public int getTossTimes() {
        System.out.print("Сколько розыгрышей вы хотите провести?: ");
        return Integer.parseInt(in.nextLine());
    }
}