public class Converter {

    // Денис, да, с понятием "магических чисел" знаком, поэтому и указал переменные centi и kilo,
    // а про основные - забыл. Запомнил на будущее, обязательно исправлюсь
    int lengthOfStepInCentimeters = 75;
    int ratioStepToCalorie = 50;
    int centi = 100;
    int kilo = 1000;

    // метод возвращает длину в километрах
    double convertStepsIntoLength(int steps) {
        return steps * lengthOfStepInCentimeters / centi / kilo;
    }

    // метод возвращает значение в килокалориях
    double convertStepsIntoCalories(int steps) {
        return steps * ratioStepToCalorie / kilo;
    }

}
