import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int command = scanner.nextInt();

        StepTracker stepTracker = new StepTracker();

        while (command != 0) {

            if (command == 1) {
                System.out.println("Сначала укажите месяц, в котором хотите ввести количество шагов. " +
                        "0 - Январь, 1 - Февраль, 2 - Март, ..., 10 - Ноябрь, 11 - Декабрь");
                int month = scanner.nextInt();
                System.out.println("Введите порядковый номер дня (от 1 до 30), " +
                        "за который хотите внести данные по пройденным шагам:");
                int day = scanner.nextInt();
                System.out.println("Введите количество пройденных шагов:");
                int steps = scanner.nextInt();
                stepTracker.saveStepsAtDay(month, day, steps);
            } else if (command == 2) {
                System.out.println("Введите номер месяца, за который следует вывести статистику, в следующем формате " +
                        "0 - Январь, 1 - Февраль, 2 - Март, ..., 10 - Ноябрь, 11 - Декабрь");
                int month = scanner.nextInt();
                stepTracker.printStatistic(month);
            } else if (command == 3) {
                System.out.println("Текущая цель по шагам: " + stepTracker.targetNumberOfSteps +
                        ". Укажите новое целевое количество шагов в день:");
                int targetNumberOfSteps = scanner.nextInt();
                stepTracker.changeTargetNumberOfSteps(targetNumberOfSteps);
            } else if (command == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Указанной команды не существует. Выберите команду из предложенных в списке");
            }

            printMenu();
            command = scanner.nextInt();

        }

    }

    public static void printMenu() {

        System.out.println("Выберите одно из следующих действий и введите код команды:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");

    }

}
