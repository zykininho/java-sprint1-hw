public class Converter {
    int centi = 100;
    int kilo = 1000;

    double convertStepsIntoLength(int steps) {
        // 1 шаг равен 75 см, возвращаем в километрах
        return steps * 75 / centi / kilo;
    }

    double convertStepsIntoCalories(int steps) {
        // 1 шаг равен 50 калориям, возвращаем в килокалориях
        return steps * 50 / kilo;
    }

}
