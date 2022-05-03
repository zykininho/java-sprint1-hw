public class StepTracker {

    int targetNumberOfSteps = 10000;

    Converter converter = new Converter();

    int[][] monthToData;

    public StepTracker() {
        monthToData = new int[12][30];
        for (int i = 0; i < monthToData.length; i++) {
            for (int j = 0; j < monthToData[i].length; j++) {
                monthToData[i][j] = 0;
            }
        }
    }

    void saveStepsAtDay(int month, int day, int steps) {
        if (steps < 0) {
            System.out.println("Количество шагов должно быть положительным");
            return;
        }
        monthToData[month][day - 1] = steps;
        System.out.println("Количество шагов за день успешно сохранено");
    }

    void printStatistic(int month) {

        // Количество пройденных шагов по дням
        printStepsByDay(month);

        System.out.println("Общее количество шагов за месяц: " + getSumOfSteps(month));
        System.out.println("Максимальное пройденное количество шагов в месяце: " + getMaxSteps(month));
        System.out.println("Среднее количество шагов: " + getAverageNumberOfSteps(month));
        System.out.println("Пройденная дистанция (в км): " + getLength(month));
        System.out.println("Количество сожжённых килокалорий " + getCalories(month));

        /* Максимальное количество подряд идущих дней,
         в течение которых количество шагов за день было равно или выше целевого*/
        System.out.println("Лучшая серия в днях: " + getSeriesOfTargetDays(month));

    }

    void changeTargetNumberOfSteps(int targetNumberOfSteps) {
        if (targetNumberOfSteps < 0) {
            System.out.println("Целевое количество шагов должно быть положительным");
            return;
        }
        this.targetNumberOfSteps = targetNumberOfSteps;
    }

    void printStepsByDay(int month) {
        System.out.println("Количество пройденных шагов по дням:");
        for (int i = 0; i < monthToData[month].length; i++) {
            if (i == monthToData[month].length - 1) {
                System.out.println((i + 1) + " день: " + monthToData[month][i]);
                return;
            }
            System.out.print((i + 1) + " день: " + monthToData[month][i] + ", ");
        }
    }

    int getSumOfSteps(int month) {
        int numberOfSteps = 0;
        for (int i = 0; i < monthToData[month].length; i++) {
            numberOfSteps = numberOfSteps + monthToData[month][i];
        }
        return numberOfSteps;
    }

    int getMaxSteps(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthToData[month].length; i++) {
            if (monthToData[month][i] > maxSteps) {
                maxSteps = monthToData[month][i];
            }
        }
        return maxSteps;
    }

    double getAverageNumberOfSteps(int month) {
        int numberOfSteps = getSumOfSteps(month);
        return (numberOfSteps / monthToData[month].length);
    }

    double getLength(int month) {
        int numberOfSteps = getSumOfSteps(month);
        double length = converter.convertStepsIntoLength(numberOfSteps);
        return length;
    }

    double getCalories(int month) {
        int numberOfSteps = getSumOfSteps(month);
        double calories = converter.convertStepsIntoCalories(numberOfSteps);
        return calories;
    }

    int getSeriesOfTargetDays(int month) {
        int maxSeriesOfDays = 0;
        int seriesOfDays = 0;

        for (int i = 0; i < monthToData[month].length; i++) {
            if (monthToData[month][i] >= targetNumberOfSteps) {
                seriesOfDays = seriesOfDays + 1;
            } else {
                if (seriesOfDays > 0) {
                    if (seriesOfDays > maxSeriesOfDays) {
                        maxSeriesOfDays = seriesOfDays;
                    }
                    seriesOfDays = 0;
                }
            }
        }

        return maxSeriesOfDays;
    }

}
