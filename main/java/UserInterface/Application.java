package UserInterface;
import PathDB.PathToDb;
import MainCode.MVP.Presenter;
import MainCode.Models.Toy;
import java.util.Scanner;
public class Application {
    public static void startApplication() {
        Presenter presenter = new Presenter(new ConsoleView(), PathToDb.pathDb);
        presenter.loadFromFile();
        String id;
        String command;
        while (true) {
            command = prompt("""

                    1. Добавить игрушку для розыгрыша
                    2. Удалить игрушку из розыгрыша
                    3. Разыграть игрушки и показать результат
                    4. Показать игрушки, доступные для розыгрыша
                    5. Удалить все записи
                    6. Сохранить все записи в файл
                    7. Загрузить все записи из файла
                    8. Выход
                    Выберите действие:\s""");
            if (command.equals("8")) {
                return;
            }
            try {
                switch (command) {
                    case "1" -> presenter.putForToss();
                    case "2" -> presenter.deleteFromToss();
                    case "3" -> presenter.getToss();
                    case "4" -> presenter.showAll();
                    case "5" -> presenter.clearAll();
                    case "6" -> presenter.saveToFile();
                    case "7" -> presenter.loadFromFile();
                    default -> System.out.println("\n Такой команды нет!");
                }
            } catch (Exception e) {
                System.out.println("Ошибка. " + e.getMessage());
            }
        }
    }
    private static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    private static Toy toyCreate() {
        int id = Integer.parseInt(prompt("Введите id игрушки: "));
        String name = prompt("Введите название игрушки: ");
        String weight = prompt("Введите вес игрушки: ");
        return (new Toy(id, name, Integer.parseInt(weight)));
    }
}