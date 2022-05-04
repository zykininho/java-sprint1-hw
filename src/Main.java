import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        printMenu();
        int command = scanner.nextInt();

        // Вынес операции ввода-вывода в отдельные методы, как ты и указал.
        // Единственное, оставил эти операции в текущем классе согласно постановке задачи
        while (command != 0) {

            if (command == 1) {
                Map dataSteps = getDataSteps(scanner);
                stepTracker.saveStepsAtDay(dataSteps);
            } else if (command == 2) {
                int month = getMonth(scanner);
                stepTracker.printStatistic(month);
            } else if (command == 3) {
                int targetNumberOfSteps = getNumberOfSteps(stepTracker.targetNumberOfSteps, scanner);
                stepTracker.changeTargetNumberOfSteps(targetNumberOfSteps);
            } else if (command == 0) {
                System.out.println("Программа завершена");
                scanner.close();
                break;
            } else {
                System.out.println("Указанной команды не существует. Выберите команду из предложенных в списке");
            }

            printMenu();
            command = scanner.nextInt();

        }

    }

    private static void printMenu() {

        System.out.println("Выберите одно из следующих действий и введите код команды:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");

    }

    private static Map getDataSteps(Scanner scanner) {

        HashMap<String, Integer> dataSteps = new HashMap<>();

        System.out.println("Сначала укажите месяц, в котором хотите ввести количество шагов. " +
                "0 - Январь, 1 - Февраль, 2 - Март, ..., 10 - Ноябрь, 11 - Декабрь");
        int month = scanner.nextInt();
        dataSteps.put("month", month);

        System.out.println("Введите порядковый номер дня (от 1 до 30), " +
                "за который хотите внести данные по пройденным шагам:");
        int day = scanner.nextInt();
        dataSteps.put("day", day);

        System.out.println("Введите количество пройденных шагов:");
        int steps = scanner.nextInt();
        dataSteps.put("steps", steps);

        return dataSteps;

    }

    private static int getMonth(Scanner scanner) {

        System.out.println("Введите номер месяца, за который следует вывести статистику, в следующем формате " +
                "0 - Январь, 1 - Февраль, 2 - Март, ..., 10 - Ноябрь, 11 - Декабрь");
        int month = scanner.nextInt();
        return month;

    }

    private static int getNumberOfSteps(int currentTarget, Scanner scanner) {

        System.out.println("Текущая цель по шагам: " + currentTarget +
                ". Укажите новое целевое количество шагов в день:");
        int NUmberOfSteps = scanner.nextInt();
        return NUmberOfSteps;

    }

}
